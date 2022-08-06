package com.mostafa.controller;

import com.mostafa.Model.JwtRequestModel;
import com.mostafa.Model.JwtResponseModel;
import com.mostafa.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/auth"})
    public JwtResponseModel createJwtToken(@RequestBody JwtRequestModel jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
