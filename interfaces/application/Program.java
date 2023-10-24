package interfaces.application;

import interfaces.entities.Contract;
import interfaces.entities.Installment;
import interfaces.services.ContractService;
import interfaces.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dTFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt(); /*Pending breakline*/ sc.nextLine();
        System.out.print("Date (dd/mm/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dTFormat);
        System.out.print("Contract total value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        int months = sc.nextInt();

        Contract contract = new Contract(number, date, totalValue);
        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, months);

        System.out.println("\nParcelas:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();

    }

}
