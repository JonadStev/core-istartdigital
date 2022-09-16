package com.istartDigital.coreBussines.controller;

import com.istartDigital.coreBussines.model.Bloque;
import com.istartDigital.coreBussines.service.BloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bloque")
@CrossOrigin
public class BloqueController {

    @Autowired
    BloqueService bloqueService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/save")
    public Bloque saveBloque(@RequestBody Bloque bloque){
        return bloqueService.saveBloque(bloque);
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_PRODUCCION')")
    @GetMapping("/all")
    public List<Bloque> getBloques(){
        return bloqueService.getAllBloque();
    }

}
