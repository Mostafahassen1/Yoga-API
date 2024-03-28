package com.example.Yoga.controller;

import com.example.Yoga.Models.Subscriptions;
import com.example.Yoga.Models.Users;
import com.example.Yoga.Service.SubscriptionsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    SubscriptionsService  subscriptionsService ;

    public SubscriptionController(SubscriptionsService subscriptionsService) {
        this.subscriptionsService = subscriptionsService;
    }
/*
                    >>>>>> old Version >>>>>>>>

    @GetMapping("/{id_subscribe}")
    public Subscriptions FindByID(@PathVariable int id_subscribe ) {

        return subscriptionsService.findById(id_subscribe);
    }

 */
@GetMapping("/{id_subscribe}")
public ResponseEntity FindByID(@PathVariable int id_subscribe) {

    HttpHeaders headers = new HttpHeaders();

    Subscriptions subscriptions  = subscriptionsService.findById(id_subscribe);
    if (subscriptions != null) {
        headers.add("subscribe_Header ", "subscriber found successfully. subscriber details for ID " + id_subscribe);
        return ResponseEntity.ok().headers(headers).body(subscriptions);
    } else {
        headers.add("subscribe_Header ", "subscriber not found for ID " + id_subscribe);
        return ResponseEntity.notFound().headers(headers).build();
    }

}
/*
                               >>>>>> old Version >>>>>>>>

    @GetMapping("/")
    public List<Subscriptions> findAll(){

        return subscriptionsService.findAll();
    }

    @PostMapping("/")
    public List<Subscriptions>saveAll(@RequestBody List<Subscriptions> entity){
        return subscriptionsService.saveAll(entity) ;
    }
*/
@GetMapping("/")
public ResponseEntity<List<Subscriptions>> FindAll() {
    List<Subscriptions> subscriptions = subscriptionsService.findAll();
    HttpHeaders headers = new HttpHeaders();

    if (!subscriptions.isEmpty()) {
        headers.add("SubscriptionsList_Header", "Subscription Table is not empty");
        return ResponseEntity.ok().headers(headers).body(subscriptions);
    }

    else {
        headers.add("SubscriptionsList_Header", "No content available");
        return ResponseEntity.noContent().headers(headers).build();
    }

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