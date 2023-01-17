package org.yatsiko.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.yatsiko.test.db.DataSource;
import org.yatsiko.test.dto.CarDto;
import org.yatsiko.test.dto.PersonDto;
import org.yatsiko.test.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final DataSource dataSource;

    public PersonService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<PersonDto> getAllPersons() {
        return dataSource.getAllPersons().stream()
                .map(person -> PersonDto.builder()
                        .firstName(person.getFirstName())
                        .lastName(person.getLastName())
                        .cars(dataSource
                                .getCarsByIdIn(person.getCarsIds()).stream()
                                .map(CarDto::fromEntity)
                                .toList())
                        .build())
                .collect(Collectors.toList());
    }

    public PersonDto getPersonById(long id) {
        Person person = dataSource.getPersonById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        List<CarDto> cars = dataSource
                .getCarsByIdIn(person.getCarsIds()).stream()
                .map(CarDto::fromEntity).toList();

        return PersonDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .cars(cars)
                .build();
    }
}
