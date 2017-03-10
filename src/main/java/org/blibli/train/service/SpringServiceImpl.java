package org.blibli.train.service;

import org.blibli.train.entity.Mahasiswa;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.blibli.train.dao.studentDaoImpl;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diko Raditya on 09/03/2017.
 */
@Service
public class SpringServiceImpl implements SpringService{
    private static  List<Mahasiswa> MAHASISWAS = new ArrayList<>();
    private static final studentDaoImpl dbase = new studentDaoImpl();

        public SpringServiceImpl() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dbase.setDataSource(dataSource);
            MAHASISWAS=dbase.listStudents();
        }


    @Override
    public List<Mahasiswa> getAllMahasiswaExcept(String nim) {

        List<Mahasiswa> result = new ArrayList<>();
        for(Mahasiswa mahasiswa:MAHASISWAS){
            if (!mahasiswa.getNim().equals(nim)) {
                result.add(mahasiswa);
            }
        }
        return result;
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa(String nim) {
        return null;
    }


}
