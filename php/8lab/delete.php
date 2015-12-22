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

 <form action="delete.php" enctype="multipart/form-data" method="POST" >
 ID файла: <br><br><input type="text" name="id" /><br><br>
 <input type="submit" name="submit" value="Удалить" /><br><br>
 </form>
<?php   
	if(isset($_POST['id'])){
 
		$link = mysqli_connect("localhost","root","","mydatabase") 
            or die("Ошибка " . mysqli_error($link)); 
		$id = mysqli_real_escape_string($link, $_POST['id']);
     
		$query ="DELETE FROM `blob` WHERE id = '$id'";
		$result = mysqli_query($link, $query) or die("Ошибка " . mysqli_error($link)); 
 
		mysqli_close($link);
		echo "Файл удален";
		
	}
?>
</body>
</html>