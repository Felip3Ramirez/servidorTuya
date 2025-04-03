package com.example.PEDIDOSAPP.servicios;

import com.example.PEDIDOSAPP.modelos.Usuario;
import com.example.PEDIDOSAPP.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    IProductoRepositorio repositorio;

    //Listar los metodos que activaran las consultas en la base de datos
    //Guardar
    public Producto guardarUsuario(Producto datosProducto)throws Exception {
        try {
            //validar los datos de entrada
            return this.repositorio.save(datosProducto);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Buscar todos los registros
    public List<Producto> buscarTodosUServicio()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Buscar por ID
    public Producto buscarServicioPorId (Integer idServicio)throws Exception{
        try {
            Optional<Producto> usuarioBuscado=this.repositorio.findById(idProducto);
            if (servicioBuscado.isPresent()){
                return servicioBuscado.get();
            }else {
                throw new Exception("el usuario consultado no esta en la BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar por ID
    public Usuario modificarUsuario (Integer idUsuario,Usuario datosUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(idUsuario);
            if (usuarioBuscado.isPresent()){
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                return this.repositorio.save(usuarioBuscado.get());
            }else{
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar por ID
    public boolean eliminarUsuario(Integer id)throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



}
