package org.nendrasys.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.nendrasys.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
@Service
public class StudentMgmtServiceImpl implements StudentMgmtService {

    	 public List<String> convertJsonToJavaObjects(List<String> listString) throws Exception {
    	       	ObjectMapper mapper = null;
    			List<Student>list=new ArrayList<Student>();
    			List<String> returnlistString =new ArrayList<String>();
    			
    			BeanUtils.copyProperties(list, returnlistString);
    			
    			mapper = new ObjectMapper();
    			for(int index = 0;index<listString.size();index++) {
    				StringReader reader = new StringReader(listString.get(index));
    				//StreamSource streamSource = new StreamSource(reader);
    				list =  (List<Student>) mapper.readValue(reader,Student.class);
    			}
      	        System.out.println(list.toString());
    	        return returnlistString;	       
    }
}
*/