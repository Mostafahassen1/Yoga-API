package com.example.Yoga.Service;

import com.example.Yoga.DAO.PaymentDAO;
import com.example.Yoga.EntityYoga.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentService implements BaseService<Payment>{

    PaymentDAO paymentDAO ;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public List<Payment> findAll() {
        return paymentDAO.findAll() ;
    }

    @Override
    public Payment findById(int id) {
        Optional<Payment> paymentOpject = paymentDAO.findById(id) ;
        return paymentOpject.orElse(null) ;
    }

    @Override
    public List<Payment> saveAll(List<Payment> entity) {
        return  paymentDAO.saveAll(entity);
    }
}
