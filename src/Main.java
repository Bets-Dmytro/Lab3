import java.util.Arrays;
import java.util.Scanner;

/*
C3 = 2 | String
C17 = 10 | З кожного речення заданого тексту видалити підрядок
найбільшої довжини, що починається та закінчується заданими літерами.
*/

public class Main {
    public static void main(String[] args) {
        String text;
        String[] substr;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text");
        text = scan.nextLine();

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter two letters");

        String start_input = scan2.next();
        char start = start_input.charAt(0);

        String end_input = scan2.next();
        char end = end_input.charAt(0);

        substr = text.split(" ");

        for (int i = 0; i < substr.length; i ++) {
            int id_start = -1, id_end = -1;

            for (int j = 0; j < substr[i].length(); j++) {
                if (substr[i].charAt(j) == end)
                    id_end = j;
            }
            for (int j = 0; j < substr[i].length(); j++) {
                if (substr[i].charAt(j) == start && id_start < 0 && j < id_end)
                    id_start = j;
            }

            if (id_end < 0 || id_start < 0)
                continue;

            substr[i] = substr[i].substring(0, id_start) + substr[i].substring(id_end + 1);
        }
        for (int i = 0; i < substr.length; i ++)
            System.out.print(substr[i] + " ");
    }
}