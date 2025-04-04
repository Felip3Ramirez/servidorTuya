package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Entrega;
import com.example.PEDIDOSAPP.modelos.Pago;
import com.example.PEDIDOSAPP.servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
public class ControladorPago {
    @Autowired
    PagoServicio pagoServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Pago datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.pagoServicio.guardarPago(datos));
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
                    .body(this.pagoServicio.buscarTodosPago());
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
                    .body(this.pagoServicio.buscarPagoPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (@PathVariable Integer id,@RequestBody Pago datos){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pagoServicio.modificarPago(id,datos));
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
                    .body(this.pagoServicio.eliminarPago(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
