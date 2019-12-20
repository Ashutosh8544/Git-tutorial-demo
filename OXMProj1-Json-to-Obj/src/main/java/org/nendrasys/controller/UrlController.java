package org.nendrasys.controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;
import org.nendrasys.model.Student;
import org.nendrasys.model.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.BASE64Encoder;


@Controller
public class UrlController {

	/* @Autowired UrlService service; */

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/getObj", method = RequestMethod.GET, produces = "application/json")
	public String getdatafromAnother(Model model) throws JsonProcessingException {
		String string;
		ObjectMapper mapper =new ObjectMapper();
		// set exposoure url to gather the student data
		String url = "http://localhost:4545/Marsh_unmarsh_war_exploded/getJson";
		String name = "ashu";
        String password = "12345";
        String authString = name + ":" + password;
        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
		Client resClient = Client.create();
        WebResource webResource = resClient.resource(url);
        ClientResponse resp = webResource.accept("application/json")
                                         .header("Authorization", "Basic " + authStringEnc)
                                         .get(ClientResponse.class);
		int status = resp.getStatus();
        if( status== 200){
			// get all details from exposoure
			System.out.println("inside status @Controller");
			string = resp.getEntity(String.class);
			System.out.println("check:"+string);
			StudentList list = mapper.readValue(string, StudentList.class);
			model.addAttribute("studentList",list);
			System.out.println("All Details::" + list);
		}
		
		return "showStudent";
	}

}
