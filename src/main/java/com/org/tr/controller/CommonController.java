/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.controller;

import com.org.tr.service.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;


public class CommonController<T, S extends ICRUD<T>> {
    
    @Autowired
    protected S service;
    
    
    
}
