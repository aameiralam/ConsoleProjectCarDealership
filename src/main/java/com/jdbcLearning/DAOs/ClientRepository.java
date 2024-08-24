package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Client;

import java.util.List;

public interface ClientRepository {


    public int insertClient(Client client);

    public List<Client> getAllClient();

    public int updateClient(Client updatedClient);

    public int deleteClient(Client deletedClient);


}
