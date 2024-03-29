
package com.example.Yoga.Repsitory;

import com.example.Yoga.Models.PaymentYoga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentYoga, Integer> {
}

