package org.blibli.train.service;


import org.blibli.train.entity.Mahasiswa;

import java.util.List;

public interface SpringService{
    public List<Mahasiswa> getAllMahasiswaExcept(String nim);
    public List<Mahasiswa> getAllMahasiswa(String nim);

}
