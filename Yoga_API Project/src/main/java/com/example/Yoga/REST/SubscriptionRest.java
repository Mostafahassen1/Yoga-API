package com.example.Yoga.REST;

import com.example.Yoga.EntityYoga.Subscriptions;
import com.example.Yoga.Service.SubscriptionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionRest {
    SubscriptionsService  subscriptionsService ;

    public SubscriptionRest(SubscriptionsService subscriptionsService) {
        this.subscriptionsService = subscriptionsService;
    }

    @GetMapping("/subscription/{idSubscribe}")
    public Subscriptions FindByID(@PathVariable int idSubscribe ) {
        return subscriptionsService.findById(idSubscribe);
    }

    @GetMapping("/subscription")
    public List<Subscriptions> findAll(){
        return subscriptionsService.findAll();
    }

    @PostMapping("/subscription")
    public List<Subscriptions>saveAll(@RequestBody List<Subscriptions> entity){
        return subscriptionsService.saveAll(entity) ;
    }


}

/*
// the format to push data

// by database -> yoga=# INSERT INTO subscriptions("subscription_data" , "number_of_session" , "id_package" , "user_id" ) VALUES
//( '2024-03-07' , 13 , 2 , 5 ) ;



---> Post data   --> http://localhost:8080/api/subscription
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