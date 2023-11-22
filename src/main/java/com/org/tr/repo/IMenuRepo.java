package com.org.tr.repo;

import com.org.tr.model.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMenuRepo extends JpaRepository<Menu,Integer> {
    
        @Query(value = "SELECT m.* FROM menu m inner join menu_rol mr ON m.id_menu = mr.id_menu\n" +
"            		   inner join rol r ON r.id_rol=mr.id_rol\n" +
"            		   inner join usuario_rol ur ON ur.id_rol = r.id_rol\n" +
"            		   inner join usuario u ON u.id_usuario = ur.id_usuario\n" +
"            		   WHERE u.email=:email ORDER BY \n" +
"						CASE WHEN m.nombre ='Inicio' THEN 0 ELSE 1 END,\n" +
"							 m.nombre ASC;", nativeQuery = true)
    List<Object[]> listarMenuPorEmailUsuario(@Param("email")String email);
}
