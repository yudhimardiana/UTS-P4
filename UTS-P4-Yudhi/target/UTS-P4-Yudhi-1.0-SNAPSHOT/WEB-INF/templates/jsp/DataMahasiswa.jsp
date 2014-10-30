<%-- 
    Document   : DataMahasiswa
    Created on : Oct 29, 2014, 2:23:38 PM
    Author     : YUDHI
--%>

<%@page import="com.mardiana.yudhi.utsp4.MhsDao.Mahasiswa"%>
<%@page import="java.util.List"%>
<%@page import="com.mardiana.yudhi.utsp4.MhsDao.MahasiswaDao"%>
<%@page import="com.mardiana.yudhi.utsp4.koneksidb.KoneksiDatabase"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>

<%
String rowData = "";
String exist = "";
try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/uts_p4";
            String user = "root";
            String pass = "admin";

            KoneksiDatabase conn = new KoneksiDatabase(driver, url, user, pass);
            MahasiswaDao md = new MahasiswaDao(conn);
            List<Mahasiswa> isiDb =  null;
		try {
			isiDb = md.cari();
			for(Mahasiswa ls : isiDb){
			request.setAttribute("npm", ls.getNpm());
                        request.setAttribute("nama", ls.getNama());
                        rowData += "<tr>"
                                    + "<td></td>"
                                    + "<td>"+(ls.getNpm() != null ? ls.getNpm() : "")+"</td>"
                                    + "<td>"+(ls.getNama() != null ? ls.getNama() : "")+"</td>"
                                    + "<td>"+(ls.getTempatLahir() != null ? ls.getTempatLahir() : "")+","+(ls.getTglLahir() != null ? ls.getTglLahir() : "")+"</td>"
                                    + "<td>"+(ls.getJenisKelamin() != null ? ls.getJenisKelamin() : "")+"</td>"
                                    + "<td>"+(ls.getAlamat() != null ? ls.getAlamat() : "")+"</td>"
                                    + "</tr>";
                            exist = "true";
	        	
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        } catch (Exception e) {
        }
%>

<script language="javascript">
    function doAdd(){
        location.href = "FormMahasiswa.html";
    }
    
</script>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

  </head>

  <body>
        
          <h2 class="sub-header">Data Mahasiswa (UTS-P4-Yudhi)</h2>
          <table border="2">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>NPM</th>
                  <th>Nama</th>
                  <th>Tempat Tgl. Lahir</th>
                  <th>Jenis Kelamin</th>
                  <th>Alamat</th>
                </tr>
              </thead>
              <tbody>
                <% out.println(rowData);%>
              </tbody>
            </table>
              <br>
              <form action="FormMahasiswa.html">
                  <input type="submit" value="Entri Mahasiswa" class="btn" id="btnAdd" style="margin-left:5%;"/>
              </form>
    
  </body>
</html>
