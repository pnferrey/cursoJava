package com.example.demo.jpa.app.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.jpa.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long > {
/*public List<Cliente> findAll();
public void save (Cliente cliente);
public Cliente findOne (Long id);
public void delete (Long id);*/
}

