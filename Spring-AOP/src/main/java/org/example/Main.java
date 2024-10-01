package org.example;

import org.example.config.ProjectConfig;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        PaymentService service = context.getBean(PaymentService.class);
        Payment payment = new Payment();
        payment.setAmount(999.99);
        payment.setBankName("Barclays");
        payment.setBankAccountNumber("54536288387200016");

        //Simple aspect
        service.makePayment(payment);
        //Aspect accessing and/or changing parameters and return value.
        String outcome = service.makePaymentWithReturn(payment);
        //Custom annotated aspect
        String refundOutcome = service.refundPayment(payment);

        //Altered return value
        System.out.println(outcome);
        System.out.println(refundOutcome);
    }
}