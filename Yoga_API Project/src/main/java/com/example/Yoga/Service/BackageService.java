package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.PackageRepo;
import com.example.Yoga.Models.PackageYoga;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackageService implements BaseService<PackageYoga> {

    private PackageRepo packageDAO ;

    public BackageService(PackageRepo packageDAO) {

        this.packageDAO = packageDAO;
    }

    @Override
    public List<PackageYoga> findAll() {

        return packageDAO.findAll();
    }


    @Override
    public PackageYoga findById(int id) {
        Optional<PackageYoga> optionPackage = packageDAO.findById(id) ;
        return optionPackage.orElse(null) ;
    }

    @Override
    public List<PackageYoga> saveAll(List<PackageYoga> entity) {
        return packageDAO.saveAll(entity);
    }
}
