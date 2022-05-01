import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка: ");
        int listSize = inputInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = inputInt();

        logger.log("Создаём и наполняем список");
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            source.add(random.nextInt(maxValue));
        }

        System.out.println("Вот случайный список: " + listToString(source));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int threshold = inputInt();
        Filter filter = new Filter(threshold);
        List<Integer> target = filter.filterOut(source);

        logger.log("Прошло фильтр " + target.size() + " элементов из " + source.size());
        logger.log("Выводим результат на экран");

        System.out.println("Отфильтрованный список: " + listToString(target));

        logger.log("Завершаем программу");
    }

    static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                int i = Integer.parseInt(input);
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число!");
            }
        }
    }

    static String listToString(List<?> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += " " + list.get(i);
        }
        return result;
    }

}