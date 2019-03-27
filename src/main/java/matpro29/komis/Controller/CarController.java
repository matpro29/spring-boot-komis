package matpro29.komis.Controller;

import matpro29.komis.Entity.User;
import matpro29.komis.Repository.CarRepository;
import matpro29.komis.Entity.Car;
import matpro29.komis.Repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class CarController {
    private CarRepository carRepository;
    private UserRepository userRepository;

    public CarController(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/car/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public void add(@RequestBody HashMap hashMap) {
        Car car = new Car();
        car.setBrand((String)hashMap.get("brand"));
        car.setDescription((String)hashMap.get("description"));
        car.setModel((String)hashMap.get("model"));
        car.setPrice((String)hashMap.get("price"));
        car.setYear((String)hashMap.get("year"));

        User user = this.userRepository.findByUsername((String)hashMap.get("username"));
        car.setUser(user);

        carRepository.save(car);
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

    @RequestMapping("/car/info")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Car> info(@RequestBody String car_id) {
        Optional<Car> car = carRepository.findById(Long.parseLong(car_id));

        return car;
    }
}
