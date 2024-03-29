package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.SubscriptionRepo;
import com.example.Yoga.Models.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionsService implements BaseService<Subscription>{

    SubscriptionRepo subscriptionDAO ;

    public SubscriptionsService(SubscriptionRepo subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionDAO.findAll();
    }

    @Override
    public Subscription findById(int id) {
        Optional<Subscription> subscriptions = subscriptionDAO.findById(id);
        return subscriptions.orElse(null) ;
    }

    @Override
    public List<Subscription> saveAll(List<Subscription> entity) {

        return subscriptionDAO.saveAll(entity) ;
    }
}
