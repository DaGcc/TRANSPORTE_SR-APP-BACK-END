package com.org.tr.service;

import com.org.tr.model.Usuario;


public interface IUsuarioService extends ICRUD<Usuario> {
 Usuario findByEmail(String findByEmail);
 int cambiarClave(String nuevaClave,String email) throws Exception;
}
