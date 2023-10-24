package interfaces.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private final LocalDate dueDate;
    private final Double amount;

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter dTFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dueDate.format(dTFormat) + " - " + String.format("%.2f", amount);
    }
}
