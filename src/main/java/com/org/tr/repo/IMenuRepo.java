package com.org.tr.repo;

import com.org.tr.model.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMenuRepo extends JpaRepository<Menu,Integer> {
    
        @Query(value = "select m.* from menu m inner join menu_rol mr on m.id_menu = mr.id_menu\n"
            + "						inner join rol r on r.id_rol=mr.id_rol\n"
            + "						inner join usuario_rol ur on ur.id_rol = r.id_rol\n"
            + "						inner join usuario u on u.id_usuario = ur.id_usuario\n"
            + "						where u.email=:email", nativeQuery = true)
    List<Object[]> listarMenuPorEmailUsuario(@Param("email")String email);
}
