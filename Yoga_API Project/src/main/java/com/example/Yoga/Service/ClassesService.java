package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.ClassesRepo;
import com.example.Yoga.Models.ClassYoga;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService implements BaseService<ClassYoga>{

    private ClassesRepo jpaRepository;

    public ClassesService(  ClassesRepo jpaRepository) {

        this.jpaRepository =  jpaRepository;
    }

    @Override
    public List<ClassYoga> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public ClassYoga findById(int id) {
        Optional<ClassYoga> optionalClass  = jpaRepository.findById(id);
        return optionalClass.orElse(null);

    }

    @Override
    public List<ClassYoga> saveAll(List<ClassYoga> entity) {
        jpaRepository.saveAll(entity) ;
        return entity ;
    }
}
