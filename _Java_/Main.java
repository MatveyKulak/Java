import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encrypted = sc.nextLine();
        String original = sc.nextLine();

        System.out.println(isPossible(original, encrypted) ? "YES" : "NO");
    }

    static boolean isPossible(String original, String encrypted) {
        if (original.length() != encrypted.length()) {
            return false;
        }

        HashMap<Character, Character> charMap = new HashMap<>();
        HashSet<Character> mappedValues = new HashSet<>();

        for (int i = 0; i < original.length(); i++) {
            char origChar = original.charAt(i);
            char encChar = encrypted.charAt(i);

            if (charMap.containsKey(origChar)) {
                if (charMap.get(origChar) != encChar) {
                    return false;
                }
            } else {
                if (mappedValues.contains(encChar)) {
                    return false;
                }
                charMap.put(origChar, encChar);
                mappedValues.add(encChar);
            }
        }

        return true;
    }
}