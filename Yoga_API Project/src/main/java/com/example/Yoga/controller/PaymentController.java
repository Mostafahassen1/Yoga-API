package com.example.Yoga.controller;


import com.example.Yoga.Models.Payment;
import com.example.Yoga.Models.Users;
import com.example.Yoga.Service.PaymentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<List<Payment>> FindAll() {
    List<Payment> payments = paymentService.findAll();
    HttpHeaders headers = new HttpHeaders();

    if (!payments.isEmpty()) {
        headers.add("PaymentList_Header", "Payment Table is not empty");
        return ResponseEntity.ok().headers(headers).body(payments);
    }

    else {
        headers.add("PaymentList_Header", "No content available");
        return ResponseEntity.noContent().headers(headers).build();
    }

}

@GetMapping("/{id_Payment}")
    public ResponseEntity FindByID(@PathVariable int id_Payment) {

        HttpHeaders headers = new HttpHeaders();

        Payment payment = paymentService.findById(id_Payment);
        if (payment != null) {
            headers.add("User_Header ", "Payment found successfully. User details for ID " + id_Payment);
            return ResponseEntity.ok().headers(headers).body(payment);
        } else {
            headers.add("Payment_Header ", "Payment not found for ID " + id_Payment);
            return ResponseEntity.notFound().headers(headers).build();
        }

    }

@PostMapping("/")
public ResponseEntity<List<Payment>> saveAll(@RequestBody List<Payment> payments ){
    List<Payment> paymentList = paymentService.saveAll(payments) ;
    if(paymentList != null || paymentList.isEmpty() )
        return ResponseEntity.ok().body(paymentList);
    else
        return ResponseEntity.badRequest().build();
}
}

/*
the format to Post
 SAVE ALL by POST ->> http://localhost:8080/payments/

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