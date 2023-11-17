/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.serviceImpl;

import com.org.tr.model.Menu;
import com.org.tr.repo.IMenuRepo;
import com.org.tr.service.IMenuService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends CommonServiceImpl<Menu, IMenuRepo> implements IMenuService {

    @Override
    public List<Menu> listarMenuPorEmailUsuario(String email) {
        List<Menu> listaMenu = new ArrayList<>();

        //este repo.listarMenuPorUsuario me retorna una Lista de objeto por ejemplo:
        //cantidad      fecha
        //[ 1     ,  11/05/2020]   este es un arreglo                   los dos son parte de una lista
        //[ 4     ,  12/05/2020]   este es un segundo arreglo 
        // posi 0       pasi 1
        repo.listarMenuPorEmailUsuario(email).forEach(menu -> {
            Menu m = new Menu();
            m.setIdMenu((Integer) menu[0]);
            m.setIcon((String) menu[1]);
            m.setNombre((String) menu[2]);
            m.setUrl((String) menu[3]);
            
            //System.out.println(m.getNombre());
            listaMenu.add(m);
        });

        return listaMenu;
    }

}
