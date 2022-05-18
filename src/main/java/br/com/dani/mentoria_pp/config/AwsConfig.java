package br.com.dani.mentoria_pp.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsConfig {
    @Bean
    @Primary
    public AmazonS3 amazonS3(){
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566","us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("123", "123")))
                .withPathStyleAccessEnabled(true)
                .build();
    }
}

