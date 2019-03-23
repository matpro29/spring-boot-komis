package matpro29.komis.Controller;

import matpro29.komis.Repository.CarRepository;
import matpro29.komis.Entity.Car;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarController {
    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/car")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> ars() {
        return repository.findAll();
    }
}
