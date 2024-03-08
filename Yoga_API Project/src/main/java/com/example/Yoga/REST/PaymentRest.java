package com.example.Yoga.REST;


import com.example.Yoga.EntityYoga.Payment;
import com.example.Yoga.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentRest {
    // implement the field of BaseService
    // implement the constructor
    // implement and handle Rest methods

    PaymentService paymentService ;

    public PaymentRest(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public List<Payment> findAll(){
        return paymentService.findAll() ;

    }

    @GetMapping("/payment/{idPayment}")
    public Payment findById(@PathVariable int idPayment ){
        return paymentService.findById(idPayment) ;
    }

    @PostMapping("/payment")
    public List<Payment> saveAll(@RequestBody List<Payment> entity){
        return paymentService.saveAll(entity) ;
    }
}


// the format to push
// SAVE ALL by POST ->> http://localhost:8080/api/payment
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