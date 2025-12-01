package Laba8;

import java.util.*;
import java.util.regex.*;

public class WordProcessor {
    public static void wordProcessing() {
        String sequence = "camel,bear,cobra,bison,cow,yak,horse,rat,hare,elk,wolf,boar,goat,emu,pig.";

        System.out.println("Исходная последовательность:");
        System.out.println(sequence);

//        StringBuilder reversedSequence = new StringBuilder();

        Pattern pattern = Pattern.compile("[a-z]{1,5}");
        Matcher matcher = pattern.matcher(sequence);

        StringBuilder reversedSequence = new StringBuilder();
        boolean word = false;

        while (matcher.find()) {
            if (word) {
                reversedSequence.insert(0, ",");
            } else {
                word = true;
            }
            reversedSequence.insert(0, matcher.group());
        }
        reversedSequence.append(".");

        System.out.println("Последовательность в обратном порядке:");
        System.out.println(reversedSequence);
    }
}
