package org.blibli.train.dto;

import java.io.Serializable;

/**
 * Created by Diko Raditya on 09/03/2017.
 */
public class HelloWorldDTO implements Serializable{
    private  String title;

    public HelloWorldDTO() {

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
