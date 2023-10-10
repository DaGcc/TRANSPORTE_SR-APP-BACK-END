package com.org.tr.serviceImpl;

import com.org.tr.model.Usuario;
import com.org.tr.repo.IUsuarioRepo;
import com.org.tr.service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, IUsuarioRepo> implements UserDetailsService, IUsuarioService {

    //Logger me permite escribir errores 
    private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private IUsuarioRepo repo;

    @Override
    @Transactional(readOnly = true) //METODO ESTANDAR DEL SPRING SECURITY
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repo.findByEmail(email); //obtenemos al usuario

        if (usuario == null) {
            logger.error("ERROR DE LOGIN: NO EXTISTE EL USUARIO " + email + " EN EL SISTEMA");
            throw new UsernameNotFoundException("ERROR DE LOGIN: NO EXTISTE EL USUARIO " + email + " EN EL SISTEMA");
            //throw new UsernameNotFoundException(String.format("USUARIO NO EXISTE", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getListaRole().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        System.out.println(roles);
        UserDetails userDetails = new User(usuario.getEmail(), usuario.getPassword(), usuario.isEstado(), true, true, usuario.isNonLocked(), roles);
        return userDetails;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Transactional
    @Override
    public int cambiarClave(String nuevaClave, String email) throws Exception {
        int rpta = 0;
        try {
            repo.cambiarClave(nuevaClave, email);
            rpta = 1;
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

}
