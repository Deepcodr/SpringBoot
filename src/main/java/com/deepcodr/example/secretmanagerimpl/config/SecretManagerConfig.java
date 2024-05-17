package com.deepcodr.example.secretmanagerimpl.config;

import java.util.Properties;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

@Component
public class SecretManagerConfig {

    private final SecretsManagerClient secretsManagerClient;

    SecretManagerConfig(){
        secretsManagerClient = SecretsManagerClient.builder().region(Region.AP_SOUTH_1).build();
    }

    public SecretsManagerClient getSecretsManagerClient(){
        return secretsManagerClient;
    }

    public static Properties getSecretFromAWS(SecretsManagerClient secretsManagerClient,String secretName)
    {
        Properties properties = new Properties();
        try{
            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
            .secretId(secretName)
            .build();

            GetSecretValueResponse valueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);
            properties.setProperty(secretName, valueResponse.secretString());

        }catch(SecretsManagerException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error while Fetching Secrets");
        }
        return properties;
    }
}
