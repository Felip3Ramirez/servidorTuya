package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Producto;
import com.example.PEDIDOSAPP.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {
    @Autowired
    ProductoServicio productoServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Producto datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.productoServicio.guardarUsuario(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> buscarTodos (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServicio.buscarTodosProducto());
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
                    .body(this.productoServicio.buscarProductoPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (@PathVariable Integer id,@RequestBody Producto datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServicio.modificarProducto(id,datos));
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
                    .body(this.productoServicio.eliminarProducto(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
