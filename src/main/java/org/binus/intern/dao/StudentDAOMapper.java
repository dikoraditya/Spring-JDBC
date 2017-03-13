package org.binus.intern.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.binus.intern.entity.Mahasiswa;
import org.springframework.jdbc.core.RowMapper;

public class StudentDAOMapper implements RowMapper<Mahasiswa> {
	
   public Mahasiswa mapRow(ResultSet rs, int rowNum) throws SQLException {
      Mahasiswa student = new Mahasiswa();
      student.setNim(rs.getString("nim"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      
      return student;
   }
   
}
