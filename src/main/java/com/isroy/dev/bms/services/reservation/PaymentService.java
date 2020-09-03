package com.isroy.dev.bms.services.reservation;

public class PaymentService {

    long waitTime;

    public PaymentService() {
        this.waitTime = 5000;
    }

    public Boolean makePayment(double amount, long userId){
        try{
            Thread.sleep(waitTime);
        }catch (Exception ex){
            return false;
        }
        return Math.random() < 0.7;
//            return false;
    }

}
