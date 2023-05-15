package co.edu.uniquindio.Users.security;

import co.edu.uniquindio.Users.model.Usuario;
import co.edu.uniquindio.Users.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Aqui estan caargando el usuario: "+ username);
        Usuario usuario= usuarioRepositorio.findOneByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email: "+ username+ " no existe"));
        return new UserDetailsImpl(usuario);
    }
}
