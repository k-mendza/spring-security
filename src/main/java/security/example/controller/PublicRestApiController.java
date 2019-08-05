package security.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.example.model.user.User;
import security.example.model.user.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {

    private final UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public String test(){
        return "API Test";
    }

    @GetMapping("management/reports")
    public String managementReports(){
        return "Some report data";
    }

    @GetMapping("admin/users/all")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}