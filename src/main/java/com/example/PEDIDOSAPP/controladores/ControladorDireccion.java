package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Direccion;
import com.example.PEDIDOSAPP.servicios.DireccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direccion")
public class ControladorDireccion {
    @Autowired
    DireccionServicio direccionServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Direccion datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.direccionServicio.guardarDireccion(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> buscarTodo (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.direccionServicio.buscarTodosDireccion());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.direccionServicio.buscarDireccionPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (Integer id, Direccion datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.direccionServicio.modificarDireccion(id,datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.direccionServicio.eliminarDireccion(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
