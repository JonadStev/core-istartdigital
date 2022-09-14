package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.dto.BloqueoDto;
import com.istartDigital.coreBussines.model.Bloqueo;
import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.coreBussines.repository.BloqueoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BloqueoServiceImpl implements BloqueoService{

    @Autowired
    BloqueoRepository bloqueoRepository;

    @Autowired
    CuentaService cuentaService;

    @Override
    public Bloqueo saveBloqueo(BloqueoDto bloqueo) {
        //Acualizar estao de la cuenta a BLOQUEADA
        Optional<Cuenta> cuenta = cuentaService.getCuentaById(bloqueo.getCuenta());
        cuenta.get().setEstado(bloqueo.getEstadoR2());
        cuentaService.saveCuenta(cuenta.get());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaPrimeraRevision = null;
        Date fechaSegundaRevision = null;
        try {
            fechaPrimeraRevision = formatter.parse(bloqueo.getFechaPrimeraRevision());
            fechaSegundaRevision = formatter.parse(bloqueo.getFechaSegundaRevision());
        }catch (Exception e){
            System.out.println(e);
        }

        Bloqueo b = new Bloqueo(bloqueo.getUsuario(),
                bloqueo.getEstadoR1(),
                fechaPrimeraRevision,
                bloqueo.getEstadoR2(),
                fechaSegundaRevision,
                bloqueo.getMotivo(),
                bloqueo.getDias(),
                bloqueo.getBloque(),
                bloqueo.getCuenta());

        return bloqueoRepository.save(b);
    }

    @Override
    public List<Bloqueo> getBloqueos() {
        return (List<Bloqueo>) bloqueoRepository.findAll();
    }

    @Override
    public boolean deleteBloqueo(long id) {
        try {
            Bloqueo bloqueo = bloqueoRepository.findById(id).get();

            Optional<Cuenta> cuenta = cuentaService.getCuentaById(bloqueo.getCuenta());
            cuenta.get().setEstado("ACTIVO");
            cuentaService.saveCuenta(cuenta.get());

            bloqueoRepository.delete(bloqueo);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
