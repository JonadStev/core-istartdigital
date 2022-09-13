package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.coreBussines.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public List<Cuenta> getCuentasBloqueadas(String desde, String hasta) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(desde);
            dFinal = formatter.parse(hasta);
        }catch (Exception e){
            System.out.println(e);
        }

        List<Cuenta> cuentas = cuentaRepository.findByFechaBetween(dInicio,dFinal);

        return cuentas.stream().filter(x -> x.getEstado().equalsIgnoreCase("BLOQUEADA")).collect(Collectors.toList());
    }

    @Override
    public List<Cuenta> getCuentasByIdBloque(long idBloque) {
        List<Cuenta> cuentas = this.getAllCuentas();
        return cuentas.stream().filter(x -> x.getBloque() == idBloque).collect(Collectors.toList());
    }
}
