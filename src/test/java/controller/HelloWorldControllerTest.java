package controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;

import org.binus.intern.controller.HelloWorldController;
import org.binus.intern.dto.HelloWorldDTO;
import org.binus.intern.entity.Mahasiswa;
import org.binus.intern.service.SpringService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
		(
				{
						"classpath*:src/main/webapp/WEB-INF/springmvc-context.xml"
				}
		)
public class HelloWorldControllerTest {
	@Mock
	private SpringService service;

	@InjectMocks
	private HelloWorldController helloWorldController;

	private MockMvc mockMvc;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(helloWorldController).build();
	}

	@Test
	public void testGetMhs() throws Exception
	{
		List<Mahasiswa> mhs= new ArrayList<Mahasiswa>();
		mhs.add( new Mahasiswa("1",2,"abc"));
		mhs.add( new Mahasiswa("3",7,"abc"));


		List<HelloWorldDTO> listDto= new ArrayList<HelloWorldDTO>();
		for (Mahasiswa m : mhs)
		{
			HelloWorldDTO dto = new HelloWorldDTO();
			dto.setTitle("Hello," + m.getName() + ". NIM= " + m.getNim() + ". Umur= " + m.getAge());
			listDto.add(dto);
		}

		Mockito.when(service.getAllMahasiswaExcept("2")).thenReturn(mhs);

		mockMvc.perform(get("/hello/mhs?nim=2")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].title", is(listDto.get(0).getTitle())))
				.andExpect(jsonPath("$[1].title", is(listDto.get(1).getTitle())));
		verify(service, times(1)).getAllMahasiswaExcept("2");
		verifyNoMoreInteractions(service);
	}

	@Test
	public void testError404()throws Exception{
		mockMvc.perform(get("/hello")).andExpect(status().is4xxClientError());
	}



}