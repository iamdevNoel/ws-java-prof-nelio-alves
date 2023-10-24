package interfaces.services;

public class PaypalService implements OnlinePaymentService {

    public Double interest(double amount, int months) {
        return amount * (0.01 * months);
    }

    public Double paymentFee(double amount) {
        return amount * 0.02;
    }

}
