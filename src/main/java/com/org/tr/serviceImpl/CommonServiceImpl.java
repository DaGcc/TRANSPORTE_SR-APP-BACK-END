package com.org.tr.serviceImpl;

import com.org.tr.service.ICRUD;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public class CommonServiceImpl<T, R extends JpaRepository<T, Integer>> implements ICRUD<T>{
     
    @Autowired
    protected R repo;

    @Override
    public T create(T t) {
        return this.repo.save(t);
    }

    @Override
    public List<T> readAll() {
        return this.repo.findAll();
    }

    @Override
    public T readById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public T update(T t) {
        return this.repo.save(t);
    }

    @Override
    public void deleteById(Integer id) {
        this.repo.deleteById(id);
    }

    @Override
    public Page<T> readByPage(Pageable pageable) {
        return this.repo.findAll(pageable);
    }
    
}