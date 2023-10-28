package generics_sets_maps.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votesMap = new LinkedHashMap<>();

        System.out.println("Counting votes:");
        System.out.print("Enter a file path that contains votes: ");
        File file = new File(sc.nextLine());

        try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
            // ler linhas do arquivo .csv
            String lines = buffR.readLine();
            while (lines != null) {
                // splitar os dados
                String[] fields = lines.split(",");
                String name = fields[0];
                int votes = Integer.parseInt(fields[1]);
                // verificar se no Map já possui tal candidato
                if (votesMap.containsKey(name)) {
                    /* se sim, sobrescrever o valor (votos) da key (candidato) pela soma
                    ** da quantidade atual + a nova quantidade */
                    int updatedVotes = votesMap.get(name) + votes;
                    votesMap.put(name, updatedVotes);
                } else {
                    // se não, adicioná-lo ao map, com sua quantidade de votos inicial
                    votesMap.put(name, votes);
                }

                lines = buffR.readLine();
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        System.out.println("\nCounting finished: ");
        // Para cada candidato no conjunto de keys (candidatos)...
        for (String candidate : votesMap.keySet()) {
            System.out.println(candidate + ": " + votesMap.get(candidate));
        }

        sc.close();

    }

}
