package org.binus.intern.dao;

import java.util.List;

import org.binus.intern.entity.Mahasiswa;

public interface StudentDAO {
	
	public Mahasiswa insert(Mahasiswa mahasiswa);
	
	public List<Mahasiswa> findAllStudents();
	public List<Mahasiswa> getAllMahasiswaExcept(String string);

	// public Mahasiswa getStudent(Integer id);

	// public void delete(String nim);

	// public void update(String nim, Integer age, String name);
	
}
