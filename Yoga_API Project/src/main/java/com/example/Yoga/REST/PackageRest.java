package com.example.Yoga.REST;

import com.example.Yoga.EntityYoga.Packages;
import com.example.Yoga.Service.BackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PackageRest {

    private BackageService  backageService ;

    public PackageRest(BackageService backageService) {
        this.backageService = backageService;
    }
    @GetMapping("/package")
    public List<Packages> FindAll(){
        return backageService.findAll();
    }

    @GetMapping("/package/{packageId}")
    public Packages FindById( @PathVariable int id ){
        return backageService.findById( id ) ;

    }

    @PostMapping("/package")
    public List<Packages> SaveAll(@RequestBody  List<Packages> entity ){

        return backageService.saveAll(entity) ;
    }
}
