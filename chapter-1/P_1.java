import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

public class P_1 {
    public static void main(String[] args) {
        // P_1.P_26.reverseInput();

        // P_1.P_27.calculator();

        // P_1.P_28.punishment();

        P_1.P_29.birthdayParadox(5);
    }

    /**
     * P-1.26
     * 
     * Write a short Java program that takes all the lines input to standard input
     * and writes them to standard output in reverse order. That is, each line is
     * output in the correct order, but the ordering of the lines is reversed.
     */
    private class P_26 {
        public static void main(String[] args) {
        }

        public static void reverseInput() {
            // get input from user
            Scanner input = new Scanner(System.in);
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while (input.hasNextLine()) {
                line = input.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                lines.add(line);
            }
            input.close();

            // clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // print input in reverse order
            System.out.println("Input in reverse order:");
            for (int j = lines.size() - 1; j >= 0; j--) {
                System.out.println(lines.get(j));
            }
        }
    }

    /**
     * P-1.27
     * 
     * Write a Java program that can simulate a simple calculator, using the Java
     * console as the exclusive input and output device. That is, each input to the
     * calculator, be it a number, like 12.34 or 1034, or an operator, like + or =,
     * can be done or a separate line. After each such input, you should output to
     * the Java console what would be displayed on your calculator.
     */
    private class P_27 {
        public static void main(String[] args) {
        }

        public static void calculator() {
            // get input from user
            Scanner input = new Scanner(System.in);
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while (input.hasNextLine()) {
                // clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                line = input.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                lines.add(line);

                // if input is a number or float or operator, display it
                if (line.matches("[0-9]+") || line.matches("[0-9]+\\.[0-9]+") || line.matches("[\\+\\-\\*\\/]")) {
                    // print all lines separated by spaces
                    for (int j = 0; j < lines.size(); j++) {
                        System.out.print(lines.get(j) + " ");
                    }
                    System.out.println();
                }

                // if input is =, calculate and display result
                else if (line.equals("=")) {
                    // get first number
                    double num1 = Double.parseDouble(lines.get(0));
                    // get operator
                    String operator = lines.get(1);
                    // get second number
                    double num2 = Double.parseDouble(lines.get(2));
                    // calculate result
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                    }
                    // display result
                    System.out.println(result);

                    // clear lines
                    lines.clear();
                }
            }
            input.close();
        }
    }

    /**
     * P-1.28
     * 
     * A common punishment for school children is to write out a sentence multiple
     * times. Write a Java stand-alone program that will write out the following
     * sentence one hundred times: “I will never spam my friends again.” Your
     * program should number each of the sentences and it should make eight
     * different randomlooking typos.
     */
    private class P_28 {
        public static void main(String[] args) {
        }

        public static void punishment() {
            Random random = new Random();
            Set<Integer> typoSentences = new HashSet<>();

            // generate 8 unique random numbers
            while (typoSentences.size() < 8) {
                typoSentences.add(random.nextInt(100));
            }

            // loop 100 times
            for (int i = 0; i < 100; i++) {
                // print sentence with possible typo
                String sentence = (i + 1) + ". I will never spam my friends again.";

                // introduce a random typo if i is in typoSentences
                if (typoSentences.contains(i)) {
                    int index = random.nextInt(sentence.length());
                    char typo = (char) (random.nextInt(26) + 'a');
                    sentence = sentence.substring(0, index) + typo + sentence.substring(index + 1);
                }

                System.out.println(sentence);
            }
        }
    }

    /**
     * P-1.29
     * 
     * The birthday paradox says that the probability that win a room will
     * have the same birthday is more than half, provided n, the number of people in
     * the room, is more than 23. This property is not really a paradox, but many
     * people find it surprising. Design a Java program that can test this paradox
     * by a series of experiments on randomly generated birthdays, which test this
     * paradox for n = 5,10,15,20,...,100.
     */
    private class P_29 {
        public static void main(String[] args) {
        }

        public static void birthdayParadox(int n) {
            while (n <= 100) {
                Random random = new Random();
                int[] birthdays = new int[n];
                int numberOfSameBirthdays = 0;
                // generate n birthdays
                for (int j = 0; j < n; j++) {
                    birthdays[j] = random.nextInt(365);
                }

                // get number of same birthdays
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (birthdays[j] == birthdays[k]) {
                            numberOfSameBirthdays++;
                        }
                    }
                }

                // calculate probability using formula
                double probability = 1;
                for (int j = 0; j < n; j++) {
                    probability *= (365 - j) / 365.0;
                }
                probability = 1 - probability;

                // display result
                System.out.println("Number of people: " + n);
                System.out.println("Number of same birthdays: " + numberOfSameBirthdays);
                System.out.println("Probability: " + probability);

                // increment n by 5
                n += 5;

                // print 5 blank lines
                for (int j = 0; j < 5; j++) {
                    System.out.println();
                }
            }

        }
    }
}
