package com.TapAcademy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1{
    public static void main(String[] args) {
    	System.out.println("Enter the input");
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            String patientDNA = input[0];
            String virusDNA = input[1];
            List<Integer> indices = findMatchingIndices(patientDNA, virusDNA);
            if (indices.isEmpty()) {
                System.out.println("No Match!");
            } else {
                for (int index : indices) {
                    System.out.print(index + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static List<Integer> findMatchingIndices(String patientDNA, String virusDNA) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i <= patientDNA.length() - virusDNA.length(); i++) {
            int mismatchCount = 0;
            for (int j = 0; j < virusDNA.length(); j++) {
                if (patientDNA.charAt(i + j) != virusDNA.charAt(j)) {
                    mismatchCount++;
                    if (mismatchCount > 1) {
                        break;
                    }
                }
            }
            if (mismatchCount <= 1) {
                indices.add(i);
            }
        }
        return indices;
    }
}
