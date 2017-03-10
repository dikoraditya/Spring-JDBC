package org.blibli.train.entity;

/**
 * Created by Diko Raditya on 09/03/2017.
 */
public class Mahasiswa {
    private Integer nim;
    private Integer umur;
    private String name;
    public Mahasiswa() {

    }

    public Mahasiswa(Integer nim, Integer umur, String name) {
        this.nim = nim;
        this.umur = umur;
        this.name = name;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
