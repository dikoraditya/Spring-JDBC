package org.blibli.train.dto;

import java.io.Serializable;

/**
 * Created by Diko Raditya on 10/03/2017.
 */
public class MahasiswaDTO implements Serializable {

    private static final long serialVersionUID = -7133695652580741397L;


        private Integer age;
        private String name;
        private Integer id;

        public void setAge(Integer age) {
            this.age = age;
        }
        public Integer getAge() {
            return age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public Integer getId() {
            return id;
        }

}
