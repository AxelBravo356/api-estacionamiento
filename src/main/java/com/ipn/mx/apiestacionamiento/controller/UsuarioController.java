package com.ipn.mx.apiestacionamiento.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
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

import com.ipn.mx.apiestacionamiento.modelo.entidades.Usuario;
import com.ipn.mx.apiestacionamiento.modelo.services.UsuarioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping("/usuarios")
    public List<Usuario> readAll() {
        return service.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Usuario newUser = null;

        try {
            newUser = service.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage().concat("=").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        if (newUser == null) {
            response.put("mensaje", "El usuario ".concat(id.toString()).concat(" no existe en la base de datos"));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Usuario deletedUser = null;

        try {
            Usuario userToDelete = service.findById(id);

            if (userToDelete == null) {
                response.put("mensaje", "El usuario con ID " + id + " no existe en la base de datos");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            deletedUser = userToDelete;
            service.delete(id);

            response.put("mensaje", "Usuario eliminado correctamente");
            response.put("usuario", deletedUser);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al borrar el usuario");
            response.put("error", "Ha ocurrido un error durante la operación");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            response.put("mensaje", "Error en los datos proporcionados");
            response.put("errores", result.getAllErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            Usuario savedUser = service.save(usuario);

            response.put("mensaje", "Usuario creado correctamente");
            response.put("usuario", savedUser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el usuario");
            response.put("error", "Ha ocurrido un error durante la operación");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Usuario user, BindingResult result, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Usuario updateUser = null;
        Usuario searchUser = service.findById(id);

        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() + " " +
                    err.getDefaultMessage()).collect(Collectors.toList());
            response.put("errores", errores);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (searchUser == null) {
            response.put("mensaje", "El usuario ".concat(id.toString()).concat(" no existe en la base de datos"));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        }

        try {
            searchUser.setNombreUsuario(user.getNombreUsuario());
            searchUser.setPaternoUsuario(user.getPaternoUsuario());
            searchUser.setMaternoUsuario(user.getMaternoUsuario());
            searchUser.setMotos(user.getMotos());

            updateUser = service.save(searchUser);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el usuario");
            response.put("error", e.getMessage().concat("=").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario se actualizó satisfactoriamente");
        response.put("usuario", updateUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
