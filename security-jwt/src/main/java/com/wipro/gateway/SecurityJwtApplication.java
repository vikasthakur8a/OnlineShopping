package com.wipro.gateway;

import com.wipro.gateway.entity.User;
import com.wipro.gateway.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class SecurityJwtApplication {

    @Autowired
    private UserRepo repo;

    @PostConstruct
    public void addUsers() {
        List<User> users = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new User(i, "user" + i, "12345"))
                .collect(Collectors.toList());
        repo.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

}