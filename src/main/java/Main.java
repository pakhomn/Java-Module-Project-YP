/*
«Калькулятор счёта» — консольное приложение,
которое будет задавать вопросы в консоли,
считывать пользовательский ввод
и в результате показывать
список товаров и сумму для каждого из друзей.
*/

import java.util.Scanner;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        После запуска программа должна спрашивать у пользователя,
        на скольких человек необходимо разделить  счёт.
         */

        int k;
        do {
            System.out.println("Укажите, на скольких человек делим счет.\nВыберете значение больше 1:");
            while (!scanner.hasNextInt()) {
                System.out.println("Напишите значение целым числом, не используйте буквы.");
                scanner.next();
            }
            k = scanner.nextInt();
        } while (k <= 1);
        System.out.println("Замечательно! Количество человек - " + k +"\n\nТеперь укажи товары и их цены. Или напиши 'завершить' для рассчета.");


        String end = "завершить";
        String text = "";
        Double pr = 0.0;
        String list = "";
        Double sum = 0.0;


        while (!text.equalsIgnoreCase(end)) {
            System.out.println("Товар, например, 'Тыквенный раф' -");
            scanner.nextLine();
            text = scanner.nextLine();
                if (text.equalsIgnoreCase(end)) {break;}
            list = list + "\n" + text;
            System.out.println(text + " - записали\n");

            do {
                System.out.println("Укажите цену (больше нуля). Например, '150,10' - ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Не используйте буквы, указывайте запятую для нецелых чисел.");
                    scanner.next();
                }
                pr = scanner.nextDouble();
            } while (pr < 0.0);
            System.out.println(pr + " - ок, посчитали\n");
            sum += pr;

            Sku sku = new Sku(text, pr);
        }

        if (list.isEmpty()) {
            System.out.println("Ничего не заказано"); return;
        }


            System.out.println("\n*****************\nСписок всех товаров:" + list.substring(0, list.length()) + "\n\nОбщая сумма: " + sum + "   Количество человек: " + k + "\n");
            Double pay = sum / k;
            String payment = String.format("%.2f", pay);
            String rub = "";

            System.out.println("*****************\nСумма на каждого: ");
            Rubl r = new Rubl(payment, pay);
            r.rublCorrect(payment, pay, rub);
            System.out.println("*****************");


    }
}