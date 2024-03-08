
package com.example.Yoga.REST;

import com.example.Yoga.EntityYoga.Attendanceing;
import com.example.Yoga.EntityYoga.Classes;
import com.example.Yoga.Service.AttendnceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceRest {
    private AttendnceService attendnceService ;

    public AttendanceRest(AttendnceService attendnceService) {
        this.attendnceService = attendnceService;
    }

    @GetMapping("/attendance")
    public List<Attendanceing> FindAll(){
        return attendnceService.findAll();
    }

    @GetMapping("/attendance/{attendId}")
    public Attendanceing FindByid(@PathVariable int attendId){
        return attendnceService.findById(attendId);
    }

    @PostMapping("/attendance")
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