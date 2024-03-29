package com.example.Yoga.Service;

import com.example.Yoga.Repsitory.PaymentRepo;
import com.example.Yoga.Models.PaymentYoga;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentService implements BaseService<PaymentYoga>{

    PaymentRepo paymentDAO ;

    public PaymentService(PaymentRepo paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public List<PaymentYoga> findAll() {
        return paymentDAO.findAll() ;
    }

    @Override
    public PaymentYoga findById(int id) {
        Optional<PaymentYoga> paymentOpject = paymentDAO.findById(id) ;
        return paymentOpject.orElse(null) ;
    }

    @Override
    public List<PaymentYoga> saveAll(List<PaymentYoga> entity) {
        return  paymentDAO.saveAll(entity);
    }
}
