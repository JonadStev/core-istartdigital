package com.istartDigital.coreBussines.controller;

import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.coreBussines.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    CuentaService cuentaService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/bloqueadas")
    public List<Cuenta> getCuentasBloqueo(@RequestParam(name = "fechaDesde") String fechaDesde, @RequestParam(name = "fechaHasta") String fechaHasta){
        return cuentaService.getCuentasBloqueadas(fechaDesde,fechaHasta);
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/all")
    public List<Cuenta> getCuentas(){
        return cuentaService.getAllCuentas();
    }

}
