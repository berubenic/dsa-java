import java.util.Scanner;

public class R_1 {
    private static final String VOWELS = "aeiouAEIOU";

    public static void main(String[] args) {
        inputAllBaseTypes();

        System.out.println(isMultiple(10, 5));

        System.out.println(isEven(10));

        System.out.println(sumOfPositiveIntegers(10));

        System.out.println(sumOfOddPositiveIntegers(10));

        System.out.println(sumOfSquaresOfPositiveIntegers(10));

        System.out.println(countVowels("Hello World!"));

        System.out.println(removePunctuation("Let's try, Mike!"));

        Flower flower = new R_1().new Flower("Rose", 5, 10.5f);
        System.out.println(flower.getName());
        System.out.println(flower.getNumberOfPetals());
        System.out.println(flower.getPrice());
        flower.setName("Lily");
        flower.setNumberOfPetals(6);
        flower.setPrice(15.5f);
        System.out.println(flower.getName());
        System.out.println(flower.getNumberOfPetals());
        System.out.println(flower.getPrice());

        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new R_1().new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new R_1().new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
        wallet[2] = new R_1().new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);

        /**
         * R-1.13
         * 
         * Modify the declaration of the first for loop in the main method in Code
         * Fragment 1.6 so that its charges will cause exactly one of the three credit
         * cards to attempt to go over its credit limit. Which credit card is it?
         * 
         * A. The first credit card will go over its credit limit. The change is that
         * the loop now iterates 58 times instead of 16 times.
         */
        for (int val = 1; val <= 58; val++) {
            wallet[0].charge(3 * val);
            System.out.println("1: " + wallet[0].getBalance());
            wallet[1].charge(2 * val);
            System.out.println("2: " + wallet[1].getBalance());
            wallet[2].charge(val);
            System.out.println("3: " + wallet[2].getBalance());
            System.out.println();
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }

        wallet[0].updateLimit(10000);

        CreditCard.printSummary(wallet[0]);

