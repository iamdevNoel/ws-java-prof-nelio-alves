package generics_sets_maps.application;

import generics_sets_maps.entities.LogEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<LogEntry> logEntrySet= new HashSet<>();

        //input
        System.out.print("Enter file full path: ");
        File file = new File(sc.nextLine());

        //ler cada linha do arquivo
        try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
            String line = buffR.readLine();

            while (line != null) {
                //splitar as linhas do arquivo para separar os dados username e instant
                String[] info = line.split(" ");
                //usar essas informações separadas para construir um objeto logEntry
                LogEntry logEntry = new LogEntry(info[0], Instant.parse(info[1]));
                //adicionar o novo objeto ao Set
                logEntrySet.add(logEntry);

                line = buffR.readLine();
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        //output
        //Uma vez que o Set não repete elementos, a quantidade de objetos = tamanho do Set
        System.out.println("Total users: " + logEntrySet.size());

        sc.close();

    }

}
