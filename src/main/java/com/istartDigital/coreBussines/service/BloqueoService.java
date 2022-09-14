package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.dto.BloqueoDto;
import com.istartDigital.coreBussines.model.Bloqueo;

import java.util.List;

public interface BloqueoService {

    Bloqueo saveBloqueo(BloqueoDto bloqueo);

    List<Bloqueo> getBloqueos();

    boolean deleteBloqueo(long id);

}
