package com.nendrasys.Dao;

import com.nendrasys.studentdetails.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> getStudentDetails() {
        List<Student> listStudent = null;
        listStudent = jdbcTemplate.query("select * from Student", new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Student> _list = new ArrayList<>();
                System.out.println("size" + resultSet.getFetchSize());
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setName(resultSet.getString("name"));

                    student.setAddress(resultSet.getString("address"));
                    student.setAge(resultSet.getInt("age"));
                    student.setStandard(resultSet.getInt("standard"));

                    _list.add(student);
                }
                System.out.println("StudentDAOImpl.extractData():: "+_list);
                return _list;
            }
        });
        return listStudent;
    }
}