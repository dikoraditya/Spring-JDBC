package org.blibli.train.dao;

/**
 * Created by Diko Raditya on 10/03/2017.
 */

import org.blibli.train.entity.Mahasiswa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Mahasiswa> {
    public Mahasiswa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mahasiswa student = new Mahasiswa();
        student.setNim(rs.getInt("nim"));
        student.setName(rs.getString("name"));
        student.setUmur(rs.getInt("age"));

        return student;
    }
}
