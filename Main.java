
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        Scanner reader = new Scanner(file);
        String input = reader.nextLine();

        String[] words = input.split(" ");
        String[] sentences = input.split("[!\\.?]");
        int characters = input.replace(" ", "").length();
        int syllables = 0;
        int poly = 0;

        for (String s : words) {
            if (countSyllables(s) > 2) {
                poly++;
             }
            syllables += countSyllables(s);
        }

        System.out.println("The text is: ");
        System.out.println(input);
        System.out.println();

        System.out.println("Words: " + words.length);
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + poly);

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        Scanner userInput = new Scanner(System.in);
        String selection = userInput.nextLine();

        if (selection.equals("ARI")) {
            ari(words, sentences, characters);
        }
        if (selection.equals("FK")) {
            fk(words, sentences,syllables);
        }
        if (selection.equals("SMOG")) {
            smog(sentences, poly);
        }
        if (selection.equals("CL")) {
            cl(words, sentences, characters);
        }
        if (selection.equals("all")) {
            ArrayList<Integer> averages = new ArrayList<Integer>();

            averages.add(ari(words, sentences, characters));
            averages.add(fk(words, sentences,syllables));
            averages.add(smog(sentences, poly));
            averages.add(cl(words, sentences, characters));

            double total = 0;
            for (int output : averages) {
                total+= output;
            }
            System.out.println();
            System.out.println("This text should be understood in average by " + total/4  + " year olds.");
        }
    }

    private static int countSyllables(String input) {
        int vowels = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {
                    vowels++;
                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
            if (input.charAt(i) == 'e') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {

                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
            if (input.charAt(i) == 'i') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {
                    vowels++;
                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
            if (input.charAt(i) == 'o') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {
                    vowels++;
                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
            if (input.charAt(i) == 'u') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {
                    vowels++;
                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
            if (input.charAt(i) == 'y') {
                //checks if last letter in the word
                if (input.charAt(i) == input.charAt(input.length() - 1)) {
                    vowels++;
                } else {
                    //checks if double vowel
                    String after = String.valueOf(input.charAt(i + 1));
                    if (after.matches("[aeiouyAEIOY]")) {

                    } else {
                        vowels++;
                    }
                }
            }
        }
        if (vowels == 0) {
            vowels = 1;
        }
        return vowels;
    }

    public static int ari(String[] words, String[] sentences, int characters) {

        double decimalScore = 4.71 * characters / words.length + 0.5 * words.length / sentences.length - 21.43;

        int score = (int) Math.floor(decimalScore);

        int age = 0;

        if (score == 1) {
            age = 6;
        }
        if (score == 2) {
            age = 7;
        }
        if (score == 3) {
            age = 9;
        }
        if (score == 4) {
            age = 10;
        }
        if (score == 5) {
            age = 11;
        }
        if (score == 6) {
            age = 12;
        }
        if (score == 7) {
            age = 13;
        }
        if (score == 8) {
            age = 14;
        }
        if (score == 9) {
            age = 15;
        }
        if (score == 10) {
            age = 16;
        }
        if (score == 11) {
            age = 17;
        }
        if (score == 12) {
            age = 18;
        }
        if (score == 13) {
            age = 24;
        }
        if (score >= 14) {
            age = 25;
        }

        System.out.println("Automated Readability Index: " + String.format("%.2f", decimalScore) +
                " (about " + age + " year olds).");

        return age;
    }

    public static int fk(String[] words, String[] sentences, int syllables) {
        double decimalScore = (.39 * words.length/sentences.length) + (11.8 * syllables / words.length) - 15.59;

        int score = (int) Math.floor(decimalScore);

        int age = 0;

        if (score == 1) {
            age = 6;
        }
        if (score == 2) {
            age = 7;
        }
        if (score == 3) {
            age = 9;
        }
        if (score == 4) {
            age = 10;
        }
        if (score == 5) {
            age = 11;
        }
        if (score == 6) {
            age = 12;
        }
        if (score == 7) {
            age = 13;
        }
        if (score == 8) {
            age = 14;
        }
        if (score == 9) {
            age = 15;
        }
        if (score == 10) {
            age = 16;
        }
        if (score == 11) {
            age = 17;
        }
        if (score == 12) {
            age = 18;
        }
        if (score == 13) {
            age = 24;
        }
        if (score >= 14) {
            age = 25;
        }

        System.out.println("Flesch–Kincaid readability tests: " + String.format("%.2f", decimalScore) +
                " (about " + age + " year olds).");
        return age;
    }

    public static int smog(String[] sentences, int poly){

        double decimalScore = (1.043) * Math.sqrt(poly * (30/sentences.length)) + 3.1291;

        int score = (int) Math.floor(decimalScore);

        int age = 0;

        if (score == 1) {
            age = 6;
        }
        if (score == 2) {
            age = 7;
        }
        if (score == 3) {
            age = 9;
        }
        if (score == 4) {
            age = 10;
        }
        if (score == 5) {
            age = 11;
        }
        if (score == 6) {
            age = 12;
        }
        if (score == 7) {
            age = 13;
        }
        if (score == 8) {
            age = 14;
        }
        if (score == 9) {
            age = 15;
        }
        if (score == 10) {
            age = 16;
        }
        if (score == 11) {
            age = 17;
        }
        if (score == 12) {
            age = 18;
        }
        if (score == 13) {
            age = 24;
        }
        if (score >= 14) {
            age = 25;
        }

        System.out.println("Simple Measure of Gobbledygook: " + String.format("%.2f", decimalScore) +
                " (about " + age + " year olds).");
        return age;
    }

    public static int cl(String[] words, String[] sentences, int characters){
        double s = ((double) sentences.length / (double) words.length) * 100;
        double l = ((double) characters / (double) words.length) * 100;

        double decimalScore = (0.0588 * l) - (0.296 * s) - 15.8;

        int score = (int) Math.floor(decimalScore);

        int age = 0;

        if (score == 1) {
            age = 6;
        }
        if (score == 2) {
            age = 7;
        }
        if (score == 3) {
            age = 9;
        }
        if (score == 4) {
            age = 10;
        }
        if (score == 5) {
            age = 11;
        }
        if (score == 6) {
            age = 12;
        }
        if (score == 7) {
            age = 13;
        }
        if (score == 8) {
            age = 14;
        }
        if (score == 9) {
            age = 15;
        }
        if (score == 10) {
            age = 16;
        }
        if (score == 11) {
            age = 17;
        }
        if (score == 12) {
            age = 18;
        }
        if (score == 13) {
            age = 24;
        }
        if (score >= 14) {
            age = 25;
        }

        System.out.println("Coleman–Liau index: " + String.format("%.2f", decimalScore) +
                " (about " + age + " year olds).");
        return age;
    }
}
