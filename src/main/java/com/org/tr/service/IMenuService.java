package com.org.tr.service;

import com.org.tr.model.Menu;
import java.util.List;

public interface IMenuService extends ICRUD<Menu>{
        List<Menu> listarMenuPorEmailUsuario(String email);

}
