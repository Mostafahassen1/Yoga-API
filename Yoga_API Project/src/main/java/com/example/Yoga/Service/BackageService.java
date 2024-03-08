package com.example.Yoga.Service;

import com.example.Yoga.DAO.PackageDAO;
import com.example.Yoga.EntityYoga.Packages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackageService implements BaseService<Packages> {

    private PackageDAO packageDAO ;

    public BackageService(PackageDAO packageDAO) {
        this.packageDAO = packageDAO;
    }

    @Override
    public List<Packages> findAll() {
        return packageDAO.findAll();
    }


    @Override
    public Packages findById(int id) {
        Optional<Packages> optionPackage = packageDAO.findById(id) ;
        return optionPackage.orElse(null) ;
    }

    @Override
    public List<Packages> saveAll(List<Packages> entity) {
        return packageDAO.saveAll(entity);
    }
}
