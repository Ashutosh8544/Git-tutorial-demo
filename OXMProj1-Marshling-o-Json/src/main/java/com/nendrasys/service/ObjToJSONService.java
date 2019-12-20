package com.nendrasys.service;

import com.nendrasys.studentdetails.Student;
import com.nendrasys.studentdetails.StudentList;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ObjToJsonService{
	public String convertJavaObjectsToJson(StudentList studentList) throws Exception {
		ObjectMapper mapper =new ObjectMapper();
		String data = mapper.writeValueAsString(studentList);
		return data;
	}
}
