package com.example.Yoga.Service;

import com.example.Yoga.DAO.ClassesDAO;
import com.example.Yoga.EntityYoga.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService implements BaseService<Classes>{

    private ClassesDAO jpaRepository;

    public ClassesService(  ClassesDAO jpaRepository) {

        this.jpaRepository =  jpaRepository;
    }

    @Override
    public List<Classes> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Classes findById(int id) {
        Optional<Classes> optionalClass  = jpaRepository.findById(id);
        return optionalClass.orElse(null);

    }

    @Override
    public List<Classes> saveAll(List<Classes> entity) {
        jpaRepository.saveAll(entity) ;
        return entity ;
    }
}
