package service;

import java.util.Set;

/**
 * Утилитарный класс для валидации строк.
 * <p>Предоставляет методы для проверки различных форматов строк:
 * <ul>
 *   <li>Проверка на целые положительные числа</li>
 *   <li>Проверка на числа (целые или дробные, положительные или отрицательные)</li>
 *   <li>Проверка на целые числа (положительные или отрицательные)</li>
 *   <li>Проверка на положительные целые числа</li>
 *   <li>Проверка на русские согласные буквы</li>
 * </ul>
 * </p>
 *
 * @author Student
 * @version 1.0
 * @since 2024
 */
public class Valid {

    /**
     * Проверяет, что строка состоит только из цифр (положительное целое число).
     * <p>Условия проверки:
     * <ul>
     *   <li>Строка не должна быть {@code null} или пустой</li>
     *   <li>Все символы должны быть цифрами от '0' до '9'</li>
     *   <li>Не допускаются отрицательные числа, десятичные точки или другие символы</li>
     * </ul>
     * </p>
     *
     * @param str строка для проверки
     * @return {@code true} если строка представляет положительное целое число,
     *         {@code false} в противном случае
     */
    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, что строка является числом (целым или дробным, отрицательным или положительным).
     * <p>Формат чисел:
     * <ul>
     *   <li>Может начинаться с минуса для отрицательных чисел</li>
     *   <li>Может содержать одну десятичную точку</li>
     *   <li>Должна содержать хотя бы одну цифру</li>
     *   <li>Не допускаются пробелы, другие символы или несколько точек</li>
     * </ul>
     * </p>
     *
     * @param str строка для проверки
     * @return {@code true} если строка представляет число,
     *         {@code false} в противном случае
     */
    public boolean isAnyNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        boolean hasDecimalPoint = false;
        boolean hasDigit = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && c == '-') {
                continue;
            }
            else if (c == '.' && !hasDecimalPoint) {
                hasDecimalPoint = true;
            }
            else if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
            else {
                return false;
            }
        }

        return hasDigit;
    }

    /**
     * Проверяет, что строка является целым числом (отрицательным или положительным).
     * <p>Дополнительные ограничения:
     * <ul>
     *   <li>Не допускаются ведущие нули (кроме числа "0")</li>
     *   <li>Должна содержать хотя бы одну цифру</li>
     * </ul>
     * </p>
     *
     * @param str строка для проверки
     * @return {@code true} если строка представляет целое число,
     *         {@code false} в противном случае
     */
    public boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int startIndex = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1){
                return false;
            }
            startIndex = 1;
        }

        // Проверка на ведущий ноль (кроме числа 0)
        if (str.charAt(startIndex) == '0' && str.length() > startIndex + 1) {
            return false;
        }

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, что строка является положительным целым числом.
     * <p>Использует метод {@link #isInteger(String)} и дополнительно проверяет,
     * что строка не начинается с минуса.</p>
     *
     * @param str строка для проверки
     * @return {@code true} если строка представляет положительное целое число,
     *         {@code false} в противном случае
     *
     * @see #isInteger(String)
     */
    public boolean isPositiveInteger(String str) {
        return isInteger(str) && (str.charAt(0) != '-');
    }

    /** Множество русских согласных букв (строчных и заглавных). */
    private static final Set<Character> RUSSIAN_CONSONANTS = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м',
            'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М',
            'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'
    );

    /**
     * Проверяет, является ли символ русской согласной буквой.
     * <p>Поддерживает как строчные, так и заглавные буквы.</p>
     *
     * @param c символ для проверки
     * @return {@code true} если символ является русской согласной буквой,
     *         {@code false} в противном случае
     */
    public boolean isRussianConsonant(char c) {
        return RUSSIAN_CONSONANTS.contains(c);
    }

    /**
     * Проверяет, является ли строка русской согласной буквой.
     * <p>Строка должна состоять ровно из одного символа, который является
     * русской согласной буквой.</p>
     *
     * @param str строка для проверки
     * @return {@code true} если строка состоит из одной русской согласной буквы,
     *         {@code false} в противном случае
     *
     * @see #isRussianConsonant(char)
     */
    public boolean isRussianConsonant(String str) {
        return str != null && str.length() == 1 && isRussianConsonant(str.charAt(0));
    }
}
