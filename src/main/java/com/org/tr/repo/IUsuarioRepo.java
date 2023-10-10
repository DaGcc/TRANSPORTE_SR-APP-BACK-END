package com.org.tr.repo;

import com.org.tr.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {
    
    Usuario findByEmail(String email);
     
    @Modifying
    @Query("UPDATE Usuario u SET u.password =?1 WHERE u.email=?2")
    void cambiarClave(String nuevaClave,String email) throws Exception;
}
