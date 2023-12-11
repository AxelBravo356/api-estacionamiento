package com.ipn.mx.apiestacionamiento.controller;

import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
import java.util.stream.Collectors;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;
import jakarta.validation.Valid;
>>>>>>> 588c3c87707c9a9ad0b456ec9f6f96300232ee3f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.apiestacionamiento.modelo.entidades.Moto;
import com.ipn.mx.apiestacionamiento.modelo.services.MotoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class MotoController {

    @Autowired
    private MotoService service;

    @GetMapping("/motos")
    public List<Moto> findAll() {
        return service.findAll();
    }

    @GetMapping("/motos/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Moto newMoto = null;

        try {
            newMoto = service.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage().concat("=").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (newMoto == null) {
            response.put("mensaje", "La moto con ID ".concat(id.toString()).concat(" no existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newMoto, HttpStatus.OK);
    }

    @PostMapping("/moto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@Valid @RequestBody Moto moto, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            response.put("mensaje", "Error en los datos proporcionados");
            response.put("errores", result.getAllErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            Moto savedMoto = service.save(moto);

            response.put("mensaje", "Moto creada correctamente");
            response.put("moto", savedMoto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear la moto");
            response.put("error", "Ha ocurrido un error durante la operación");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*    @DeleteMapping("/motos/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) {
            service.delete(id);
        }*/
    @DeleteMapping("/motos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Moto deletedMoto = null;

        try {
            Moto motoToDelete = service.findById(id);

            if (motoToDelete == null) {
                response.put("mensaje", "La moto con ID " + id + " no existe en la base de datos");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            deletedMoto = motoToDelete;
            service.delete(id);

            response.put("mensaje", "Moto eliminada correctamente");
            response.put("moto", deletedMoto);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al borrar el usuario");
            response.put("error", "Ha ocurrido un error durante la operación");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/motos/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Moto moto, BindingResult result, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Moto updateMoto = null;
        Moto searchMoto = service.findById(id);

        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() + " " +
                    err.getDefaultMessage()).collect(Collectors.toList());
            response.put("errores", errores);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (searchMoto == null) {
            response.put("mensaje", "El usuario ".concat(id.toString()).concat(" no existe en la base de datos"));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        }

        try {
            searchMoto.setMarcaMoto(moto.getMarcaMoto());
            searchMoto.setModeloMoto(moto.getModeloMoto());
            searchMoto.setSerieMoto(moto.getSerieMoto());
            searchMoto.setPlacasMoto(moto.getPlacasMoto());

            updateMoto = service.save(searchMoto);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar la moto");
            response.put("error", e.getMessage().concat("=").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La moto se actualizó satisfactoriamente");
        response.put("moto", updateMoto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
