package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Pedido;
import com.example.PEDIDOSAPP.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ControladorPedido {
    @Autowired
    PedidoServicio pedidoServicio;
    @PostMapping
    public ResponseEntity<?> guardar (@RequestBody Pedido datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.pedidoServicio.guardarPedido(datos));
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
                    .body(this.pedidoServicio.buscarTodosPedido());
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
                    .body(this.pedidoServicio.buscarPedidoPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (@PathVariable Integer id,@RequestBody Pedido datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pedidoServicio.modificarPedido(id,datos));
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
                    .body(this.pedidoServicio.eliminarPedido(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
