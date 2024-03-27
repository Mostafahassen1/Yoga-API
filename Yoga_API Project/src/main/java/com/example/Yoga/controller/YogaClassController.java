
package com.example.Yoga.controller;

import com.example.Yoga.Models.Classes;
import com.example.Yoga.Service.ClassesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yoga-classes")
public class YogaClassController {
    // field from BaseService
    // implement constructor
    // Handle rest methods
    ClassesService baseService ;
   // @Qualifier("ClassesService")
    public YogaClassController(ClassesService baseService) {

        this.baseService = baseService;
    }

    @GetMapping("/")
    public List<Classes> findAll(){

        return  baseService.findAll();
    }

    @GetMapping("/{id_class}")
    public Classes findById( @PathVariable int id_class ){

        return  baseService.findById(id_class);
    }

    @PostMapping("/")
    public List<Classes> SaveAll(@RequestBody List<Classes> theClass ){

        return  baseService.saveAll(theClass);
    }

}


// Format that used
/*

    private String title ;

    private String description ;

    private String start_time ;

    private String capacity ;

   [
   {
   "title" : "Yoga" ,
   "description" : "for beginner " ,
   "start_time" : "sunday / 1 PM " ,
   "capacity" : "10 person"
   } ,
   {
   "title" : "Yoga" ,
   "description" : "for beginner " ,
   "start_time" : "Monday / 3 PM " ,
   "capacity" : "20 person"
   }
   ]
 */