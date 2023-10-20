package com.learning.consumingRestApi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
@GetMapping("/users")
    public User getUser(@RequestParam(value = "id", defaultValue = "1") Number id){
    String uri = "https://jsonplaceholder.typicode.com/users/"+id;
    RestTemplate restTemplate = new RestTemplate();
    User user = restTemplate.getForObject(uri,User.class);
    return user;
}
}
