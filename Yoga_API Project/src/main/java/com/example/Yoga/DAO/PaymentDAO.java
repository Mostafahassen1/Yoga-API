
package com.example.Yoga.DAO;

import com.example.Yoga.EntityYoga.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

public interface PaymentDAO extends JpaRepository<Payment, Integer> {
}

