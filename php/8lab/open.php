<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<link rel="icon" href="favicon.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>File storage</title>
	</head>
	
	<body style="color:#FFFFFF; background:#000000 url('23.jpg')">
		<h2 style="text-align:justify">
		<a href="main.html">&emsp;  Главное меню  &emsp;  </a><br><br><br>

		<form action="open.php" enctype="multipart/form-data" method="POST" >
		ID файла: <br><br><input type="text" name='id'/><br><br>
		Введите новое имя, если хотите его изменить:
		<br><br><input type="text" name='name'/><br><br>
		
		
		<input type="submit" name="submit" value="Открыть" /><br><br>
		<input type="reset" name="no" value="Очистить"><br>
		<br><br><br><br>
		
	<?php
	if(isset($_POST['id'])){
		$link = mysqli_connect("localhost","root","","mydatabase") 
            or die("Ошибка " . mysqli_error($link)); 
        $id = mysqli_real_escape_string($link, $_POST['id']);
		
        $query ="SELECT * FROM `blob` WHERE id = '$id', image= $image" or die("Ошибка " . mysqli_error());
		echo $image;
		//if (!$result = mysql_fetch_array($query)) {
		//	echo "id не существует";
		//}
		$i=$id;
        echo "<td><img src='showimage.php?id=$id'/></td>";
		
		echo "<textarea name='template' cols='100%' rows='35'>".$image."</textarea>";
		echo "<br><br>";
		mysqli_close($link);
		//"<HTML><HEAD> 
        // <META HTTP-EQUIV='Refresh' CONTENT='0; URL=download.php?id=$id'> 
        // </HEAD></HTML>";
		//echo "<a href=download.php?id=$id>Скачать файл</a>";
		if(isset($_POST['name'])){
			$link = mysqli_connect("localhost","root","","mydatabase") 
				or die("Ошибка " . mysqli_error($link));
			$name = htmlentities(mysqli_real_escape_string($link, $_POST['name']));
			
			$query ="UPDATE `blob` SET name='$name' WHERE id='$i'";
			$result = mysqli_query($link, $query) or die("Ошибка " . mysqli_error($link)); 
			if($result)
				echo "<span style='color:white;'>Имя изменено</span>";
		}
	}
	?>
	
	
	</form>
	</h2>
	</body>
</html>