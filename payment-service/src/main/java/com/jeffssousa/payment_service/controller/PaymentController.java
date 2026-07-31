package com.jeffssousa.payment_service.controller;

import com.jeffssousa.payment_service.entity.Payment;
import com.jeffssousa.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

}