        System.out.println(wallet[0].charge(-10000));
    }

    /**
     * R-1.1
     * 
     * Write a short Java method, inputAllBaseTypes, that inputs a different value
     * of each base type from the standard input device and prints it back to the
     * standard output device.
     */
    private static void inputAllBaseTypes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a byte value:");
        byte byteValue = scanner.nextByte();
        System.out.println("You entered byte: " + byteValue);

        System.out.println("Enter a short value:");
        short shortValue = scanner.nextShort();
        System.out.println("You entered short: " + shortValue);

        System.out.println("Enter an int value:");
        int intValue = scanner.nextInt();
        System.out.println("You entered int: " + intValue);

        System.out.println("Enter a long value:");
        long longValue = scanner.nextLong();
        System.out.println("You entered long: " + longValue);

        System.out.println("Enter a float value:");
        float floatValue = scanner.nextFloat();
        System.out.println("You entered float: " + floatValue);

        System.out.println("Enter a double value:");
        double doubleValue = scanner.nextDouble();
        System.out.println("You entered double: " + doubleValue);

        System.out.println("Enter a boolean value:");
        boolean booleanValue = scanner.nextBoolean();
        System.out.println("You entered boolean: " + booleanValue);

        System.out.println("Enter a char value:");
        char charValue = scanner.next().charAt(0);
        System.out.println("You entered char: " + charValue);

        scanner.close();
    }

    /**
     * R-1.2
     * 
     * Q. Suppose that we create an array A of GameEntry objects, which has an
     * integer
     * scores field, and we clone A and store the result in an array B. If we then
     * immediately set A[4].score equal to 550, what is the score value of the
     * GameEntry object referenced by B[4]?
     * 
     * A. In Java, when you clone an array of objects, you are performing a shallow
     * copy. This means that the new array (B in this case) will have its own copy
     * of the references to the objects, but not the actual objects themselves.
     * 
     * So, if you modify an object in the original array A (like setting A[4].score
     * to 550), the changes will be reflected in the cloned array B as well, because
     * both arrays hold references to the same objects.
     * 
     * Therefore, the score value of the GameEntry object referenced by B[4] would
     * also be 550.
     */

    /**
     * R-1.3
     * 
     * Write a short Java method, isMultiple, that takes two long values, n and m,
     * and returns true if and only if n is a multiple of m, that is, n = mi for
     * some integer i.
     */
    private static boolean isMultiple(long n, long m) {
        return n % m == 0;
    }

    /**
     * R-1.4
     * 
     * Write a short Java method, isEven, that takes an int i and returns true if
     * and only if i is even. Your method cannot use the multiplication, modulus, or
     * division operators, however.
     */
    private static boolean isEven(int i) {
        return (i & 1) == 0;
    }

    /**
     * R-1.5
     * 
     * Write a short Java method that takes an integer n and returns the sum of all
     * positive integers less than or equal to n.
     */
    private static int sumOfPositiveIntegers(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    /**
     * R-1.6
     * 
     * Write a short Java method that takes an integer n and returns the sum of all
     * the odd positive integers less than or equal to n.
     */
    private static int sumOfOddPositiveIntegers(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }

        return sum;
    }

    /**
     * R-1.7
     * 
     * Write a short Java method that takes an integer n and returns the sum of the
     * squares of all positive integers less than or equal to n.
     */
    private static int sumOfSquaresOfPositiveIntegers(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += Math.pow(i, 2);
        }

        return sum;
    }

    /**
     * R-1.8
     * 
     * Write a short Java method that counts the number of vowels in a given
     * character string.
     */
    private static int countVowels(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (VOWELS.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }

    /**
     * R-1.9
     * 
     * Write a short Java method that uses a StringBuilder instance to remove all
     * the punctuation from a string s storing a sentence, for example, transforming
     * the string "Let’s try, Mike!" to "Lets try Mike".
     */
    private static String removePunctuation(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * R-1.10
     * 
     * Write a Java class, Flower, that has three instance variables of type String,
     * int, and float, which respectively represent the name of the flower, its
     * number of petals, and price. Your class must include a constructor method
     * that initializes each variable to an appropriate value, and your class should
     * include methods for setting the value of each type, and getting the value of
     * each type.
     */
    private class Flower {
        private String name;
        private int numberOfPetals;
        private float price;

        public Flower(String name, int numberOfPetals, float price) {
            this.name = name;
            this.numberOfPetals = numberOfPetals;
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumberOfPetals(int numberOfPetals) {
            this.numberOfPetals = numberOfPetals;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfPetals() {
            return numberOfPetals;
        }

        public float getPrice() {
            return price;
        }
    }

    /**
     * R-1.11
     * 
     * Modify the CreditCard class from Code Fragment 1.5 to include a method that
     * updates the credit limit.
     * 
     * R-1.12
     * 
     * Modify the CreditCard class from Code Fragment 1.5 so that it ignores any
     * request to process a negative payment amount.
     */
    private class CreditCard {
        // Instance variables:
        private String customer;
        private String bank;
        private String account;
        private int limit;
        protected double balance;

        // Constructors:
        public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
            customer = cust;
            bank = bk;
            account = acnt;
            limit = lim;
            balance = initialBal;
        }

        public CreditCard(String cust, String bk, String acnt, int lim) {
            this(cust, bk, acnt, lim, 0.0); // use a balance of zero as default
        }

        // Accessor methods:
        public String getCustomer() {
            return customer;
        }

        public String getBank() {
            return bank;
        }

        public String getAccount() {
            return account;
        }

        public int getLimit() {
            return limit;
        }

        public double getBalance() {
            return balance;
        }

        // Update methods:
        public boolean charge(double price) { // make a charge
            if (price < 0 || price + balance > limit) {
                return false; // refuse negative price
            }
            // at this point, the charge is successful
            balance += price; // update the balance
            return true; // announce the good news
        }

        public void makePayment(double amount) {
            balance -= amount;
        }

        public void updateLimit(int newLimit) {
            limit = newLimit;
        }

        // Utility method to print a card's information
        public static void printSummary(CreditCard card) {
            System.out.println("Customer = " + card.customer);
            System.out.println("Bank = " + card.bank);
            System.out.println("Account = " + card.account);
            System.out.println("Balance = " + card.balance); // implicit cast
            System.out.println("Limit = " + card.limit); // implicit cast
        }
    }

}
