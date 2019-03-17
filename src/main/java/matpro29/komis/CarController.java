package matpro29.komis;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
        return repository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Car car) {
        return !car.getBrand().equals("AMC Gremlin") &&
                !car.getBrand().equals("Triumph Stag") &&
                !car.getBrand().equals("Ford Pinto") &&
                !car.getBrand().equals("Yugo GV");
    }
}
