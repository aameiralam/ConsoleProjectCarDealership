package com.jdbcLearning.Controller;

import com.jdbcLearning.DAOs.CarImpl;
import com.jdbcLearning.DAOs.CarRepository;
import com.jdbcLearning.DAOs.ClientImpl;
import com.jdbcLearning.Models.Car;
import com.jdbcLearning.Models.Client;
import com.jdbcLearning.Util.SqlConnector;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
//
        Connection connection2 = SqlConnector.createConnection();
        System.out.println(connection2);

//        System.out.println(SqlConnector.createConnection());

        CarImpl carAction = new CarImpl();
        ClientImpl clientImpObj = new ClientImpl();
//        (String carMake, String carModel, double carPrice, int carYear, int id)
//        Car toyota = new Car("Toyota","Camry",2012, 35280.75);
//        carAction.insertCar(toyota);          if not using scanner
//
//        List<Car>carList = carAction.getAllCars();
//        for(Car CarShow : carList){
//            System.out.println(CarShow);
//        } use it for showing all the cars

        Scanner scan = new Scanner(System.in);
        System.out.println("**************** WELCOME TO THE CAR DEALERSHIP ****************");
        System.out.println();
        System.out.println();


        boolean Halt = false;
        while (!Halt) {


            System.out.println("1) Hop into Car Details");


            System.out.println("2) Hop into Client Details");

            int mainOption = scan.nextInt();
            scan.nextLine();


            if (mainOption == 1) {

                boolean Stop = false;
                while (!Stop) {

                    System.out.println("1) Enter your Car Details: ");

                    System.out.println("2) Show all the Cars listed in the database: ");

                    System.out.println("3) Update Car details from the database: ");

                    System.out.println("4) Delete any Car detail: ");

                    System.out.println("5) Exit from the Dealership: ");

                    int Option = scan.nextInt();
                    scan.nextLine();

                    if (Option == 1) {

                        System.out.println("Enter the MAKE of your car: ");
                        String make = scan.nextLine();

                        System.out.println("Enter the MODEL of your car: ");
                        String model = scan.nextLine();

                        System.out.println("Enter the manufacture YEAR for your car: ");
                        int year = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Enter the price of your car: ");
                        double price = scan.nextDouble();
                        scan.nextLine();

                        Car carMaking = new Car(make, model, year, price);
                        carAction.insertCar(carMaking);
                        System.out.println();
                        System.out.println();
                        System.out.println("You have successfully entered your CAR into the database of our dealership ! ");


                    } else if (Option == 2) {
                        System.out.println("All the CARS listed are as follows: ");
                        System.out.println();
                        System.out.println();
                        List<Car> carList = carAction.getAllCars();

                        for (Car carOption2 : carList) {
                            System.out.println("Car Id: " + carOption2.getCarId());
                            System.out.println();
                            System.out.println("Car Make: " + carOption2.getcarMake());
                            System.out.println("Car Model: " + carOption2.getcarModel());
                            System.out.println("Car Year: " + carOption2.getcarYear());
                            System.out.println("Car Price: $ " + carOption2.getcarPrice());

//                        System.out.println(carOption2);


                        }

                    } else if (Option == 3) {


                        System.out.println("Enter the ID of the car you want to update: ");
                        int carId = scan.nextInt();
                        scan.nextLine();

                        Car carToUpdate = new Car();
                        carToUpdate.setCarId(carId);

                        System.out.println("Enter the updated make: ");
                        String newMake = scan.nextLine();


                        System.out.println("Enter the updated model: ");
                        String newModel = scan.nextLine();


                        System.out.println("Enter the updated year: ");
                        int newYear = scan.nextInt();
                        scan.nextLine();


                        System.out.println("Enter the updated price: ");
                        double newPrice = scan.nextDouble();
                        scan.nextLine();

                        carToUpdate.setcarMake(newMake);
                        carToUpdate.setcarModel(newModel);
                        carToUpdate.setcarYear(newYear);
                        carToUpdate.setcarPrice(newPrice);

                        int updateStatus = carAction.updateCar(carToUpdate);
                        System.out.println(updateStatus);
                        System.out.println();
                        System.out.println();
                        System.out.println("Your car with the given ID have been successfully updated");


                    } else if (Option == 4) {

                        System.out.println("Enter the car ID you would want to delete from the system: ");
                        int carDeleteId = scan.nextInt();
                        scan.nextLine();

                        Car carToDelete = new Car();
                        carToDelete.setCarId(carDeleteId);

                        int deleteStatus = carAction.deleteCar(carToDelete);
                        System.out.println();
                        System.out.println();
                        System.out.println("The details for the given Car ID has been deleted successfully");


                    } else if (Option == 5) {

                        System.out.println();
                        System.out.println();
                        System.out.println(" Thank you for using the dealership app ! ");
                        Stop = true;
                    }
                }
            } else if (mainOption == 2) {


                boolean Halt2 = false;
                while (!Halt2) {

                    System.out.println("1) Enter your details: ");

                    System.out.println("2) Show all the Client listed in the database: ");

                    System.out.println("3) Update Client details from the database: ");

                    System.out.println("4) Delete any Client detail: ");

                    System.out.println("5) Exit from the Dealership: ");

                    int Option2 = scan.nextInt();
                    scan.nextLine();

                    if (Option2 == 1) {

                        System.out.println("Enter your first name: ");
                        String firstName = scan.nextLine();

                        System.out.println("Enter your last name: ");
                        String lastName = scan.nextLine();

                        System.out.println("Enter your phone number: ");
                        long clientPhoneNumber = scan.nextLong();
                        scan.nextLine();

                        System.out.println("Enter your salary: ");
                        double clientSalary = scan.nextDouble();
                        scan.nextLine();

                        Client clientMaking = new Client(firstName, lastName, clientPhoneNumber, clientSalary);
                        clientImpObj.insertClient(clientMaking);
                        System.out.println();
                        System.out.println();
                        System.out.println("You have successfully entered your details into the database of our dealership ! ");


                    } else if (Option2 == 2) {
                        System.out.println("All the client information are listed as follows: ");
                        System.out.println();
                        System.out.println();
                        List<Client> clientList = clientImpObj.getAllClient();

                        for (Client clientOption2 : clientList) {
                            System.out.println("Client Id: " + clientOption2.getClientId());
                            System.out.println();
                            System.out.println("Your First Name: " + clientOption2.getClientFirstName());
                            System.out.println("Your Last Name: " + clientOption2.getClientLastName());
                            System.out.println("Your Phone Number: " + clientOption2.getClientPhoneNumber());
                            System.out.println("Your Salary: $ " + clientOption2.getClientSalary());

//                        System.out.println(carOption2);


                        }

                    } else if (Option2 == 3) {


                        System.out.println("Enter the CLIENT ID you want to update: ");
                        int clientId = scan.nextInt();
                        scan.nextLine();

                        Client clientsToUpdate = new Client();
                        clientsToUpdate.setClientId(clientId);

                        System.out.println("Enter the updated first name: ");
                        String newFirstName = scan.nextLine();


                        System.out.println("Enter the updated last name: ");
                        String newLastName = scan.nextLine();


                        System.out.println("Enter the updated phone number: ");
                        long newPhoneNumber = scan.nextLong();
                        scan.nextLine();


                        System.out.println("Enter the updated salary: ");
                        double newSalary = scan.nextDouble();
                        scan.nextLine();


                        clientsToUpdate.setClientFirstName(newFirstName);
                        clientsToUpdate.setClientLastName(newLastName);
                        clientsToUpdate.setClientPhoneNumber(newPhoneNumber);
                        clientsToUpdate.setClientSalary(newSalary);

                        int updateStatus2 = clientImpObj.updateClient(clientsToUpdate);
                        System.out.println(updateStatus2);
                        System.out.println();
                        System.out.println();
                        System.out.println("Your CLIENT with the given ID have been successfully updated");


                    } else if (Option2 == 4) {

                        System.out.println("Enter the CLIENT ID you would want to delete from the system: ");
                        int clientDeleteId = scan.nextInt();
                        scan.nextLine();

                        Client clientToDelete = new Client();
                        clientToDelete.setClientId(clientDeleteId);

                        int deleteStatus2 = clientImpObj.deleteClient(clientToDelete);
                        System.out.println();
                        System.out.println();
                        System.out.println("The details for the given CLIENT ID has been deleted successfully");


                    } else if (Option2 == 5) {

                        System.out.println();
                        System.out.println();
                        System.out.println(" Thank you for using the dealership app ! ");
                        Halt2 = true;


                    }
                }
            }
        }
    }
}
