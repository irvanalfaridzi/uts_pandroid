<?php
$db = mysqli_connect('localhost', 'root', '', 'db_pos');
if (isset($_GET['kode_barang'])) {
    $kode_barang = $_GET['kode_barang'];
    $nama_barang = $_GET['nama_barang'];
    $satuan = $_GET['satuan'];
    $hbeli = $_GET['hbeli'];
    $hjual = $_GET['hjual'];
    $diskon = $_GET['diskon'];

    $query = "INSERT INTO barang (kode_barang, nama_barang, satuan, hbeli, hjual, diskon) VALUES ('$kode_barang', '$nama_barang', '$satuan', '$hbeli', '$hjual', '$diskon') ";
    $rowData = mysqli_query($db, $query);

    if ($rowData === true) {
        echo "Data berhasil masuk";
    }else{
        echo "Data gagal masuk";
    }  
}else{
    echo "eror";
}
