package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Entrega;
import com.example.PEDIDOSAPP.repositorios.IEntregaRepositorio;
import com.example.PEDIDOSAPP.repositorios.IPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServicio {
    @Autowired
    IEntregaRepositorio repositorio;
    public Entrega guardarEntrega (Entrega datosentrega)throws Exception{
        try{
            return this.repositorio.save(datosentrega);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List <Entrega> buscarTodosEntrega ()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Entrega buscarEntregaPorId (Integer idEntrega) throws Exception{
        try {
            Optional <Entrega> entregaBuscada =this.repositorio.findById(idEntrega);
            if (entregaBuscada.isPresent()){
                return entregaBuscada.get();
            }else{
                throw new Exception("La entrega consulta no se encuentra en la base de datos");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Entrega modificarEntrega (Integer idEntrega,Entrega datosEntrega)throws Exception{
        try{
            Optional<Entrega> entregaBuscada = this.repositorio.findById(idEntrega);
            if (entregaBuscada.isPresent()){
                entregaBuscada.get().setEstadoEntrega(datosEntrega.getEstadoEntrega());
                entregaBuscada.get().setFechaEntrega(datosEntrega.getFechaEntrega());
                return this.repositorio.save(entregaBuscada.get());
            }else{
                throw new Exception("Entrega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarEntrega (Integer id)throws Exception{
        try {
            Optional <Entrega> entregaBuscada = this.repositorio.findById(id);
            if (entregaBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Entrega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }








}
