import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /*
       1.Write a program to find all of the longest word in a given dictionary.
Example:
{ "cat", "dog", "red", "is", "am" }
Expected Output:
"cat", "dog", "red"

        */
        String[] dictionary = {"cat", "dog", "red", "is", "am"};
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        for (String word : dictionary) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear();
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }

        System.out.println("Longest words in the dictionary:");
        for (String word : longestWords) {
            System.out.println(word);
        }
  /*
  2. Write a program that displays the number of occurrences of an element in the array.
Original Array:
[1,1,1,3,3,5]
Sample Output:
3 occurs 2 times
1 occurs 3 times
9 occurs 0 time
   */
        int[] array = {1, 1, 1, 3, 3, 5};
        int[] occurrences = new int[10];

        for (int element : array) {
            occurrences[element]++;
        }

        System.out.println("Element occurrences:");
        for (int i = 0; i < occurrences.length; i++) {
            int count = occurrences[i];
            if (count > 0) {
                System.out.println(i + " occurs " + count + " time" + (count != 1 ? "s" : ""));


            }
        }

/*
3.Write a program to find the k largest elements in a given array. Elements in the array can be in
any order.
Original Array:
[1, 4, 17, 7, 25, 3, 100]
Expected Output:
3 largest elements of the said array are:
100 25 17
 */
        int[] array1 = {1, 4, 17, 7, 25, 3, 100};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of largest elements to find: ");
        int k = scanner.nextInt();

        int[] largestElements = new int[k];

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int j = 0; j < array1.length; j++) {
                if (array1[j] > max) {
                    max = array1[j];
                    maxIndex = j;
                }
            }

            largestElements[i] = max;
            array1[maxIndex] = Integer.MIN_VALUE; // Mark the element as visited
        }

        System.out.println(k + " largest elements of the array are:");
        for (int element : largestElements) {
            System.out.print(element + " ");


        }
/*
4. Create a method to reverse an array of integers. Implement the method without creating a new
array.
Original Array:
[5,4,3,2,1]
Expected Output:
Reversed Array:
1 2 3 4 5
 */
        int[] array3 = {5, 4, 3, 2, 1};

        System.out.println("Original Array:");
        printArray(array3);

        reverseArray(array3);

        System.out.println("Reversed Array:");
        printArray(array3);
    }

    public static void reverseArray(int[] array3) {
        int start = 0;
        int end = array3.length - 1;

        while (start < end) {
            int temp = array3[start];
            array3[start] = array3[end];
            array3[end] = temp;

            start++;
            end--;
        }
    }

    public static void printArray(int[] array3) {
        for (int element : array3) {
            System.out.print(element + " ");
        }
        System.out.println();

/*
5. Write a menu driven Java program with following option:
1. Accept elements of an array
2. Display elements of an array
3. Search the element within array
4. Sort the array
5. To Stop
the size of the array should be entered by the user
 */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    acceptElements(array, scanner);
                    break;
                case 2:
                    displayElements(array);
                    break;
                case 3:
                    searchElement(array, scanner);
                    break;
                case 4:
                    sortArray(array);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid .");
            }

            System.out.println();
        } while (choice != 5);
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Accept elements of an array");
        System.out.println("2. Display elements of an array");
        System.out.println("3. Search the element within array");
        System.out.println("4. Sort the array");
        System.out.println("5. Exit");
    }

    public static void acceptElements(int[] array, Scanner scanner) {
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Array elements accepted.");
    }

    public static void displayElements(int[] array) {
        System.out.println("Array elements:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void searchElement(int[] array, Scanner scanner) {
        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                System.out.println("Element " + target + " found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element " + target + " not found in the array.");
        }
    }

    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {


                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }}}
        System.out.println("Array sorted in ascending order.");
/*
6. Create a method that generates a random number within a given range. Allow the user to
specify the range and call the method to display random numbers.

 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minimum value of the range: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value of the range: ");
        int max = scanner.nextInt();
        System.out.print("Enter the number of random numbers to generate: ");
        int count = scanner.nextInt();

        System.out.println("Random numbers within the specified range:");
        generateRandomNumbers(min, max, count);}

    private static void generateRandomNumbers(int min, int max, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.print(randomNumber);
            if (i < count - 1) {
                System.out.print(" - ");}}

       /* 7. Write a program that checks the strength of a password. Create a method that evaluates a
        password based on criteria like length, inclusion of special characters, and uppercase/lowercase
        letters.
                - We have three methods: checkLength, checkSpecialCharacters, and
        checkUpperCaseLowerCase, each of which assigns a score based on specific criteria.
                - The totalScore is calculated by adding the scores from these methods.
        - Classify the password as strong (8 or more), moderately strong (5 or more), or weak
        based on the totalScore.
        - The criteria for scoring:
• Length: 0-5 characters (0 points), 6-7 characters (2 points), 8 or more characters
                (3 points).
• Special characters: Absence (0 points), Presence (2 points).
• Uppercase and lowercase letters: Absence of both (0 points), presence of both (3
        points).*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int totalScore = calculatePasswordStrength(password);

        System.out.println("Password Strength: " + classifyPasswordStrength(totalScore));

    }

    private static int calculatePasswordStrength(String password) {
        int score = 0;

        score += checkLength(password.length());
        score += checkSpecialCharacters(password);
        score += checkUpperCaseLowerCase(password);

        return score;
    }

    private static int checkLength(int length) {
        if (length >= 8) {
            return 3;
        } else if (length >= 6) {
            return 2;
        } else {
            return 0;
        }
    }
    private static int checkSpecialCharacters(String password) {
        if (password.matches(".[!@#$%^&()].*")) {
            return 2;
        } else {
            return 0;
        }
    }
    private static int checkUpperCaseLowerCase(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
        }
        if (hasLowerCase && hasUpperCase) {
            return 3;
        } else {
            return 0;
        }
    }
    private static String classifyPasswordStrength(int totalScore) {
        if (totalScore >= 8) {
            return "Strong";
        } else if (totalScore >= 5) {
            return "Moderately Strong";
        } else {
            return "Weak";}}

    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int numberOfTerms = scanner.nextInt();

        System.out.println("Fibonacci sequence:");
        generateFibonacciSequence(numberOfTerms);}

    private static void generateFibonacciSequence(int numberOfTerms) {
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.print(firstTerm + " ");

        if (numberOfTerms > 1) {
            System.out.print(secondTerm + " ");
        }
        for (int i = 2; i < numberOfTerms; i++) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(nextTerm + " ");
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
}}









