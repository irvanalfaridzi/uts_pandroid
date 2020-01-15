<?php
$db = mysqli_connect('localhost', 'root', '', 'db_pos');
if (isset($_GET['kode_barang'])) {
    $kode_barang = $_GET['kode_barang'];
    $nama_barang = $_GET['nama_barang'];
    $satuan = $_GET['satuan'];
    $hbeli = $_GET['hbeli'];
    $hjual = $_GET['hjual'];
    $diskon = $_GET['diskon'];

    $query = "UPDATE barang SET nama_barang = '$nama_barang', satuan = '$satuan', hbeli = '$hbeli', hjual = '$hjual', diskon = '$diskon' WHERE kode_barang = '$kode_barang'";
    $rowData = mysqli_query($db, $query);

    if ($rowData === true) {
        echo "Data berhasil UPDATED";
    }else{
        echo "Data gagal UPDATED";
    }  
}else{
    echo "eror";
}
