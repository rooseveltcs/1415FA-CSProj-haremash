<?php 
	alert("NEW TASK");

	include 'config.php';

	$title = $_POST["taskName"];
	$description = $_POST["taskDescription"];
	$location = $_POST["taskLocation"];

	$sql = "INSERT INTO workBase (title, description, location)
		VALUES ('$title', '$description', '$location')";

	if (mysqli_query($conn, $sql)) {
	} else {}

	header("Location: http://www.laborllama.com/dbtest.php/");
?>