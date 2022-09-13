package com.istartDigital.coreBussines.controller;

import com.istartDigital.coreBussines.dto.CuentaDto;
import com.istartDigital.coreBussines.model.Bloque;
import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.coreBussines.service.BloqueService;
import com.istartDigital.coreBussines.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("cuenta")
@CrossOrigin
public class CuentaController {


    @Autowired
    CuentaService cuentaService;

    @Autowired
    BloqueService bloqueService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/save")
    public Cuenta saveCuenta(@RequestBody CuentaDto cuentaDto) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaCuenta = null;
        try {
            fechaCuenta = formatter.parse(cuentaDto.getFecha());
        }catch (Exception e){
            System.out.println(e);
        }

        Cuenta cuenta = new Cuenta(
                cuentaDto.getCorreo(),
                cuentaDto.getPassword(),
                cuentaDto.getTelefono(),
                cuentaDto.getIpChip(),
                cuentaDto.getModelo(),
                fechaCuenta,
                cuentaDto.getResponsable(),
                cuentaDto.getEstado(),
                cuentaDto.getOperadora()
        );

        Bloque bloque = bloqueService.getBloqueById(cuentaDto.getBloque()).get();
        cuenta.setBloque(bloque);
        cuenta.setId(cuentaDto.getId());
        return cuentaService.saveCuenta(cuenta);
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/cargar")
    public Map<String, String> cargarCuenta(@RequestParam("bloque") long bloque , @RequestParam("fichero") MultipartFile file){
        Map<String, String> map = new HashMap<>();
        map.put("message", "Las cuentas han sido cargadas correctamente");

        System.out.println("BLOQUE ASIGNADO: " + bloque);
        Bloque objBloque = bloqueService.getBloqueById(bloque).get();
        try {
            Scanner obj = new Scanner(file.getInputStream());
            while (obj.hasNextLine()){
                String linea = obj.nextLine();
                String [] part = linea.split("\\|");

                String username = part[0];
                String password = part[1];
                String phone = part[2];
                String ipChip = part[3];
                String model = part[4];
                String fecha = part[5];
                String responsable = part[6];
                String estado = part[7];
                String operador = part[8];

                System.out.println("++++++ REGISTRANDO CUENTA ++++++");
                System.out.println(username+" "+password+" "+phone+" "+ipChip+" "+model+" "+fecha+" "+responsable+" "+estado+" "+operador);

                // String correo, String password, String telefono, String ipChip, String modelo, Date fecha, String responsable, String estado, String operadora

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaCuenta = null;
                try {
                    fechaCuenta = formatter.parse(fecha);
                }catch (Exception e){
                    System.out.println(e);
                }

                Cuenta cuenta = new Cuenta(username,password,phone,ipChip,model,fechaCuenta,responsable,estado.toUpperCase(),operador);
                cuenta.setBloque(objBloque);
                cuentaService.saveCuenta(cuenta);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return map;
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/all")
    public List<Cuenta> getCuentas(){
        return cuentaService.getAllCuentas();
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/{id}")
    public List<Cuenta> getCuentasByIdBloque(@PathVariable("id") long idBloque){
        return cuentaService.getCuentasByIdBloque(idBloque);
    }

}
