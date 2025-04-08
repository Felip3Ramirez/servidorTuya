package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Entrega;
import com.example.PEDIDOSAPP.servicios.EntregaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class ControladorEntrega {
    @Autowired
    EntregaServicio entregaServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Entrega datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.entregaServicio.guardarEntrega(datos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public  ResponseEntity<?> buscarTodo (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entregaServicio.buscarTodosEntrega());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entregaServicio.buscarEntregaPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id,@RequestBody Entrega datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entregaServicio.modificarEntrega(id,datos));
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
                    .body(this.entregaServicio.eliminarEntrega(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

}
