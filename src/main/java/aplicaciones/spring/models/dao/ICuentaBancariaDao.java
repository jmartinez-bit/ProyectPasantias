package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.CuentaBancaria;

public interface ICuentaBancariaDao extends CrudRepository<CuentaBancaria, Long>{

}
