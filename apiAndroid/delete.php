<?php
$db = mysqli_connect('localhost', 'root', '', 'db_pos');
if (isset($_GET['kode_barang'])) {
    $kode_barang = $_GET['kode_barang'];

    $query = "DELETE FROM barang WHERE kode_barang = '$kode_barang'";
    $rowData = mysqli_query($db, $query);

    if ($rowData === true) {
        echo "Data berhasil UPDATED";
    }else{
        echo "Data gagal UPDATED";
    }  
}else{
    echo "eror";
}
