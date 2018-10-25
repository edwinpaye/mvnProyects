package pract.firstWebService.demo.Dao;

import org.springframework.stereotype.Component;
import pract.firstWebService.demo.dto.Usuario;

@Component
public class UsuarioDao {

    public Usuario usuarioD(String nombre){
        return new Usuario(12, nombre, (byte)15, "apellido");
    }
}
