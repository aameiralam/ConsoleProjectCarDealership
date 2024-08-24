package com.jdbcLearning.Models;

import java.util.Objects;

public class Client {

    private long clientId;
    private String clientFirstName;
    private String clientLastName;
    private long clientPhoneNumber;
    private double clientSalary;

    public Client(){

    }

    public Client(String clientFirstName, String clientLastName, long clientPhoneNumber, double clientSalary) {

        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientSalary = clientSalary;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public long getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(long clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public double getClientSalary() {
        return clientSalary;
    }

    public void setClientSalary(double clientSalary) {
        this.clientSalary = clientSalary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientFirstName='" + clientFirstName + '\'' +
                ", clientId=" + clientId +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientPhoneNumber=" + clientPhoneNumber +
                ", clientSalary=" + clientSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && clientPhoneNumber == client.clientPhoneNumber && Double.compare(clientSalary, client.clientSalary) == 0 && Objects.equals(clientFirstName, client.clientFirstName) && Objects.equals(clientLastName, client.clientLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientFirstName, clientLastName, clientPhoneNumber, clientSalary);
    }
}
