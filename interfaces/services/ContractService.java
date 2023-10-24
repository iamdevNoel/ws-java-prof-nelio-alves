package interfaces.services;

import interfaces.entities.Contract;
import interfaces.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicValue = contract.getTotalValue() / months;
        
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicValue, i);
            double paymentFee = onlinePaymentService.paymentFee(basicValue + interest);
            double amount = basicValue + interest + paymentFee;

            contract.getInstallments().add(new Installment(dueDate, amount));
        }
    }

}
