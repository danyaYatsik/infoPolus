package org.yatsiko.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.yatsiko.test.entity.Car;

@Data
@Builder
@AllArgsConstructor
public class CarDto {

    @NonNull
    private String manufacturer;

    @NonNull
    private String model;

    public static CarDto fromEntity(@NonNull Car car) {
        return CarDto.builder()
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .build();
    }

}
