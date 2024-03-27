package com.example.Yoga.controller;


import com.example.Yoga.Models.Payment;
import com.example.Yoga.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    // implement the field of BaseService
    // implement the constructor
    // implement and handle Rest methods

    PaymentService paymentService ;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public List<Payment> findAll(){
        return paymentService.findAll() ;

    }

    @GetMapping("/{id-Payment}")
    public Payment findById(@PathVariable int id_Payment ){

        return paymentService.findById(id_Payment) ;
    }

    @PostMapping("/")
    public List<Payment> saveAll(@RequestBody List<Payment> entity){

        return paymentService.saveAll(entity) ;
    }
}


// the format to Post
// SAVE ALL by POST ->> http://localhost:8080/payments/
/*
[
{

    "subscripe": {
        "id": 1
    },
    "payment_date": "2024-03-09T00:00:00",
    "paymentMethod": "CASH",
    "payment": 20
}
]

 */