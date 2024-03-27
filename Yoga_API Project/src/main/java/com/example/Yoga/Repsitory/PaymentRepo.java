
package com.example.Yoga.Repsitory;

import com.example.Yoga.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}

