package com.example.Yoga.controller;

import com.example.Yoga.Models.Subscriptions;
import com.example.Yoga.Service.SubscriptionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    SubscriptionsService  subscriptionsService ;

    public SubscriptionController(SubscriptionsService subscriptionsService) {
        this.subscriptionsService = subscriptionsService;
    }

    @GetMapping("/{id_subscribe}")
    public Subscriptions FindByID(@PathVariable int id_subscribe ) {

        return subscriptionsService.findById(id_subscribe);
    }

    @GetMapping("/")
    public List<Subscriptions> findAll(){

        return subscriptionsService.findAll();
    }

    @PostMapping("/")
    public List<Subscriptions>saveAll(@RequestBody List<Subscriptions> entity){
        return subscriptionsService.saveAll(entity) ;
    }


}

/*
// the format to push data

// by database -> yoga=# INSERT INTO subscriptions("subscription_data" , "number_of_session" , "id_package" , "user_id" ) VALUES
//( '2024-03-07' , 13 , 2 , 5 ) ;



---> Post data   --> http://localhost:8080/subscriptions/
Format :

[
 {

    "user": {
        "id": 3
    },
    "aPackage": {
        "id": 3
    },
    "number_Of_Session": 7,
    "subscription_data": "2024-02-08T00:00:00"
}
]

 */