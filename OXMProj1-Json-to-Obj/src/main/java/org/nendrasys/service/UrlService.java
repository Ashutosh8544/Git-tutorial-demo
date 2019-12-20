
package org.nendrasys.service;



import java.util.ArrayList;
import java.util.List;

import org.nendrasys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UrlService {

	@Autowired
	private RestTemplate restTemplate;

	public String getdatafromAnother(Model model,Class<Student> cls) {
		cls=Student.class;
		List<Student> listStud =new ArrayList<Student>();
		ObjectMapper mapper =new ObjectMapper();
		// set exposoure url to gather the student data
		String url = "http://localhost:4545/Marsh_unmarsh_war_exploded/getJson";
		// get all details from exposoure
		List<String> string = restTemplate.getForObject(url, ArrayList.class);
		System.out.println("check:"+string);
		System.out.println("Size::"+string.size());
		
		for(String str1:string) {
			Student std=null;
			try {
				System.out.println("Str::"+str1);
				System.out.println("cls:"+cls);
				 std=mapper.readValue(str1, cls);
				 System.out.println("Std:"+std);
				 listStud.add(std);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		model.addAttribute("studentList",listStud);
		System.out.println("All Details::" + listStud.toString());
		
		return "showStudent";
	}


}
