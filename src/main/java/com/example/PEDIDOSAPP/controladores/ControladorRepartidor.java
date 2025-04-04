package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Repartidor;
import com.example.PEDIDOSAPP.servicios.RepartidorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repartidor")
public class ControladorRepartidor {
    @Autowired
    RepartidorServicio repartidorServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Repartidor datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.repartidorServicio.guardarRepartidor(datos));
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
                    .body(this.repartidorServicio.buscarTodosRepartidor());
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
                    .body(this.repartidorServicio.buscarRepartidorPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (@PathVariable Integer id,@RequestBody Repartidor datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.repartidorServicio.modificarRepartidor(id,datos));
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
                    .body(this.repartidorServicio.eliminarRepartidor(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

}
