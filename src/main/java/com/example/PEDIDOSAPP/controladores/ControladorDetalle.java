package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Detalle;
import com.example.PEDIDOSAPP.servicios.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
public class ControladorDetalle {
        @Autowired
        DetalleServicio detalleServicio;
        @PostMapping
        public ResponseEntity<?> guardar (@RequestBody Detalle datos){
            try {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(this.detalleServicio.guardarDetalle(datos));
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
                        .body(this.detalleServicio.buscarTodoDetalle());
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
                        .body(this.detalleServicio.buscarDetallePorId(id));
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }
        @PutMapping("/{id}")
        public ResponseEntity<?> modificar (Integer id, Detalle datos){
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.detalleServicio.modificarDetalle(id,datos));
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
                        .body(this.detalleServicio.eliminarDetalle(id));
            }catch (Exception error){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(error.getMessage());
            }
        }
}
