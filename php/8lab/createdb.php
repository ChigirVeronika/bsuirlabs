<?php
	require_once 'db_properties.php'; 

	$link = mysqli_connect($host, $user, $password, $database) 
		or die("Error: " . mysqli_error($link));
	 
	$query="CREATE Table $dbname
	(
		title VARCHAR(200) NOT NULL PRIMARY KEY,
		number INT NOT NULL
	)";

	$result = mysqli_query($link, $query) or die("Error: " . mysqli_error($link)); 
	if($result)
	{
		echo "Success";
	}
	 
	mysqli_close($link);
?>
