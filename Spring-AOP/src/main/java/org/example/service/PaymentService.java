package org.example.service;

import org.example.annotations.ToLog;
import org.example.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public void makePayment(Payment payment) {
        logger.info("Making payment of amount: ${} To Account Number: {} Of Bank: {}", payment.getAmount(), payment.getBankAccountNumber(), payment.getBankName());
    }

    public String makePaymentWithReturn(Payment payment) {
        logger.info("Making payment of amount: ${} To Account Number: {} Of Bank: {}", payment.getAmount(), payment.getBankAccountNumber(), payment.getBankName());
        return "Success";
    }

    @ToLog
    public String refundPayment(Payment payment) {
        logger.info("Refunded payment of amount: ${} To Account Number: {}", payment.getAmount(), payment.getBankAccountNumber());
        return "Success";
    }

}
