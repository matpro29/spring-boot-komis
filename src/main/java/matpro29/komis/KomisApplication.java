package matpro29.komis;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.stream.Stream;

@SpringBootApplication
public class KomisApplication {

    public static void main(String[] args) {
        SpringApplication.run(KomisApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(CarRepository repository) {
//        return args -> {
//            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
//                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
//                Car car = new Car();
//                car.setBrand(name);
//                repository.save(car);
//            });
//            repository.findAll().forEach(System.out::println);
//        };
//    }
}
