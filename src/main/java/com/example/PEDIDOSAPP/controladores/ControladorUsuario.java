package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Usuario;
import com.example.PEDIDOSAPP.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio usuarioServicio;
    //Guardar
    @PostMapping
    public ResponseEntity <?> guardar (@RequestBody Usuario datosPeticion){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.guardarUsuario(datosPeticion));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar todos
    @GetMapping
    public ResponseEntity <?> buscarTodo (@RequestBody Usuario datosPeticion){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.buscarTodosUsuarios(datosPeticion));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar Id
    @GetMapping

    //Modificar
    @PutMapping

    //Eliminar
    @DeleteMapping


}
