package generics_sets_maps.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        System.out.print("How many students for course A? ");
        int loop = sc. nextInt();
        for (int i = 0; i < loop; i++) {
            int student = sc.nextInt();
            setA.add(student);
        }

        System.out.print("How many students for course B? ");
        loop = sc. nextInt();
        for (int i = 0; i < loop; i++) {
            int student = sc.nextInt();
            setB.add(student);
        }

        System.out.print("How many students for course C? ");
        loop = sc. nextInt();
        for (int i = 0; i < loop; i++) {
            int student = sc.nextInt();
            setC.add(student);
        }

        Set<Integer> setStudents = new HashSet<>(setA);
        setStudents.addAll(setB);
        setStudents.addAll(setC);

        System.out.println("Total students: " + setStudents.size());
        System.out.println(setStudents);

        sc.close();

    }

}
