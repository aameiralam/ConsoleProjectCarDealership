package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Car;

import java.util.List;

public interface CarRepository {

    public int insertCar(Car car);

    public List<Car> getAllCars();

    public int updateCar(Car updatedCar);

    public int deleteCar(Car deletedCar);


}
