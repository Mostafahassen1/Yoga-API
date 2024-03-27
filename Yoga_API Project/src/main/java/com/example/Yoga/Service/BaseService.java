
package com.example.Yoga.Service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    T findById(int id) ;

    List<T> saveAll(List<T> entity);

}

