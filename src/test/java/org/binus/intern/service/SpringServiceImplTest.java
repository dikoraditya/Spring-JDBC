package org.binus.intern.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.binus.intern.dao.StudentDAO;
import org.binus.intern.entity.Mahasiswa;
import org.binus.intern.service.SpringServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.context.transaction.BeforeTransaction;;

public class SpringServiceImplTest {
	private SpringServiceImpl springServiceImpl;
	private StudentDAO studentDAO;

	private List<Mahasiswa> listStudents;
	
	@Before
	public void initialize() {
		//inisialisasi yang mau di test
		springServiceImpl = new SpringServiceImpl();
		
		//mockito mock hanya untuk interface (yang mau di test)
		studentDAO = Mockito.mock(StudentDAO.class);
		
		//ini untuk inject karena di spring itu kan ada manggil method get, itu kan butuh dao kan
		//nah kita butuh itu sebagai data palsu gitu untuk spring service impl
		springServiceImpl.setStudentDAO(studentDAO);
		
		listStudents = new ArrayList<>();
		listStudents.add(new Mahasiswa("1801448524", 18, "Jevon"));
		listStudents.add(new Mahasiswa("1801413716", 19, "Kevin"));
		listStudents.add(new Mahasiswa("1801408792", 20, "Ivan"));
		listStudents.add(new Mahasiswa("1801413035", 21, "Nando"));
		listStudents.add(new Mahasiswa("1801414776", 22, "Albert"));
	}
	
	@Test
	public void testGetAllMahasiswaExceptOneContainNim() {
		Mockito.when(studentDAO.getAllMahasiswaExcept("1801448524")).thenReturn(listStudents);
		List<Mahasiswa> listAllStudents = springServiceImpl.getAllMahasiswaExcept("1801448524");
		Assert.assertTrue(listAllStudents.size() == 4);
		Mockito.verify(studentDAO, times(1)).getAllMahasiswaExcept("1801448524");
	}
	
	@Test
	public void testGetAllMahasiswaExceptOneNotContainNim() {
		Mockito.when(studentDAO.getAllMahasiswaExcept("1901448524")).thenReturn(listStudents);
		List<Mahasiswa> listAllStudents = springServiceImpl.getAllMahasiswaExcept("1901448524");
		Assert.assertTrue(listAllStudents.size() == 5);
		Mockito.verify(studentDAO, times(1)).getAllMahasiswaExcept("1901448524");
	}
	
	@After
	public void afterTest() {
		
	}
	
}
