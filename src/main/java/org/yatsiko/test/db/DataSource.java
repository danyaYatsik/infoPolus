package org.yatsiko.test.db;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.yatsiko.test.entity.Car;
import org.yatsiko.test.entity.Person;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DataSource {

    private final Map<Long, Person> personMap = new HashMap<>();

    private final Map<Long, Car> carMap = new HashMap<>();

    public List<Person> getAllPersons() {
        return new ArrayList<>(personMap.values());
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(carMap.values());
    }

    public List<Person> getPersonsByIdIn(List<Long> ids) {
        return ids.stream().map(personMap::get).collect(Collectors.toList());
    }

    public List<Car> getCarsByIdIn(List<Long> ids) {
        return ids.stream().map(carMap::get).collect(Collectors.toList());
    }

    public Optional<Person> getPersonById(long id) {
        return Optional.ofNullable(personMap.get(id));
    }

    public Optional<Car> getCarById(long id) {
        return Optional.ofNullable(carMap.get(id));
    }

    @PostConstruct
    void mockInit() {
        Car car1 = new Car(0, "Tesla", "Y");
        Car car2 = new Car(1, "BMW", "x5");

        Person person1 = new Person(0, "Danya", "Yatsenko", new ArrayList<>());

        Person person2 = new Person(1, "Petya", "Petrov", new ArrayList<>(){{
            add(car1.getId());
        }});

        Person person3 = new Person(2, "Max", "Ivanov", new ArrayList<>() {{
            add(car1.getId());
            add(car2.getId());
        }});

        carMap.put(car1.getId(), car1);
        carMap.put(car2.getId(), car2);

        personMap.put(person1.getId(), person1);
        personMap.put(person2.getId(), person2);
        personMap.put(person3.getId(), person3);
    }

}
