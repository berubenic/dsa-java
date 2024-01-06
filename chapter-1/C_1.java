public class C_1 {
    /**
     * C-1.14
     * 
     * Write a pseudocode description of a method that reverses an array of n
     * integers, so that the numbers are listed in the opposite order than they were
     * before, and compare this method to an equivalent Java method for doing the
     * same thing
     * 
     * A. The pseudocode for reversing an array of n integers is as follows:
     * for i = 0 to n/2
     * swap A[i] with A[n-i-1]
     * 
     * java.util.Collections.reverse(List list)
     * Collections.reverse() method in Java reverses the order of elements in a
     * list.
     * The array must first be converted to a list before it can be reversed.
     */

    /**
     * C-1.15
     * 
     * Write a pseudocode description of a method for finding the smallest and
     * largest numbers in an array of integers and compare that to a Java method
     * that would do the same thing.
     * 
     * A. The pseudocode for finding the smallest and largest numbers in an array of
     * integers is as follows:
     * 
     * min = A[0]
     * max = A[0]
     * for i = 1 to n-1
     * if A[i] < min min = A[i]
     * if A[i] > max max = A[i]
     * 
     * java.util.Collections.min(Collection coll)
     * java.util.Collections.max(Collection coll)
     * Both methods return the minimum and maximum element in the given collection,
     * according to the natural ordering of its elements.
     * The array must first be converted to a list before Collection methods can be
     * used.
     */

    /**
     * C-1.16
     * 
     * Write a short program that takes as input three integers, a, b, and c, from
     * the Java console and determines if they can be used in a correct arithmetic
     * formula (in the given order), like “a+b = c,” “a = b−c,” or “a ∗ b = c.”
     */
    public static void main(String[] args) {
        // int a = 1;
        // int b = 2;
        // int c = 3;

        // if (a + b == c) {
        // System.out.println("a + b = c");
        // } else if (a == b - c) {
        // System.out.println("a = b - c");
        // } else if (a * b == c) {
        // System.out.println("a * b = c");
        // } else {
        // System.out.println("No arithmetic formula found");
        // }

        // System.out.println(isProductEven(new int[] { 1, 2, 3, 4, 5 }));

        // System.out.println(norm(new int[] { 4, 3 }, 2));

        // System.out.println(divideByTwo(100));

        // System.out.println(isDistinct(new float[] { 1.0f, 2.0f, 3.0f }));
        // System.out.println(isDistinct(new float[] { 1.0f, 2.0f, 3.0f, 1.0f }));

        // int[] arr = new int[52];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = i + 1;
        // }
        // shuffle(arr);
        // System.out.println(java.util.Arrays.toString(arr));
        // shuffle(arr);
        // System.out.println(java.util.Arrays.toString(arr));

        // printAllPossibleStrings();

        // System.out.println(java.util.Arrays.toString(dotProduct(new int[] { 1, 2, 3
        // }, new int[] { 4, 5, 6 })));

        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new C_1().new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new C_1().new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
        wallet[2] = new C_1().new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);
        wallet[0].printSummary();
        System.out.println(wallet[1].toString());

    }

    /**
     * C-1.17
     * 
     * Write a short Java method that takes an array of int values and determines if
     * there is a pair of distinct elements of the array whose product is even.
     */
    public static boolean isProductEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                return true;
        }
        return false;
    }

    /**
     * C-1.18
     * 
     * The p-norm of a vector v = (v1,v2,...,vn) in n-dimensional space is defined
     * as ||v|| = √v1^p + v2^p + ... + vn^p
     * For the special case of p = 2, this results in the traditional Euclidean
     * norm, which represents the length of the vector. For example, the Euclidean
     * norm v of a two-dimensional vector with coordinates (4,3) has a Euclidean
     * norm of √4^2 +3^2 = √16+9 = √25 = 5. Give an implementation of a method named
     * norm such that norm(v, p) returns the p-norm value of v and norm(v) returns
     * the Euclidean norm of v, where v is represented as an array of coordinates.
     */
    public static double norm(int[] v, int p) {
        double sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += Math.pow(v[i], p);
        }
        return Math.sqrt(sum);
    }

    /**
     * C-1.19
     * 
     * Write a Java program that can take a positive integer greater than 2 as input
     * and write out the number of times one must repeatedly divide this number by
     * 2 before getting a value less than 2.
     */
    public static int divideByTwo(int n) {
        int count = 0;
        while (n > 2) {
            n /= 2;
            count++;
        }
        return count;
    }

    /**
     * C-1.20
     * 
     * Write a Java method that takes an array of float values and determines if all
     * the numbers are different from each other (that is, they are distinct).
     */
    public static boolean isDistinct(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    return false;
            }
        }
        return true;
    }

    /**
     * C-1.21
     * 
     * Write a Java method that takes an array containing the set of all integers in
     * the range 1 to 52 and shuffles it into random order. Your method should
     * output each possible order with equal probability.
     */
    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    /**
     * C-1.22
     * 
     * Write a short Java program that outputs all possible strings formed by using
     * the characters 'c', 'a', 't', 'd', 'o', and 'g' exactly once.
     */
    public static void printAllPossibleStrings() {
        String[] arr = { "c", "a", "t", "d", "o", "g" };
        generatePermutations(arr, 0, "");
    }

    private static void generatePermutations(String[] arr, int index, String current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!current.contains(arr[i])) {
                generatePermutations(arr, index + 1, current + arr[i]);
            }
        }
    }

    /**
     * C-1.23
     * 
     * Write a short Java program that takes two arrays a and b of length n storing
     * int values, and returns the dot product of a and b. That is, it returns an
     * array c of length n such that c[i] = a[i] · b[i], for i = 0,...,n−1.
     */
    public static int[] dotProduct(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }

    /**
     * C-1.24
     * 
     * Modify the CreditCard class from Code Fragment 1.5 so that printSummary
     * becomes a nonstatic method, and modify the main method from Code Fragment 1.6
     * accordingly.
     * 
     * C-1.25
     * 
     * Modify the CreditCard class to add a toString( ) method that returns a String
     * representation of the card (rather than printing it to the console, as done
     * by printSummary). Modify the main method from Code Fragment 1.6 accordingly
     * to use the standard println command.
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
        public void printSummary() {
            System.out.println("Customer = " + this.customer);
            System.out.println("Bank = " + this.bank);
            System.out.println("Account = " + this.account);
            System.out.println("Balance = " + this.balance); // implicit cast
            System.out.println("Limit = " + this.limit); // implicit cast
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Customer = ").append(customer).append("\n")
                    .append("Bank = ").append(bank).append("\n")
                    .append("Account = ").append(account).append("\n")
                    .append("Balance = ").append(balance).append("\n")
                    .append("Limit = ").append(limit);
            return sb.toString();
        }
    }

}
