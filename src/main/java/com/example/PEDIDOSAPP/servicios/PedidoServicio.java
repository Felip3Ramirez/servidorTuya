package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Pedido;
import com.example.PEDIDOSAPP.repositorios.IPedidoRepositorio;
import com.example.PEDIDOSAPP.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    IPedidoRepositorio repositorio;

    public Pedido guardarPedido (Pedido datosPedido) throws Exception{
        try {
            return this.repositorio.save(datosPedido);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<Pedido> buscarTodosPedido ()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Pedido buscarPedidoPorId (Integer idPedido)throws Exception{
        try {
            Optional <Pedido> pedidoBuscado = this.repositorio.findById(idPedido);
            if (pedidoBuscado.isPresent()){
                return pedidoBuscado.get();
            }else {
                throw new Exception ("El pedido consultado no se encuentra en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Pedido modificarPedido (Integer idPedido,Pedido datosPedido) throws Exception{
        try {
            Optional<Pedido> pedidoBuscado=this.repositorio.findById(idPedido);
            if (pedidoBuscado.isPresent()){
                pedidoBuscado.get().setFechaPedido(datosPedido.getFechaPedido());
                pedidoBuscado.get().setEstado(datosPedido.getEstado());
                return this.repositorio.save(pedidoBuscado.get());
            }else {
                throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public boolean eliminarPedido (Integer id)throws Exception{
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
