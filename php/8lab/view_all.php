<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

<?php
require_once 'db_properties.php'; 
 
$link = mysqli_connect($host, $user, $password, $database) 
    or die("Error: ".mysqli_error($link)); 

$browser = get_browser(null, true);
$browser_name = $browser['browser'];

$query = "SELECT * FROM $dbname WHERE title = '$browser_name'";
$result = mysqli_query($link, $query) or die("Ошибка " . mysqli_error($link)); 
if($result){
	if(mysqli_num_rows($result) == 0){
		$title = $browser_name;
		$number = 1;
		$query ="INSERT INTO $dbname VALUES('$title','$number')";
		$result = mysqli_query($link, $query) or die("Error: " . mysqli_error($link)); 			
	}
	else{
		$title = $browser_name;
		$row = mysqli_fetch_row($result);
		$number = $row[1] + 1;
		$query ="UPDATE $dbname SET title='$title', number='$number' WHERE title='$title'";
		$result = mysqli_query($link, $query) or die("Error: " . mysqli_error($link)); 
	}
}

     
$query ="SELECT * FROM $dbname";
 
$result = mysqli_query($link, $query) or die("Ошибка " . mysqli_error($link)); 
if($result)
{
	
    $rows = mysqli_num_rows($result);
     
    echo "<table><tr><th>browser</th><th>number</th></tr>";
    for ($i = 0 ; $i < $rows ; ++$i)
    {
        $row = mysqli_fetch_row($result);
        echo "<tr>";
            for ($j = 0 ; $j < 2 ; ++$j) echo "<td>$row[$j]</td>";
        echo "</tr>";
    }
    echo "</table>";
   
    mysqli_free_result($result);
}
 
mysqli_close($link);
?>
</body>
</html>
