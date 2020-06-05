package ru.spbstu.coursework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.spbstu.coursework.enteties.*;
import ru.spbstu.coursework.repositories.*;

import java.util.Collections;

@SpringBootApplication
public class CourseworkApplication {
    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(CourseworkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(MasterRepository repository) {
        return args -> {
            repository.save(new Master("Volodya"));
            repository.save(new Master("Makson"));

            carRepository.save(new Car("F674DS", "Black", "Mercedes", true));

            serviceRepository.save(new Service("fix trasmission", 7000.0, 10000.0));

            workRepository.save(new Work("31.03.2020", repository.findById(1).get(), serviceRepository.findById(1).get(), carRepository.findById(1).get()));

            userRepository.save(new User("user", passwordEncoder.encode("321"), Collections.singletonList("ROLE_USER")));
            userRepository.save(new User("admin", passwordEncoder.encode("4321"), Collections.singletonList("ROLE_ADMIN")));

            for (Master master: repository.findAll()) {
                log.info("Master is " + master);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
