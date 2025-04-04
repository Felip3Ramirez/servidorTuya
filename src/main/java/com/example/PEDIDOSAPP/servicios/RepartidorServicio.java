package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Repartidor;
import com.example.PEDIDOSAPP.modelos.Tienda;
import com.example.PEDIDOSAPP.repositorios.IDireccionRepositorio;
import com.example.PEDIDOSAPP.repositorios.IRepartidorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepartidorServicio {
    @Autowired
    IRepartidorRepositorio repositorio;
    public Repartidor guardarRepartidor (Repartidor datosRepartidor) throws Exception{
        try {
            return this.repositorio.save(datosRepartidor);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<Repartidor> buscarTodosRepartidor()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Repartidor buscarRepartidorPorId (Integer idRepartidor) throws Exception{
        try {
            Optional<Repartidor> repartidorBuscado=this.repositorio.findById(idRepartidor);
            if (repartidorBuscado.isPresent()){
                return repartidorBuscado.get();
            }else {
                throw new Exception("La repartidor consulta no se encuentra en la BD");
            }
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }
    public Repartidor modificarRepartidor (Integer idRepartidor,Repartidor datosRepartidor)throws Exception{
        try {
            Optional<Repartidor> repartidorBuscado=this.repositorio.findById(idRepartidor);
            if (repartidorBuscado.isPresent()){
                repartidorBuscado.get().setNombre(datosRepartidor.getNombre());
                repartidorBuscado.get().setCorreo(datosRepartidor.getCorreo());
                return this.repositorio.save(repartidorBuscado.get());
            }else {
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarRepartidor (Integer id)throws Exception{
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
























}
