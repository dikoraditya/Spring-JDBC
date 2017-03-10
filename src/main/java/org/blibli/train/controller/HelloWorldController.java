package org.blibli.train.controller;

import org.blibli.train.dto.HelloWorldDTO;
import org.blibli.train.entity.Mahasiswa;
import org.blibli.train.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.blibli.train.dto.MahasiswaDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diko Raditya on 09/03/2017.
 */
@Controller
public class HelloWorldController {
    private static final String PREFIX = "/hello";

    @Autowired
    private SpringService service;
    @ResponseBody

    @RequestMapping(path=PREFIX+"/saySomething",method= RequestMethod.GET,produces = "application/json") //request mapping buat ngemap masing2 request ke setiap method yang sesuai
    public List<MahasiswaDTO> sayHello(){
        List<MahasiswaDTO>result = new ArrayList<>();
        MahasiswaDTO mhsDTO = new MahasiswaDTO();
        for(Mahasiswa mahasiswa:service.getAllMahasiswaExcept("nim")){
            mhsDTO = new MahasiswaDTO();
            mhsDTO.setName(mahasiswa.getName());
            mhsDTO.setAge(mahasiswa.getUmur());
            mhsDTO.setId(mahasiswa.getNim());
            result.add(mhsDTO);
        }
       // String[] kambings = new String[10];
        for(String kambing:kambings){
            System.out.println(kambing);
        }
        return result;
    }
}
