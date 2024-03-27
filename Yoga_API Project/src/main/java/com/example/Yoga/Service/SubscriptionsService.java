package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.SubscriptionRepo;
import com.example.Yoga.Models.Subscriptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionsService implements BaseService<Subscriptions>{

    SubscriptionRepo subscriptionDAO ;

    public SubscriptionsService(SubscriptionRepo subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public List<Subscriptions> findAll() {
        return subscriptionDAO.findAll();
    }

    @Override
    public Subscriptions findById(int id) {
        Optional<Subscriptions> subscriptions = subscriptionDAO.findById(id);
        return subscriptions.orElse(null) ;
    }

    @Override
    public List<Subscriptions> saveAll(List<Subscriptions> entity) {

        return subscriptionDAO.saveAll(entity) ;
    }
}
