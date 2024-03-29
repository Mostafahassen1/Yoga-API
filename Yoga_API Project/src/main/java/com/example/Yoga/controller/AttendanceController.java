
package com.example.Yoga.controller;

import com.example.Yoga.Models.Attendanceing;
import com.example.Yoga.Service.AttendnceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<List<Attendanceing>> FindAll() {
    List<Attendanceing> attendanceings = attendnceService.findAll();
    HttpHeaders headers = new HttpHeaders();

    if (!attendanceings.isEmpty()) {
        headers.add("AttendList_Header", "Attend Table is not empty");
        return ResponseEntity.ok().headers(headers).body(attendanceings);
    }

    else {
        headers.add("AttendList_Header", "No content available");
        return ResponseEntity.noContent().headers(headers).build();
    }

}


    @GetMapping("/{id_attend}")
    public ResponseEntity FindByID(@PathVariable int id_attend) {

        HttpHeaders headers = new HttpHeaders();

        Attendanceing attendanceing = attendnceService.findById(id_attend);
        if (attendanceing != null) {
            headers.add("Attend_Header ", "Attend found successfully. User details for ID " + id_attend);
            return ResponseEntity.ok().headers(headers).body(attendanceing);
        } else {
            headers.add("Attend_Header ", "Attendanceing not found for ID " + id_attend);
            return ResponseEntity.notFound().headers(headers).build();
        }

    }

@PostMapping("/")
public ResponseEntity<List<Attendanceing>> saveAll(@RequestBody List<Attendanceing> attendList){
    List<Attendanceing> attendanceings = attendnceService.saveAll(attendList) ;
    if(attendanceings != null || attendanceings.isEmpty() )
        return ResponseEntity.ok().body(attendanceings);
    else
        return ResponseEntity.badRequest().build();
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