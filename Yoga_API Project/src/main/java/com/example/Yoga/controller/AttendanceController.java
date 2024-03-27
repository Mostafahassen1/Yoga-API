
package com.example.Yoga.controller;

import com.example.Yoga.Models.Attendanceing;
import com.example.Yoga.Service.AttendnceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    private AttendnceService attendnceService ;

    public AttendanceController(AttendnceService attendnceService) {

        this.attendnceService = attendnceService;
    }

    @GetMapping("/")
    public List<Attendanceing> FindAll(){

        return attendnceService.findAll();
    }

    @GetMapping("/{id_attend}")
    public Attendanceing FindByid(@PathVariable int id_attend){

        return attendnceService.findById(id_attend);
    }

    @PostMapping("/")
        public List<Attendanceing> SaveAll(@RequestBody List<Attendanceing> theAttend){
            return attendnceService.saveAll(theAttend) ;
    }
}



// the format to Pst request   Save All
/*
[
  {
    "aUser": {"id": 2},
    "aClass": {"id": 1}
  }
]

 */