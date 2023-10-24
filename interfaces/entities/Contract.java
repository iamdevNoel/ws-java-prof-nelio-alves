package interfaces.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contract {

    private final Integer number;
    private final LocalDate date;
    private final Double totalValue;

    private final ArrayList<Installment> installments = new ArrayList<>();

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public ArrayList<Installment> getInstallments() {
        return installments;
    }

    public Integer getNumber() {
        return number;
    }
}
