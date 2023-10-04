package com.org.tr.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICRUD<T> {

    public T create(T t);

    public List<T> readAll();

    public T readById(Integer id);

    public Page<T> readByPage(Pageable pageable);

    public T update(T t);

    public void deleteById(Integer id);

}
