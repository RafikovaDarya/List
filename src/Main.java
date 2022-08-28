import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static final List<String> products = new ArrayList<>();

    public static void main(String[] args) {
        boolean isWork = true;


        while (isWork) {
            System.out.println("Выберите операцию: " + " \n " +
                    "1. Добавить" + " \n " + "2. Показать" + " \n " + "3. Удалить" + " \n "
                    + "4. Поиск" + " \n " + "0. Выход");
            String input = scanner.nextLine();
            int numb;
            try {
                numb = Integer.parseInt(input);
            } catch (NumberFormatException n) {
                System.out.println("Указывайте только номер операции: " + n);
                continue;
            }

            switch (numb) {
                // добавить:
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    //ввод может быть любым
                    String product = scanner.nextLine();
                    products.add(product);
                    System.out.println("Итоговое количество продуктов " + products.size());
                    break;

                // показать:
                case 2:
                    System.out.println("Список покупок: ");
                    productList();

                    break;

                //удалить:
                case 3:
                    productList();
                    System.out.println("Какую покупку хотите удалить?" + " \n" +
                            "Введите номер или название.");
                    String line = scanner.nextLine();
                    int num;
                    try {
                        num = Integer.parseInt(line) - 1;
                    } catch (NumberFormatException e) {
                        num = products.indexOf(line);
                    }
                    products.remove(num);
                    break;

                //поиск по ключевым словам:
                case 4:
                    System.out.println("Введите текст для поиска");
                    String search = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено: ");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).toLowerCase().contains(search)) {
                            System.out.println(i + 1 + " " + products.get(i));
                        }
                    }
                    break;

                case 0:
                    isWork = false;
                    break;

                default:
                    System.out.println("Некорректно введен номер операции");
                    break;
            }
        }

    }

    public static void productList() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

}



