package com.jeffssousa.payment_service.service;

import com.jeffssousa.payment_service.entity.Payment;
import com.jeffssousa.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment create(Payment payment) {

        payment.setStatus("APPROVED");

        return paymentRepository.save(payment);
    }

}