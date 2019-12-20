package com.nendrasys.controller;

import com.nendrasys.service.AuthenticationService;
import com.nendrasys.service.StudentMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentMgmtService studentMgmtService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getJson",method = RequestMethod.GET)
    public @ResponseBody String getAllDetails(@RequestHeader("Authorization") String authString) {

        List<String> ls=null;
            if(authenticationService.isUserAuthenticated(authString)) {
                return studentMgmtService.getAllStudentDetailsInJson();
            }
            else{
             return "unauthorized";
            }
    }
}
