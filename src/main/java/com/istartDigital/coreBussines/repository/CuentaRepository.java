package com.istartDigital.coreBussines.repository;

import com.istartDigital.coreBussines.model.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

    List<Cuenta> findByFechaBetween(Date desde, Date hasta);
}
