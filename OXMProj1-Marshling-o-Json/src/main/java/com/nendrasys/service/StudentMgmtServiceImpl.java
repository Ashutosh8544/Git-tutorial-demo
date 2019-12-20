package com.nendrasys.service;

 import com.nendrasys.Dao.StudentDAO;
import com.nendrasys.studentdetails.Student;
 import com.nendrasys.studentdetails.StudentList;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMgmtServiceImpl implements StudentMgmtService {

    @Autowired
    StudentDAO dao;

    public String getAllStudentDetailsInJson() {
        List<String> stringList = null;
        String strings = "";
        ObjToJsonService objToJsonService;
        //use dao
        List<Student> studentList=dao.getStudentDetails();
        StudentList studentList1 = new StudentList();
        studentList1.setStudents(studentList);
        try {
            objToJsonService = new ObjToJsonService();
             strings=objToJsonService.convertJavaObjectsToJson(studentList1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }
}