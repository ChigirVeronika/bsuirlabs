<?php
 if(isset($_GET['id'])){
	$link=mysql_connect("localhost","root","");// подключаем скрипт
    mysql_select_db("mydatabase");
	
	$id = mysql_real_escape_string($_GET['id']);
	$querty = mysql_query("SELECT * FROM `blob` WHERE `id`='$id'");
	
	while($row= mysql_fetch_assoc($querty)){
		$imageData=$row["image"];
	}
	header("content-type: image/jpg")||header("content-type: image/gif")||header("content-type: image/png")||header("content-type: image/jpeg");
	echo $imageData;
 }
?>