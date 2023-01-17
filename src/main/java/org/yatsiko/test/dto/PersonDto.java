package org.yatsiko.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PersonDto {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private List<CarDto> cars;
}
