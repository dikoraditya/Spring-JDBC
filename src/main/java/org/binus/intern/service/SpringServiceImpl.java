package org.binus.intern.service;

import java.util.ArrayList;
import java.util.List;

import org.binus.intern.dao.StudentDAO;
import org.binus.intern.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceImpl implements SpringService{
    public static final List<Mahasiswa> MAHASISWAS = new ArrayList<>();
    
    @Autowired
    private StudentDAO studentDAO;
    
    /**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public SpringServiceImpl()
    {
//        MAHASISWAS.add(new Mahasiswa("1801448524", 10, "Jevon"));
//        MAHASISWAS.add(new Mahasiswa("1801413716", 12, "Kevin"));
//        MAHASISWAS.add(new Mahasiswa("1801408792", 14, "Ivan"));
    }

    @Override
    public List<Mahasiswa> getAllMahasiswaExcept(String nim) {
        List<Mahasiswa> result = new ArrayList<>();	

        //for(Mahasiswa mahasiswa : MAHASISWAS)
    	for(Mahasiswa mahasiswa : getStudentDAO().getAllMahasiswaExcept(nim))	//studentDAO.findAllStudents()
        {
            if(!mahasiswa.getNim().equals(nim))
            {
                result.add(mahasiswa);
            }
        }
        
        return result;
    }
    
}
