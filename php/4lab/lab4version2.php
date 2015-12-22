<!DOCTYPE html>
<html>
<head>
	<title>LR 4</title>
</head>
<body>

<form method="post" action="lab4version2.php" enctype="multipart/form-data">
<p align="center">
			Regular expressions<br/> <br/> <br/> 
			
			Enter text:<input type="text" name="a" placeholder="some text" size="50" /><br/>
			
			<input type="submit" name="submit"  value="Go" /><br/>
</p>			
</form>

	<section>
		<table>
			
		<p align="center">
		<?php 
			if(isset($_POST['submit'])){
			$inputText=$_POST['a'];
			
			function numbers($x)
			{
				$test = trim($x[0], '.');	
				if (preg_match("/^\d+$/", $test))
				{
						return '<font style="color:blue">'.$test.'</font>';
				}
				elseif(substr_count($test, '.')==1)
				{
					return round($test, 1);
				}
				else
				{
					return $x[0];
				}
			}
			
			echo preg_replace_callback("/[\w.-]+/", 'numbers', $inputText);
			}
		?>
		</p>
		
		
		</table>
	</section>
	
</body>