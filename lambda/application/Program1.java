package lambda.application;

import lambda.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Program1 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> productsList = new ArrayList<>();

        // input do arquivo .csv a ser lido
        System.out.print("Enter full file path: ");
        String filePath = sc.nextLine();

        try (BufferedReader buffReader = new BufferedReader(new FileReader(filePath))) {
            String line = buffReader.readLine();
            while (line != null) {
                String[] itemData = line.split(",");
                Product product = new Product(itemData[0], Double.parseDouble(itemData[1]));
                productsList.add(product);
                line = buffReader.readLine();
            }

            // cálculo da média dos produtos do arquivo .csv
            double average = productsList.stream()
                            .map(Product::getPrice)
                            .reduce(0.0, Double::sum) / productsList.size();
            System.out.println("Average price: " + String.format("%.2f", average));

            // imprimir uma lista de produtos que estão abaixo da média, em ordem decrescente
            productsList.stream()
                    .filter(product -> product.getPrice() < average)
                    .map(Product::getName)
                    .sorted(Comparator.reverseOrder()) // .sorted() em ordem decrescente
                    .forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        sc.close();

    }

}
