/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mardiana.yudhi.utsp4.MhsServlet;

import com.mardiana.yudhi.utsp4.MhsDao.Mahasiswa;
import com.mardiana.yudhi.utsp4.MhsDao.MahasiswaDao;
import com.mardiana.yudhi.utsp4.koneksidb.KoneksiDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author YUDHI
 */
public class FormMahasiswaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String npm = request.getParameter("npm");
        String nama = request.getParameter("nama");
        String tmpt = request.getParameter("tempatlahir");
        String tgl = request.getParameter("tgllahir");
        String jk = request.getParameter("jk");
        String alamat = request.getParameter("alamat");

        try {
            Date tgllahir = new SimpleDateFormat("dd/MM/yyyy").parse(tgl);
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/uts_p4";
            String user = "root";
            String pass = "admin";

            KoneksiDatabase conn = new KoneksiDatabase(driver, url, user, pass);
            MahasiswaDao md = new MahasiswaDao(conn);
            Mahasiswa mhs = new Mahasiswa();

            mhs.setNpm(npm);
            mhs.setNama(nama);
            mhs.setTempatLahir(tmpt);
            mhs.setTglLahir(tgl);
            mhs.setJenisKelamin(jk);
            mhs.setAlamat(alamat);
            md.simpan(mhs);
        } catch (ParseException ex) {
            Logger.getLogger(FormMahasiswaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("npm", npm);
        request.setAttribute("nama", nama);
        request.setAttribute("tempatlahir", tmpt);
        request.setAttribute("tgllahir", tgl);
        request.setAttribute("jk", jk);
        request.setAttribute("alamat", alamat);
        request.setAttribute("waktu", new Date());
        request.getRequestDispatcher("WEB-INF/templates/jsp/ViewMahasiswa.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    public String getServletInfo() {
        return "Short description";
    }
}
