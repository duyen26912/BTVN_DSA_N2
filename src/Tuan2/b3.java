package Tuan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b3 {

    public static List<int[]> find(int[] numbers) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 0) {
                    pairs.add(new int[]{numbers[i], numbers[j]});
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);

            String n = scanner.nextLine();


            String[] numberStrings = n.split(" ");
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }


            List<int[]> pairs = find(numbers);
            for (int[] pair : pairs) {
                System.out.println(pair[0] + " " + pair[1]);
            }

        } catch (NumberFormatException ignored) {

        }
    }
}
