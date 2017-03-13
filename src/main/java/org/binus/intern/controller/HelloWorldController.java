package org.binus.intern.controller;

import java.util.ArrayList;
import java.util.List;

import org.binus.intern.dao.JdbcStudentDAO;
import org.binus.intern.dto.HelloWorldDTO;
import org.binus.intern.entity.Mahasiswa;
import org.binus.intern.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	private static final String PREFIX = "/hello";

	@Autowired
	private SpringService service;

	@ResponseBody
	@RequestMapping(path = PREFIX + "/mhs", method = RequestMethod.GET, produces = "application/json")
	public List<HelloWorldDTO> getMhs(@RequestParam("nim") String nim) {
		List<HelloWorldDTO> listDto = new ArrayList<HelloWorldDTO>();

		List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
		mhs = service.getAllMahasiswaExcept(nim);

		for (Mahasiswa m : mhs) {
			HelloWorldDTO dto = new HelloWorldDTO();
			dto.setTitle("Hello," + m.getName() + ". NIM= " + m.getNim() + ". Umur= " + m.getAge());
			listDto.add(dto);
		}
		return listDto;

	}

//	@ResponseBody
//	@RequestMapping(path = PREFIX + "/mhsNim", method = RequestMethod.GET, produces = "application/json")
//	public List<HelloWorldDTO> getMhsByNim(@RequestParam(value = "nim", defaultValue = "0") String nim) {
//
//		List<HelloWorldDTO> listDto = new ArrayList<HelloWorldDTO>();
//		// ApplicationContext context =new
//		// ClassPathXmlApplicationContext("beans.xml");
//		// MahasiswaDAOImpl mahasiswadao=
//		// (MahasiswaDAOImpl)context.getBean("MahasiswaJDBCTemplate");
//
//		List<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
//
//		mhs = mahasiswadao.findByNim(nim);
//
//		for (Mahasiswa m : mhs) {
//			HelloWorldDTO dto = new HelloWorldDTO();
//			dto.setTitle("Hello," + m.getNama() + ". NIM= " + m.getNim() + ". Umur= " + m.getUmur());
//			listDto.add(dto);
//		}
//
//		return listDto;
//
//	}
//
//	@ResponseBody
//	@RequestMapping(path = PREFIX + "/insert", method = RequestMethod.GET, produces = "application/json")
//	public String insert(@RequestParam(value = "nim", defaultValue = "0") String nim,
//			@RequestParam(value = "umur", defaultValue = "0") Integer umur,
//			@RequestParam(value = "nama", defaultValue = "0") String nama) {
//
//		return mahasiswadao.insert(nim, umur, nama);
//
//	}

}
