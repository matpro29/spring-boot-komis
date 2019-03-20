package matpro29.komis;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private  UserRepository repository;

    public  UserController( UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<User> ars() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}
