package org.binus.intern.service;

import java.util.List;
import org.binus.intern.entity.Mahasiswa;
import org.springframework.stereotype.Service;

public interface SpringService {

    public List<Mahasiswa> getAllMahasiswaExcept(String nim);
}