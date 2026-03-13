import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int count = 0;
        for (int i=0; i<input.length(); i++){
            if (input.charAt(i)=='a' || input.charAt(i)=='o' || input.charAt(i)=='u' ||
                    input.charAt(i)=='e' || input.charAt(i)=='i'){
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Deque<Character> word = new ArrayDeque<>();
        for (int i=0; i<input.length(); i++){
            word.addFirst(input.charAt(i));
        }

        String reversed = "";
        for(char c : word){
            reversed += c;
        }

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Deque<Character> word = new ArrayDeque<>();
        for(int i=0;i<input.length();i++){
            word.add(input.charAt(i));
        }

        boolean isPalindrome = true;

        while(word.size()>1){
            char first = word.removeFirst();
            char last = word.removeLast();
            if(first!=last){
                isPalindrome=false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String words[] = sentence.split(" ");
        ArrayList<String> word = new ArrayList<>();
        for(String w:words){
            word.add(w);
        }

        int wordCount = word.size();

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        ArrayList<Character> word = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!=' '){
                word.add(input.charAt(i));
            }
        }

        String noSpaces="";
        for(char c:word){
            noSpaces+=c;
        }

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String words[] = sentence.split(" ");
        ArrayList<String> word = new ArrayList<>();

        for(String w:words){
            String newWord = Character.toUpperCase(w.charAt(0)) + w.substring(1);
            word.add(newWord);
        }

        String result="";
        for(String w:word){
            result+=w+" ";
        }

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        HashMap<Character,Integer> words = new HashMap<>();

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            words.put(c,words.getOrDefault(c,0)+1);
        }

        char mostFrequent=' ';
        int max=0;

        for(char c:words.keySet()){
            if(words.get(c)>max){
                max=words.get(c);
                mostFrequent=c;
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        str1=str1.replace(" ","").toLowerCase();
        str2=str2.replace(" ","").toLowerCase();

        boolean areAnagrams=true;

        if(str1.length()!=str2.length()){
            areAnagrams=false;
        } else {

            HashMap<Character,Integer> words = new HashMap<>();

            for(int i=0;i<str1.length();i++){
                char c = str1.charAt(i);
                words.put(c,words.getOrDefault(c,0)+1);
            }

            for(int i=0;i<str2.length();i++){
                char c = str2.charAt(i);

                if(!words.containsKey(c)){
                    areAnagrams=false;
                    break;
                }

                words.put(c,words.get(c)-1);

                if(words.get(c)==0){
                    words.remove(c);
                }
            }

            if(!words.isEmpty()){
                areAnagrams=false;
            }
        }

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}
