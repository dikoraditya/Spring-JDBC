package org.blibli.train.dao;

/**
 * Created by Diko Raditya on 10/03/2017.
 */

import org.blibli.train.dao.StudentMapper;
import org.blibli.train.entity.Mahasiswa;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class studentDaoImpl implements studentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(String name, Integer age) {
        String SQL = "insert into mahasiswa (name, age) values (?, ?)";
        jdbcTemplateObject.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }
    public Mahasiswa getStudent(Integer id) {
        String SQL = "select * from mahasiswa where id = ?";
        Mahasiswa student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());

        return student;
    }
    public List<Mahasiswa> listStudents() {
        String SQL = "select * from mahasiswa";
        List <Mahasiswa> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }
    public void delete(Integer id) {
        String SQL = "delete from mahasiswa where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }
    public void update(Integer id, Integer age){
        String SQL = "update mahasiswa set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
