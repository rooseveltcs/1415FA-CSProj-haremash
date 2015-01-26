<?php
		include 'config.php';
		
		/*$query = "SELECT title, description, location FROM workBase";
		$result = mysqli_query($conn, $query);
		$row	= mysqli_fetch_row($result); 
		$db_job_title = $row[0];
		$db_job_description = $row[1];
		$db_job_location = $row[2];
		echo $row[2];
		
		echo "<br> This should display a job title: ".$db_job_title."<br>";
		echo "This should display the job description: ".$db_job_description."<br>";
		//echo "This should display the location of the job: ".$db_job_location."<br>;*/
?>

<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Labor Llama Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
  </head>
  
  <body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	
	<div class="userProfile">
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="http://www.laborllama.com/">Labor Llama</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a>Profile</a></li>
							<li class="active"><a>Work</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="http://www.laborllama.com/">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container">
				<!--<div class="well">
					<form action="newTask.php" method="post">
						Task Title: <input type="text" name="taskName"><br>
						Task Description: <input type="text" name="taskDescription"><br>
						Task Location <input type="text" name="taskLocation"><br>
						<input type="submit">
					</form>
				</div>-->
				<div class="well">
					<?php 
						$sql = "SELECT * FROM workBase LIMIT 30";
						$result = mysqli_query($conn, $sql);

						if (mysqli_num_rows($result) > 0) {
						    // output data of each row
						    while($row = mysqli_fetch_assoc($result)) {
						        echo "<h3>" . $row["title"]. "</h3><br> Description: " . $row["description"]. "<br>";
						    }
						}
					?>
			    </div>
		    </div>
	    </div>	
  </body>

</html>