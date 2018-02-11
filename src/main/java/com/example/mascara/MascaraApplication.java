package com.example.mascara;

import com.example.mascara.entity.Person;
import com.example.mascara.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class MascaraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MascaraApplication.class, args);
    }


    @Component
    class SampleDataCLR implements CommandLineRunner {

        private final PersonRepository personRepository;

        @Autowired
        public SampleDataCLR(PersonRepository personRepository) {
            this.personRepository = personRepository;
        }

        @Override
        public void run(String... args) throws Exception {

//            Stream.of("Suzy", "Sara", "Mamama", "Tatata")
//                    .forEach(name -> personRepository.save(
//                            Person.builder().name(name).age(new Random().nextInt()).build()));

            personRepository.findAll().forEach(System.out::println);

        }
    }
}
