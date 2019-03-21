package matpro29.komis.Controller;

import matpro29.komis.Entity.User;
import matpro29.komis.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserRepository repository;

    public  UserController( UserRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/user")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public Collection<User> ars() {
//        return repository.findAll().stream()
//                .collect(Collectors.toList());
//    }

    @RequestMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public void register(@RequestBody User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setEmail(user.getEmail().toLowerCase());
        user.setUsername(user.getUsername().toLowerCase());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        repository.saveAndFlush(user);
    }

    @RequestMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean login(@RequestBody User user) {
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder() .decode(authToken)).split(":")[0];
    }
}
