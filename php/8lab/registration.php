<?php 
	require_once 'connection.php'; // подключаем скрипт
    include('lab6TemplateForRegistration.html');
	
	
	// подключаемся к серверу
	//объект подключения

	if(isset($_POST['name']) && isset($_POST['surname']) && isset($_POST['nik']) && isset($_POST['email'])){
		$link = mysqli_connect($host, $user, $password, $database) 
		or die("Ошибка " . mysqli_error($link));
		
		$name = htmlentities(mysqli_real_escape_string($link, $_POST['name']));
		$surname = htmlentities(mysqli_real_escape_string($link, $_POST['surname']));
		$nik = htmlentities(mysqli_real_escape_string($link, $_POST['nik']));
		$email = htmlentities(mysqli_real_escape_string($link, $_POST['email']));
	
		$query="INSERT INTO users VALUES(NULL,'$name','$surname', '$nik', '$email')";
		$result = mysqli_query($link,$query) 
			or die("Error".mysqli_error($link));
		
		
		if($result){
			echo "<span style='color:blue;'>Data add successfully</span>";
		}
		
		mysqli_close($link);
		header('Location: main.html');
	}
?>
	
