package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Car;
import com.jdbcLearning.Util.SqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarImpl implements CarRepository{
    @Override
    public int insertCar(Car car) {
        int status =0;
//        private int id;
//        private String CarMake;
//        private String CarModel;
//        private int CarYear;
//        private double CarPrice;
//        (String carMake, String carModel, double carPrice, int carYear, int id)
        try(Connection connection2 = SqlConnector.createConnection()){
            String sql = "INSERT into car (carMake,carModel, carYear,carPrice) VALUES (?,?,?,?)";
            PreparedStatement ps = connection2.prepareStatement(sql);
            ps.setString(1, car.getcarMake());
            ps.setString(2,car.getcarModel());
            ps.setInt(3,car.getcarYear());
            ps.setDouble(4, car.getcarPrice());

            status=ps.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    @Override
    public List<Car> getAllCars() {


        ArrayList<Car> carlist = new ArrayList<>();

        try (Connection connection2 = SqlConnector.createConnection()) {
            String query = "Select * from car";
            PreparedStatement ps = connection2.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Car carRs = new Car();
                carRs.setCarId(rs.getInt(1));
                carRs.setcarMake(rs.getString(2));
                carRs.setcarModel(rs.getString(3));
                carRs.setcarYear(rs.getInt(4));
                carRs.setcarPrice(rs.getDouble(5));
                carlist.add(carRs);
            }


        } catch (SQLException | NumberFormatException e ) {
            throw new RuntimeException(e);
        }

        return carlist;


    }

    @Override
    public int updateCar(Car updatedCar) {

        int status =0;
//
        try(Connection connection2 = SqlConnector.createConnection()){
            String update = "UPDATE car set carMake = ?, carModel = ?, carYear = ?, carPrice = ? where CarId = ?";
            PreparedStatement ps = connection2.prepareStatement(update);
            ps.setString(1, updatedCar.getcarMake());
            ps.setString(2,updatedCar.getcarModel());
            ps.setInt(3,updatedCar.getcarYear());
            ps.setDouble(4,updatedCar.getcarPrice());
            ps.setInt(5, updatedCar.getCarId());


            status=ps.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;





    }

    @Override
    public int deleteCar(Car deletedCar) {

        int status =0;
//
        try(Connection connection2 = SqlConnector.createConnection()){
            String delete = "DELETE FROM car where CarId = ?";
            PreparedStatement ps = connection2.prepareStatement(delete);
            ps.setInt(1, deletedCar.getCarId());


            status=ps.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;


    }
}
