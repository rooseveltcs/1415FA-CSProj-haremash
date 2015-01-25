<?php
		include 'config.php';
		
		$query = "SELECT title, description, location FROM workBase";
		$result = mysqli_query($conn, $query);
		$row	= mysqli_fetch_row($result); 
		$db_job_title = $row[0];
		$db_job_description = $row[1];
		$db_job_location = $row[2];
		echo $row[2];
		
		echo "<br> This should display a job title: ".$db_job_title."<br>";
		echo "This should display the job description: ".$db_job_description."<br>";
		//echo "This should display the location of the job: ".$db_job_location."<br>;
?>
