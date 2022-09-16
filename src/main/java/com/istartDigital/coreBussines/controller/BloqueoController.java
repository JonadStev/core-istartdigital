package com.istartDigital.coreBussines.controller;

import com.istartDigital.coreBussines.dto.BloqueoDto;
import com.istartDigital.coreBussines.model.Bloqueo;
import com.istartDigital.coreBussines.service.BloqueoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bloqueo")
@CrossOrigin("*")
public class BloqueoController {

    @Autowired
    BloqueoService bloqueoService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_PRODUCCION')")
    @PostMapping("/save")
    public Bloqueo saveBloqueo(@RequestBody BloqueoDto bloqueo){
        return bloqueoService.saveBloqueo(bloqueo);
    }

    //@PreAuthorize("hasRole({'ROLE_SUPERVISOR','ROLE_PRODUCCION'})")
    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_PRODUCCION')")
    @GetMapping("/all")
    public List<Bloqueo> getBloqueos(){
        return bloqueoService.getBloqueos();
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_PRODUCCION')")
    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteBloque(@PathVariable("id") long id){
        Map<String, String> map = new HashMap<>();
        if(bloqueoService.deleteBloqueo(id))
            map.put("message", "Se ha eliminado el bloqueo correctamente");
        else
            map.put("message", "No se ha podido eliminar el bloqueo");
        return map;
    }


}
