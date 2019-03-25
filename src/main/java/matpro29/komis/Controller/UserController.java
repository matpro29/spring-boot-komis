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
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private User user;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @RequestMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public void register(@RequestBody User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setUsername(user.getUsername().toLowerCase());
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        userRepository.save(user);
    }

    @RequestMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User login(@RequestBody User loginUser) {
        this.user = this.userRepository.findByUsername(loginUser.getUsername());

        if (!(user != null && this.bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword()))) {
            this.user = null;
        }

        return this.user;
    }
}
