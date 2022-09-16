package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Bloque;
import com.istartDigital.coreBussines.repository.BloqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloqueServiceImpl implements BloqueService{

    @Autowired
    BloqueRepository bloqueRepository;

    @Override
    public Bloque saveBloque(Bloque bloque) {
        return bloqueRepository.save(bloque);
    }

    @Override
    public List<Bloque> getAllBloque() {
        return (List<Bloque>) bloqueRepository.findAll();
    }

    @Override
    public Optional<Bloque> getBloqueById(long id) {
        return bloqueRepository.findById(id);
    }
}
