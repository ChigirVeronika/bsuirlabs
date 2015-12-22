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

 <form action="save.php" enctype="multipart/form-data" method="POST" >
 Файл: <br><br><input type="file" name="image" /><br><br>
 <input type="submit" name="submit" value="Загрузить" /><br><br>
 </form>
 <?php
	mysql_connect("localhost","root","") or
		die("Ошибка соединения: " . mysql_error());
	mysql_select_db("mydatabase") or
		die("Ошибка соединения: " . mysql_error());
		
	if(isset($_FILES['image'])){
		
		$filesize = $_FILES['image']['size'];
	    if($_FILES['image']['error'] == 1 || $filesize > 8388608){
				$filesize = ($filesize != 0)? sprintf('(%.2f Мб)' , $filesize / 1024): '';
				die('Ошибка: Размер прикреплённого файла '.
				$filesize.' больше допустимого .');
	    }
	    else{
		
		$imageName = mysql_real_escape_string($_FILES["image"]["name"]);//ассоцативный глобальный массив
		$imageData = mysql_real_escape_string(file_get_contents($_FILES["image"]["tmp_name"]));
		$imageType=mysql_real_escape_string($_FILES["image"]["type"]);

		//if(substr($imageType,0,5)=="image"){
				mysql_query("INSERT INTO `blob` VALUES('','$imageName','$imageData')");
				echo "Файл загружен";
		//}
		//else{
		//	echo "Only image are allowed";
		//}
		
		}
	}
 ?>
 </h2>
 </body>
</html>