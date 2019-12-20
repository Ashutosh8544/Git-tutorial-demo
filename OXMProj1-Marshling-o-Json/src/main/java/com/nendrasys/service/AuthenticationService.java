package com.nendrasys.service;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;

@Service
public class AuthenticationService {
    public boolean isUserAuthenticated(String authString){

        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
        String[] credentials = decodedAuth.split(":");
        String username = credentials[0];
        String password = credentials[1];
        if(username.equals("ashu") && password.equals("12345"))
            return true;
        return false;
    }
}
