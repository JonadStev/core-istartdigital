package com.istartDigital.coreBussines.repository;

import com.istartDigital.coreBussines.model.Bloqueo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface BloqueoRepository extends CrudRepository<Bloqueo, Long> {

    List<Bloqueo> findByFechaSegundaRevisionBetween(Date des, Date has);
}
