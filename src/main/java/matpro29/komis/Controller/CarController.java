package matpro29.komis.Controller;

import matpro29.komis.Entity.User;
import matpro29.komis.Repository.CarRepository;
import matpro29.komis.Entity.Car;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class CarController {
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/car")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> index() {
        return carRepository.findAll();
    }

    @RequestMapping("/car/my")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> my(@RequestBody String user_id) {
        return carRepository.findAllByUserId(Long.parseLong(user_id));
    }
}
