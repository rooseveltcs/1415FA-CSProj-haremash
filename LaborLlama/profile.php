<?php
	include 'config.php';
	//Inclustion of Libraray files
	require_once( 'lib/Facebook/FacebookSession.php');
	require_once( 'lib/Facebook/FacebookRequest.php' );
	require_once( 'lib/Facebook/FacebookResponse.php' );
	require_once( 'lib/Facebook/FacebookSDKException.php' );
	require_once( 'lib/Facebook/FacebookRequestException.php' );
	require_once( 'lib/Facebook/FacebookRedirectLoginHelper.php');
	require_once( 'lib/Facebook/FacebookAuthorizationException.php' );
	require_once( 'lib/Facebook/GraphObject.php' );
	require_once( 'lib/Facebook/GraphUser.php' );
	require_once( 'lib/Facebook/GraphSessionInfo.php' );
	require_once( 'lib/Facebook/Entities/AccessToken.php');
	require_once( 'lib/Facebook/HttpClients/FacebookCurl.php' );
	require_once( 'lib/Facebook/HttpClients/FacebookHttpable.php');
	require_once( 'lib/Facebook/HttpClients/FacebookCurlHttpClient.php');
	//Use Namespaces
	use Facebook\FacebookSession;
	use Facebook\FacebookRedirectLoginHelper;
	use Facebook\FacebookRequest;
	use Facebook\FacebookResponse;
	use Facebook\FacebookSDKException;
	use Facebook\FacebookRequestException;
	use Facebook\FacebookAuthorizationException;
	use Facebook\GraphObject;
	use Facebook\GraphUser;
	use Facebook\GraphSessionInfo;
	use Facebook\FacebookHttpable;
	use Facebook\FacebookCurlHttpClient;
	use Facebook\FacebookCurl;

	session_start();

	 if(isset($_REQUEST['logout'])){
	 	unset($_SESSION['fb_token']);
	 }

	$app_id = "";
	$app_secret = "";
	$redirect_url = "http://www.laborllama.com/fbaccess.php/";

	FacebookSession::setDefaultApplication($app_id,$app_secret);
	$helper = new FacebookRedirectLoginHelper($redirect_url);
	$sess = $helper->getSessionFromRedirect();

	if(isset($_SESSION['fb_token'])){
	 	$sess = new FacebookSession($_SESSION['fb_token']);
	 	try{
			$sess->Validate($id, $secret);
		}catch(FacebookAuthorizationException $e){
			print_r($e);
		}
	}

	$loggedin = false;
	//getting email as well as user permission
	$login_url = $helper->getLoginUrl(array('email'));

	$logout = 'http://www.laborllama.com/';

	if(isset($sess)){
		$_SESSION['fb_token'] = $sess->getToken();
		$request = new FacebookRequest($sess, 'GET', '/me');
		$response = $request->execute();
		$graph = $response->getGraphObject(GraphUser::className());
		$user_name = $graph->getName();
		$user_firstName = $graph->getFirstName();
		$user_lastName = $graph->getLastName();
		$user_id = $graph->getId();
		$user_email = $graph->getProperty('email');
		$loggedin = true;
	}

	//If you have not logged in before, your data is inserted into the userBase table
	$query = "SELECT fbid FROM userBase WHERE fbid = '".$user_id."'";
	$result = mysqli_query($conn, $query);
	$row = mysqli_fetch_row($result);
	if($row[0] == ""){
		$sql = "INSERT INTO userBase (fbid, first_name, last_name, username, email)
		VALUES ('$user_id', '$user_firstName', '$user_lastName', '$user_name', '$user_email')";

		if (mysqli_query($conn, $sql)) {
		    $welcome_message = "Welcome to Labor Llama";
		} else {}
	}

	/*$query = "SELECT about, categories FROM userBase WHERE fbid = '".$user_id."'";
	$result = mysqli_query($conn, $query);
	$row = mysqli_fetch_row($result);
	echo "Here it is: ".$row[0];
	if($row[0] == NULL) {
		echo "Inside the if statement";
		$user_about = $_POST["user_about"];
		$query = "UPDATE userBase SET about='$user_about' WHERE fbid = '".$user_id."'";
		if(mysqli_query($conn, $query)) {
			echo "yay";
		}else {
			echo "boo";
		}
	}
	if($row[1] == NULL) {
		$user_categories = "";
	}*/
	


?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Labor Llama Home</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
  </head>
  <body>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	
	<?php if(!$loggedin){ ?>
		<h3><?php echo $welcome_message."<br>"; ?></h3>
		<a href="<?php echo $login_url; ?>">
			<button class="btn btn-primary">Sign Up with Facebook</button>
		</a>
	<?php }else { ?>
		<h1>hi <b><?php echo $user_name; ?></b> </h1>
	    <p>Email: 
	    	<code><?php echo $user_email; ?></code></p>
	    <a href="<?php echo $logout; ?>">
	    	<button class="btn btn-primary">Logout</button>
	    </a>	
	<?php } ?>

	<?php		

		$query = "SELECT username, first_name FROM userBase WHERE username = '".$userInputName."'";
		$result = mysqli_query($conn, $query);
		$row = mysqli_fetch_row($result);
		$db_username = $row[0];
		$db_first_name = $row[1];
		
		//echo "Here is a line of code that should print out the username from the database (if it exsists): ".$db_username."<br>";
	?>
    
  </body>
</html>