package com.example.PEDIDOSAPP.controladores;

import com.example.PEDIDOSAPP.modelos.Tienda;
import com.example.PEDIDOSAPP.servicios.TiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tienda")
public class ControladorTienda {

    @Autowired
    TiendaServicio tiendaServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tienda datos) {

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.tiendaServicio.guardarUsuario(datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
    //Buscar todos
    @GetMapping
    public ResponseEntity <?> buscarTodos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tiendaServicio.buscarTodosTienda());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity <?> buscarId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tiendaServicio.buscarTiendaPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar (@PathVariable Integer id,@RequestBody Tienda datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tiendaServicio.modificarTienda(id,datos));
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
                    .body(this.tiendaServicio.eliminarTienda(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }







}
