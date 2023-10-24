package trabalhando_arquivos.application;

import trabalhando_arquivos.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Program01 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        ArrayList<Product> products = new ArrayList<>();

        //path of file .csv
        File csvFilePath = new File("C:\\Users\\gabri_000\\Documents\\ws-java\\trabalhando_arquivos\\Products.csv");

        //creating a Product object by getting data at .csv lines, and adding it to Products list
        try (BufferedReader buffR = new BufferedReader(new FileReader(csvFilePath))) {
            String csvItem = buffR.readLine();
            while (csvItem != null) {
                String[] itemData = csvItem.split(",");
                String name = itemData[0];
                double price = Double.parseDouble(itemData[1]);
                int quantity = Integer.parseInt(itemData[2]);
                Product product = new Product(name, price, quantity);
                products.add(product);

                csvItem = buffR.readLine();
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        //creating the \out subdirectory
        String fileDirectory = csvFilePath.getParent();
        new File(fileDirectory + "\\out").mkdir();

        //Writing products toString() into the new summary.csv file
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fileDirectory + "\\out\\summary.csv"))) {
            for (Product product : products) {
                buffWriter.write(product.toString());
                buffWriter.newLine();
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        //Reading summary.csv file
        try (BufferedReader buffR = new BufferedReader(new FileReader(fileDirectory + "\\out\\summary.csv"))) {
            System.out.println("You are now reading the content of summary.csv file:\n");
            String summaryLine = buffR.readLine();
            while (summaryLine != null) {
                System.out.println(summaryLine);
                summaryLine = buffR.readLine();
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

}
