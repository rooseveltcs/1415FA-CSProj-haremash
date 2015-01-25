<?php
	$servername = "localhost";
	$username = "";
	$password = "";
	$dbname = "laborlla_users";

	@$conn = mysqli_connect($servername, $username, $password)
        or die("Could not connect to server " . mysql_error()); 
    mysqli_select_db($conn, $dbname)
        or die("Error: Could not connect to the database: " . mysql_error());

    /*Check for Connection*/
    if(mysqli_connect_errno()){
        // Display Error message if fails
        echo 'Error, could not connect to the database please try again again.';
    exit();
    }
?>