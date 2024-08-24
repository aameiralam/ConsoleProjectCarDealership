package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Client;
import com.jdbcLearning.Util.SqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements ClientRepository {
    @Override
    public int insertClient(Client client) {

        int status = 0;

        try (Connection connection2 = SqlConnector.createConnection()) {
            String sql = "INSERT INTO Client (clientfirstname, clientlastname, clientnumber, clientsalary) Values (?,?,?,?)";
            PreparedStatement ps = connection2.prepareStatement(sql);
            ps.setString(1, client.getClientFirstName());
            ps.setString(2, client.getClientLastName());
            ps.setLong(3, client.getClientPhoneNumber());
            ps.setDouble(4, client.getClientSalary());

            status = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return status;

    }

    @Override
    public List<Client> getAllClient() {

        ArrayList<Client> clientList = new ArrayList<>();
        try (Connection connection2 = SqlConnector.createConnection()) {
            String query = "SELECT * from Client";
            PreparedStatement ps = connection2.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client clientRs = new Client();
                clientRs.setClientId(rs.getInt(1));
                clientRs.setClientFirstName(rs.getString(2));
                clientRs.setClientLastName(rs.getString(3));
                clientRs.setClientPhoneNumber(rs.getLong(4));
                clientRs.setClientSalary(rs.getDouble(5));
                clientList.add(clientRs);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientList;

    }


    @Override
    public int updateClient(Client updatedClient) {
        int status = 0;
        try (Connection connection2 = SqlConnector.createConnection()) {
            String updateQuery = "UPDATE Client set clientfirstName =?, clientlastName = ?, clientnumber = ?, clientsalary=? where clientId = ?";
            PreparedStatement ps = connection2.prepareStatement(updateQuery);
            ps.setString(1, updatedClient.getClientFirstName());
            ps.setString(2, updatedClient.getClientLastName());
            ps.setLong(3, updatedClient.getClientPhoneNumber());
            ps.setDouble(4, updatedClient.getClientSalary());
            ps.setLong(5, updatedClient.getClientId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    @Override
    public int deleteClient(Client deletedClient) {
        int status = 0;
        try (Connection connection2 = SqlConnector.createConnection()) {
            String deleteQuery = "DELETE from Client where clientId = ?";
            PreparedStatement ps = connection2.prepareStatement(deleteQuery);
            ps.setLong(1, deletedClient.getClientId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }
}
