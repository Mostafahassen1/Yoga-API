
package com.example.Yoga.REST;

import com.example.Yoga.EntityYoga.Classes;
import com.example.Yoga.Service.BaseService;
import com.example.Yoga.Service.ClassesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassesRest {
    // field from BaseService
    // implement constructor
    // Handle rest methods
    ClassesService baseService ;
   // @Qualifier("ClassesService")
    public ClassesRest(   ClassesService baseService) {

        this.baseService = baseService;
    }

    @GetMapping("/classes")
    public List<Classes> findAll(){

        return  baseService.findAll();
    }

    @GetMapping("/classes/{idClasses}")
    public Classes findById( @PathVariable int idClasses){

        return  baseService.findById(idClasses);
    }

    @PostMapping("/classes")
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