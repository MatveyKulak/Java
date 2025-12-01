package Laba8;

import java.util.*;

public class ContentAnalyzer {
    public static void contentAnalysis() {
        String text = """
                У лукоморья дуб зелёный;
                Златая цепь на дубе том:
                И днём и ночью кот учёный
                Всё ходит по цепи кругом.
                Идёт направо — песнь заводит,
                Налево — сказку говорит;
                Там чудеса: там леший бродит,
                Русалка на ветвях сидит,
                Там на неведомых дорожках
                Следы невиданных зверей;
                Избушка там на курьих ножках
                Стоит без окон, без дверей.
                Там лес и дол видений полны;
                Там о заре прихлынут волны
                На брег песчаный и пустой.
                """;

        System.out.println("Исходный текст:");
        System.out.println(text);

        List<Character> vowels = Arrays.asList('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я');
        List<Character> consonants = Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');

        String[] sentences = text.split("[.!?]");

        for (int i = 0; i < sentences.length - 1; i++) {
            String sentence = sentences[i];
            System.out.println("Предложение " + (i + 1) + ":");
            System.out.println(sentence);

            int vowelCount = 0;
            int consonantCount = 0;

            for (char c : sentences[i].toLowerCase().toCharArray()) {
                if (vowels.contains(c)) {
                    vowelCount++;
                } else if (consonants.contains(c)) {
                    consonantCount++;
                }
            }

            System.out.println("Анализ по предложению:");
            System.out.println("Гласных букв: " + vowelCount);
            System.out.println("Согласных букв: " + consonantCount);

            if (vowelCount > consonantCount) {
                System.out.println("Гласных букв больше, чем согласных");
            } else if (consonantCount > vowelCount) {
                System.out.println("Согласных букв больше, чем гласных");
            } else {
                System.out.println("Количество гласных и согласных букв одинаково");
            }
        }
    }
}
