package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Direccion;
import com.example.PEDIDOSAPP.repositorios.IDireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio {
    @Autowired
    IDireccionRepositorio repositorio;
    public Direccion guardarDireccion (Direccion datosDireccion)throws Exception{
        try{
            return this.repositorio.save(datosDireccion);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<Direccion> buscarTodosDireccion () throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



    public Direccion buscarDireccionPorId (Integer id) throws Exception{
        try {
            Optional<Direccion> direccionBuscada = this.repositorio.findById(id);
            if (direccionBuscada.isPresent()){
                return direccionBuscada.get();
            }else {
                throw new Exception("La direccion consultada no se encuentra en la BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Direccion modificarDireccion (Integer id,Direccion datosDireccion) throws  Exception{
        try {
            Optional <Direccion> direccionBuscada=this.repositorio.findById(id);
            if (direccionBuscada.isPresent()){
                direccionBuscada.get().setCiudad(datosDireccion.getCiudad());
                direccionBuscada.get().setCalle(datosDireccion.getCalle());
                return this.repositorio.save(direccionBuscada.get());
            }else{
                throw new Exception("Direccion no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarDireccion (Integer id) throws Exception{
        try {
            Optional<Direccion> direccionBuscarda = this.repositorio.findById(id);
            if (direccionBuscarda.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
























}
