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
        System.out.println("Укажите, на скольких человек делим счет:");
        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
            while (k <= 1) {
                System.out.println("Количество человек должно быть больше 1, укажите другое значение:");
                if (scanner.hasNextInt()) {
                    k = scanner.nextInt();
                } else {
                    System.out.println("Укажите количество целой цифрой, без этого калькулятор не будет работать."); return;
                }
            }
            System.out.println("Замечательно! Количество человек - " + k +"\n\nТеперь укажи товары и их цены. Или напиши 'завершить' для рассчета.");
        } else {
            System.out.println("Укажите количество целой цифрой, без этого калькулятор не будет работать."); return;
        }


        /*
        класс - в итоге вынесла отдельно, тк должен быть класс кроме Main

        class Sku {
            String name; //название товара
            double price; //цена товара
            public static int goodsCount;

            //теперь делаем  конструктор для товара
            Sku(String nameSKU, double priceSKU){
                name = nameSKU;
                price = priceSKU;
                goodsCount++;
            }
        }
        */

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

            System.out.println("Цена, например, '150,10' - ");
                if (scanner.hasNextDouble()) {
                    pr = scanner.nextDouble();
                        while (pr < 0) {
                            System.out.println("!! Цена должна быть положительным числом. Укажите новую цену.");
                            pr = 0.0;
                            pr = scanner.nextDouble();
                        }
                    sum = sum + pr;
                    System.out.println(pr + " - ок, посчитали\n");
                 } else {
                    System.out.println("!! Укажите цену цифрами, для разделения используй запятую.\nНазвание товара укажи заново.\n");
                 }
            Sku sku = new Sku(text, pr);
        }

        if (list.equals("")) {
            System.out.println("Ничего не заказано"); return;
        }


            System.out.println("\n****\nСписок всех товаров:" + list.substring(0, list.length()) + "\n");
            System.out.println("Общая сумма: " + sum + "   Количество человек: " + k + "\n");
            Double pay = sum / k;
            String payment = String.format("%.2f", pay);
            String rub = "";

            switch (payment.substring(payment.length()-4,payment.length()-3)) {
                case "1":
                    rub = "рубль";
                    break;
                case "2":
                case "3":
                case "4":
                    rub = "рубля";
                    break;
                default:
                    rub = "рублей";
                    break;
            }


            System.out.println("Сумма на каждого: " + payment + " " + rub + "\n****");


    }
}