<!DOCTYPE html>
<?php 
	include 'config.php';
?>
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
	
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="http://www.laborllama.com/"><strong>Labor Llama</strong></a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="http://www.laborllama.com/demoprofile.php/">Profile</a></li>
							<li class="active"><a>Work</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="http://www.laborllama.com/">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>

			<?php 
				
				$title = $_POST["taskName"];
				$loc = $_POST["taskLocation"];
				$about = $_POST["taskDescription"];
				
				if($title != "" || $loc != "" || $about != "") {	
					$sql = "INSERT INTO workBase (title, description, location)
					VALUES ('$title', '$about', '$loc')";

					if (mysqli_query($conn, $sql)) {
					} else {}
				}

				if(!isset($_POST['submit'])) {
			?>

			<div class="container">
				<div class="well">
					<strong><h4>Create a New task</h4></strong><br>
					<form class"form-horizontal" action="<?php echo $_SERVER['PHP_SELF'];?>" method="post">
						<div class="form-group">
							<label for="taskName" class"col-sm-2 control-label">Task Title</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="taskName" name="taskName" placeholder="The name of your task goes here...">
							</div>
						</div>
						<div class="form-group">
							<label for="taskLocation" class"col-sm-2 control-label">Task Location</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="taskLocation" name="taskLocation" placeholder="Where does the task take place?">
							</div>
						</div>
						<div class="form-group">
							<label for="taskDescription" class"col-sm-2 control-label">Description</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" rows="3" id="taskDescription" name="taskDescription" placeholder="The description of your task goes here...">
							</div>
						</div>
						<div class="form-group">
						    <div class="col-sm-10">
						      <input type="submit" class="btn btn-primary">
						    </div>
						</div> 
						<br> <br>
					</form>
				</div>
				<?php
					}
				?>
				
				<div class="well">
					<strong><h4>Recent Tasks</h4></strong><br>
					<?php 
						$sql = "SELECT * FROM workBase ORDER BY id DESC";
						$result = mysqli_query($conn, $sql);

						if (mysqli_num_rows($result) > 0) {
						    // output data of each row
						    while($row = mysqli_fetch_assoc($result)) {
						        echo "<div class='panel panel-primary'>";
						        echo 	"<div class='panel-heading'>";
						        echo 		"<h4 class='panel-title'>".$row["title"]."</h4>";
						        echo 	"</div>";
						        echo 	"<div clas='panel-body'>";
						        echo 		$row["description"];
						        echo 	"<br><samp>  Where? </samp>".$row["location"];
						        echo 	"</div>";
						        echo "</div>";
						    }
						}
					?>
			    </div>
	    	</div>

  </body>

</html>