package com.example.demo;

import com.example.demo.data.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }



    @GetMapping("/users")
    public String getUsers(@RequestParam(value = "age", defaultValue = "0") int age) {
        ArrayList<User> users = new ArrayList<>(25);

        for (int i=0; i<25; i++){
            User user1 = new User("valodia",28);
             user1.setAge(i);
             users.add(user1);
        }



        String user = null;
        ObjectMapper om = new ObjectMapper();
        try {
            user = om.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return user;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = "application/json")
    public String createUser(@RequestBody User user){
        if(user.getAge()<0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type in correct age");
        }
        else {
            return HttpStatus.OK+": (Status code), "+"user name is :" + user.getName() + " ,age :" + user.getAge();
        }
    }

    @PostMapping("/createuser")
    public String createUser(@RequestParam (value = "name") String name) {
        User user2 = new User(name);
        user2.setAge(25);
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        session.beginTransaction();

        session.persist(user2);

        session.flush();
        session.close();
        return null;
    }

}

