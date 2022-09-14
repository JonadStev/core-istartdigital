package com.istartDigital.coreBussines.repository;

import com.istartDigital.coreBussines.model.Bloqueo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueoRepository extends CrudRepository<Bloqueo, Long> {
}
