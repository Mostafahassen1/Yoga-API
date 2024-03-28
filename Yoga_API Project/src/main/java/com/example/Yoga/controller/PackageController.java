package com.example.Yoga.controller;

import com.example.Yoga.Models.Packages;
import com.example.Yoga.Models.Payment;
import com.example.Yoga.Models.Users;
import com.example.Yoga.Service.BackageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Packages>> FindAll() {
        List<Packages> packages = backageService.findAll();
        HttpHeaders headers = new HttpHeaders();

        if (!packages.isEmpty()) {
            headers.add("packageList_Header", "package Table is not empty");
            return ResponseEntity.ok().headers(headers).body(packages);
        }

        else {
            headers.add("packageList_Header", "No content available");
            return ResponseEntity.noContent().headers(headers).build();
        }

    }

@GetMapping("/{id_package}")
public ResponseEntity FindByID(@PathVariable int id_package) {

    HttpHeaders headers = new HttpHeaders();

    Packages packages = backageService.findById(id_package);
    if (packages != null) {
        headers.add("Package_Header ", "Package found successfully. User details for ID " + id_package);
        return ResponseEntity.ok().headers(headers).body(packages);
    }
    else {
        headers.add("Package_Header_Header ", "Package not found for ID " + id_package);
        return ResponseEntity.notFound().headers(headers).build();
    }

}

 @PostMapping("/")
 public ResponseEntity<List<Packages>> saveAll(@RequestBody List<Packages> packages){
     List<Packages>  packageList = backageService.saveAll(packages) ;
     if(packageList != null || packageList.isEmpty() )
         return ResponseEntity.ok().body(packageList);
     else
         return ResponseEntity.badRequest().build();
 }
}
