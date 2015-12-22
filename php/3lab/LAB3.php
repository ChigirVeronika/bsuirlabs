<!DOCTYPE html>
<html>
<head>
	<title>Laba 3</title>
</head>
<body>

<form method="post" action="LAB3.php">
<p align="center">
			How old are you?<br/> <br/> <br/> 
			Enter your Birthday:<input type="text" name="a" placeholder="Year-Month-Day" size="15" /><br/><br/>
			
			<input type="submit" name="submit"  value="Go" /><br/>

</p>			
</form>

	<section>
		<table>
			
			<p align="center">
		<?php 
			
			$timeZone = new DateTimeZone ('Europe/Minsk'); // временная зона 
			
			
			$datetime1 = new DateTime ($_POST['a'], $timeZone); // д.р. 

			$datetime2 = new DateTime (); // текущая дата 
			$interval = $datetime1->diff ($datetime2); // вычисление 
			echo $interval->format ('%y years %m month %d days'); // вывод на экран 
			
		?>
		</p>
		
		
		</table>
	</section>
	
</body>