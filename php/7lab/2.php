<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<?php 
	$str=($_GET["value"]);
	echo 'In serialize format: ' ;
	echo $str;
	echo 'In primary format: ';
	echo unserialize($str);
?>