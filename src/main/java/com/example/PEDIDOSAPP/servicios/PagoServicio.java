package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Pago;
import com.example.PEDIDOSAPP.repositorios.IPagoRepositorio;
import com.example.PEDIDOSAPP.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {
    @Autowired
    IPagoRepositorio repositorio;

    public Pago guardarPago (Pago datosPago)throws Exception{
        try {
            return this.repositorio.save(datosPago);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List <Pago> buscarTodosPago () throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Pago buscarPagoPorId (Integer idPago)throws Exception{
        try {
            Optional<Pago>pagoBuscado=this.repositorio.findById(idPago);
            if (pagoBuscado.isPresent()){
                return pagoBuscado.get();
            }else{
                throw new Exception("El pago consultado no se encuentra el la BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Pago modificarPago (Integer idPago,Pago datosPago) throws Exception{
        try {
            Optional<Pago> pagoBuscado =this.repositorio.findById(idPago);
            if (pagoBuscado.isPresent()){
                pagoBuscado.get().setEstado(datosPago.getEstado());
                pagoBuscado.get().setFechaPago(datosPago.getFechaPago());
                return this.repositorio.save(pagoBuscado.get());
            }else {
                throw new Exception("Pago no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarPago (Integer id)throws Exception{
        try{
            Optional<Pago> pagoBuscado=this.repositorio.findById(id);
            if (pagoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Pago no encotrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
