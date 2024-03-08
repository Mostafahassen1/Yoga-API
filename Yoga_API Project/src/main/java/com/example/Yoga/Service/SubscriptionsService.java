package com.example.Yoga.Service;

import com.example.Yoga.DAO.SubscriptionDAO;
import com.example.Yoga.EntityYoga.Subscriptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionsService implements BaseService<Subscriptions>{

    SubscriptionDAO subscriptionDAO ;

    public SubscriptionsService(SubscriptionDAO subscriptionDAO) {
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
