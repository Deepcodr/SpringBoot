package com.deepcodr.example.secretmanagerimpl.controller;

import org.springframework.web.bind.annotation.RestController;

import com.deepcodr.example.secretmanagerimpl.config.SecretManagerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SecretManagerImplController {

    @Autowired
    SecretManagerConfig secretManagerConfig;

    @GetMapping("/getsecret")
    public String getSecret(@RequestParam String secretName) {
        String secretValue = SecretManagerConfig.getSecretFromAWS(secretManagerConfig.getSecretsManagerClient(), secretName).getProperty(secretName);
        return secretValue;
    }
    
}
