/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mardiana.yudhi.utsp4.MhsDao;

import com.mardiana.yudhi.utsp4.koneksidb.KoneksiDatabase;
import com.mardiana.yudhi.utsp4.MhsDao.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YUDHI
 */
public class MahasiswaDao {
    private KoneksiDatabase koneksi;

    public MahasiswaDao(KoneksiDatabase k) {
        this.koneksi = k;
    }

    public void simpan(Mahasiswa k) {
        
        try {
            String sql = "INSERT INTO mahasiswa (npm, nama, tempatlahir, tgllahir, jeniskelamin, alamat) VALUES (?,?,?,?,?,?)";
            Connection c = koneksi.connect();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, k.getNpm());
            ps.setString(2, k.getNama());
            ps.setString(3, k.getTempatLahir());
            ps.setString(4, k.getTglLahir());
            ps.setString(5, k.getJenisKelamin());
            ps.setString(6, k.getAlamat());
            ps.executeUpdate();
            koneksi.disconnect(c);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> cari() throws Exception {
        List<Mahasiswa> hasil = new ArrayList<Mahasiswa>();

        try {
            String sql = "SELECT * FROM mahasiswa ORDER BY npm";
            Connection c = koneksi.connect();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mahasiswa k = konversiResultSet(rs);
                hasil.add(k);
            }
            koneksi.disconnect(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }

    private Mahasiswa konversiResultSet(ResultSet rs) throws Exception {
        Mahasiswa k = new Mahasiswa();
        k.setId(rs.getInt("ID"));
        k.setNpm(rs.getString("NPM"));
        k.setNama(rs.getString("NAMA"));
        k.setTempatLahir(rs.getString("TEMPATLAHIR"));
        k.setTglLahir(rs.getString("TGLLAHIR"));
        k.setJenisKelamin(rs.getString("JENISKELAMIN"));
        k.setAlamat(rs.getString("ALAMAT"));
        return k;
    }
}
