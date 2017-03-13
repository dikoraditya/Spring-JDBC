package dao;

import org.binus.intern.entity.Mahasiswa;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.binus.intern.dao.StudentDAO;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDAOTest {

	@Autowired
	private StudentDAO studentDAO;

	@Test
	@Transactional("hibernateTransactionManager")
	@Rollback(true)
	public void testAddMahasiswa()
	{
		Mahasiswa mahasiswa = new Mahasiswa("1801435616",20,"Diko");
		studentDAO.insert(mahasiswa);
		List<Mahasiswa> result = new ArrayList<>();
		result = studentDAO.findAllStudents();
		Assert.assertEquals(1,result.size());
		Assert.assertEquals(mahasiswa.getName(),result.get(0).getName());

		/*Mahasiswa mahasiswa = new Mahasiswa("1801435616",20,"Diko");
		assertNull(mahasiswa.getNim());
		mahasiswa = studentDAO.insert(mahasiswa);
		assertNotNull(mahasiswa.getNim());
		assertTrue(mahasiswa.getAge()>0);
	*/}

}
