package com.example.Yoga.controller;

import com.example.Yoga.Models.Packages;
import com.example.Yoga.Service.BackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private BackageService  backageService ;

    public PackageController(BackageService backageService) {

        this.backageService = backageService;
    }
    @GetMapping("/")
    public List<Packages> FindAll(){

        return backageService.findAll();
    }

    @GetMapping("/{id_package}")
    public Packages FindById( @PathVariable int id_package ){
        return backageService.findById( id_package ) ;

    }

    @PostMapping("/")
    public List<Packages> SaveAll(@RequestBody  List<Packages> entity ){

        return backageService.saveAll(entity) ;
    }
}
