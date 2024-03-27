package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.ClassesRepo;
import com.example.Yoga.Models.Classes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService implements BaseService<Classes>{

    private ClassesRepo jpaRepository;

    public ClassesService(  ClassesRepo jpaRepository) {

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
