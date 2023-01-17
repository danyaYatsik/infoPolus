package org.yatsiko.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Car {

    @NonNull
    private long id;

    @NonNull
    private String manufacturer;

    @NonNull
    private String model;
}
