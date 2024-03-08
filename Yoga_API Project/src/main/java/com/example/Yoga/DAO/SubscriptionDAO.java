
package com.example.Yoga.DAO;

import com.example.Yoga.EntityYoga.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.concurrent.Flow;

public interface SubscriptionDAO extends JpaRepository<Subscriptions, Integer> {
}


