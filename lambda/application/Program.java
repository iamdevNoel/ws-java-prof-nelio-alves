package lambda.application;

import lambda.entities.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Enter full file path: ");
        File file = new File(sc.nextLine());
        List<Employee> employees = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            String csvItem = buffReader.readLine();
            while (csvItem != null) {
                String[] itemData = csvItem.split(",");
                String name = itemData[0];
                String email = itemData[1];
                double salary = Double.parseDouble(itemData[2]);
                Employee employee = new Employee(name, email, salary);
                employees.add(employee);
                csvItem = buffReader.readLine();
            }

            System.out.print("Enter minimum salary: ");
            double minSalary = sc.nextDouble();

            System.out.println("Email of people whose salary is greater than 2000.00: ");
            List<String> emails = employees.stream() // sequência de dados
                    .filter(e -> e.getSalary() > minSalary) /* filtra os dados conforme um retorno true
                    de uma função (semelhante a uma condição)*/
                    .map(Employee::getEmail) /* executa uma função pra todos os items da stream
                    sem alterar o array original */
                    .sorted() // ordena os dados
                    .collect(Collectors.toList()); /* converte o stream de volta para list
                    para que possa ser armazenado em uma variável */
            emails.forEach(System.out::println);

            double total = employees.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum); // reduz todos os números de uma stream para uma função
            System.out.printf("Total salary of people whose name starts with 'M': %.2f", total);

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

    }

}