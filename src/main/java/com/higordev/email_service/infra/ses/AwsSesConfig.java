package com.higordev.email_service.infra.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    @Value("${aws.region}")
    private String region;

    @Value("${aws.accessKeyID}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        // Criando as credenciais explicitamente com os dados do properties
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(region) // Define a região sa-east-1
                .withCredentials(new AWSStaticCredentialsProvider(credentials)) // Define as chaves
                .build();
    }
}