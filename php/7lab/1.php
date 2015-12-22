<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
	<title>LR 7</title>
</head>
<body>

<form method="post" action="1.php" enctype="multipart/form-data">
<p align="center">
			Serialization<br/> <br/> <br/> 
			
			Enter text:<input type="text" name="a" placeholder="some text" size="50" /><br/><br/><br/>
			
			<input type="submit" name="submit"  value="serialize & go to 2.php" /><br/>
			
</p>			
</form>

	<section>
		<table>
		<p align="center">
		<?php 
			if(isset($_POST['submit'])){
			$inputText=$_POST['a'];
			
			echo $value=serialize($inputText);
			echo "<HTML><HEAD> 
            <META HTTP-EQUIV='Refresh' CONTENT='0; URL=2.php?value=$value'> 
            </HEAD></HTML>";
			}
		?>
		</p>
		</table>
	</section>
</body>