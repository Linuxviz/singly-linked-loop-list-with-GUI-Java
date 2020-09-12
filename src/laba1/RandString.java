package laba1;

import java.util.Random;

/**
 * RU: Класс отвечающий за генерацию случайной последовательности символов по определенному правилу
 * EN: Class responsible for generating a random sequence of characters according to a specific rule
 */
public class RandString {

    private static final String CHAR_LIST = "qwertyuiop0123456789";
    private static final Random rnd = new Random();

    /**
     * RU: Метод генерирующий случайную последовательность символов
     * EN: Method that generates a random sequence of characters
     * INPUT: ()
     * RETURN: String
     */
    public static String GenerateRandomString() {
        StringBuilder randStr = new StringBuilder();
        int keyNumber = 7;
        for (int j = 0; j < keyNumber; j++) {
            int number = rnd.nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
}