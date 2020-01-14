<?php
$db=mysqli_connect('localhost', 'root', '', 'db_pos');
$result=array();
$query="SELECT * FROM barang";
$rowData=mysqli_query($db, $query);
while($row=mysqli_fetch_assoc($rowData)){
	$result['rowData'][]=$row;
}

echo json_encode($result);


?>