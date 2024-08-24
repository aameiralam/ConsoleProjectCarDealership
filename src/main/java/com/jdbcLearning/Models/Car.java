package com.jdbcLearning.Models;

import java.util.Objects;

public class Car {

//    CarId INT PRIMARY KEY AUTO_INCREMENT,
//    CarMake VARCHAR(100),
//    CarModel VARCHAR(100),
//    Caryear INT,
//    CarPrice DECIMAL(7,2)


    private String carMake;
    private String carModel;
    private int carYear;
    private double carPrice;
    private int CarId;

    public Car() {

    }

    public Car(String carMake, String carModel, int carYear, double carPrice) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carPrice = carPrice;
        this.carYear = carYear;


    }


    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        CarId = carId;
    }

    public String getcarMake() {
        return carMake;
    }

    public void setcarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getcarModel() {
        return carModel;
    }

    public void setcarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getcarPrice() {
        return carPrice;
    }

    public void setcarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getcarYear() {
        return carYear;
    }

    public void setcarYear(int carYear) {
        this.carYear = carYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carYear == car.carYear && Double.compare(carPrice, car.carPrice) == 0 && CarId == car.CarId && Objects.equals(carMake, car.carMake) && Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMake, carModel, carYear, carPrice, CarId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarId=" + CarId +
                ", carMake='" + carMake + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYear=" + carYear +
                ", carPrice=" + carPrice +
                '}';
    }
}


