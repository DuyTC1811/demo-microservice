package com.example.departmentservice;

import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Department API", version = "${springdoc.version}", description = "Documentation Department API v1.0"))
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Bean
    DepartmentRepository repository() {
        DepartmentRepository repository = new DepartmentRepository();
        repository.add(new Department(1L, "Development"));
        repository.add(new Department(1L, "Operations"));
        repository.add(new Department(2L, "Development"));
        repository.add(new Department(2L, "Operations"));
        return repository;
    }
}
