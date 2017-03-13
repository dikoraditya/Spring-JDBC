package org.binus.intern.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.binus.intern.dao.StudentDAO;
import org.binus.intern.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcStudentDAO implements StudentDAO, Serializable {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	//private DataSource studentDAO;
	


	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	/**
	 * @param jdbcTemplateObject the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	@Override
	public Mahasiswa insert(Mahasiswa mahasiswa) {
		/*String insertSQL = "INSERT INTO student (NIM, Age, Name) values (?, ?, ?)";
		jdbcTemplateObject.update(insertSQL, new StudentDAOMapper());
		return;*/
		try{
			entityManager.persist(mahasiswa);
		}catch(Exception e){
			e.printStackTrace();
			return mahasiswa;
		}
		return mahasiswa;
	}

	@Override
	public List<Mahasiswa> findAllStudents() {
		 String readSQL = "SELECT * FROM student";
		 List <Mahasiswa> students = jdbcTemplateObject.query(readSQL, new StudentDAOMapper());
		 return students;
	}

	@Override
	public List<Mahasiswa> getAllMahasiswaExcept(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
