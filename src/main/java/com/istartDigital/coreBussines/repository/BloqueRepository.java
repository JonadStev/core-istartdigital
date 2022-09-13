package com.istartDigital.coreBussines.repository;

import com.istartDigital.coreBussines.model.Bloque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueRepository extends CrudRepository<Bloque, Long> {
}
