<%-- 
    Document   : ViewMahasiswa
    Created on : Oct 29, 2014, 2:36:09 PM
    Author     : YUDHI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Mahasiswa</title>
    </head>
    <body>
        <h1>View New Mahasiswa</h1>
        <form action="DataMahasiswa" method="post" name="form">
                <table >
                    <tr>
                        <td>
                            <label>NPM</label>
                        </td>
                        <td>
                            <label>${npm}</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nama</label>
                        </td>
                        <td>
                            <label>${nama}</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Tempat Lahir</label>
                        </td>
                        <td>
                            <label>${tmpt}</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Tanggal Lahir</label>
                        </td>
                        <td>
                            <label>${tgl}</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Jenis Kelamin</label>
                            <label>&nbsp;</label>
                        </td>
                        <td>
                            <label>${jk}</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Alamat</label>
                        </td>
                        <td>
                             <label>${alamat}</label>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" id="btnSave" value="Back">
                        </td>
                    </tr>					
                </table>
            </form>
       
    </body>
</html>