package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Detalle;
import com.example.PEDIDOSAPP.repositorios.IDetalleRepositorio;
import com.example.PEDIDOSAPP.repositorios.IEntregaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicio {
    @Autowired
    IDetalleRepositorio repositorio;
public Detalle guardarDetalle (Detalle datosDetalle)throws Exception{
    try {
        return this.repositorio.save(datosDetalle);
    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
}

public List<Detalle> buscarTodoDetalle () throws Exception{
    try {
        return this.repositorio.findAll();
    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
}

public Detalle buscarDetallePorId (Integer id) throws Exception{
    try {
        Optional<Detalle> detalleBuscado = this.repositorio.findById(id);
        if (detalleBuscado.isPresent()){
            return detalleBuscado.get();
        }else {
            throw new Exception("Los detalles consultados no se encuentran en la BD");
        }
    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
}

public Detalle modificarDetalle (Integer id,Detalle datosDetalle)throws Exception{
    try {
        Optional<Detalle> detalleBuscado=this.repositorio.findById(id);
        if (detalleBuscado.isPresent()){
            detalleBuscado.get().setCantidad(datosDetalle.getCantidad());
            detalleBuscado.get().setSubTotal(datosDetalle.getSubTotal());
            return this.repositorio.save(detalleBuscado.get());
        }else {
            throw new Exception("Detalles no encontrados");
        }
    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
}
public boolean eliminarDetalle (Integer id )throws Exception{
    try {
        Optional<Detalle> detalleBuscado =this.repositorio.findById(id);
        if (detalleBuscado.isPresent()){
            this.repositorio.deleteById(id);
            return true;
        }else{
            throw new Exception("Detalles no encontrados");
        }
    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
}



















}
