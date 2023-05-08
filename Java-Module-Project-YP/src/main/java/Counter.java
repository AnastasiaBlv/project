import static java.lang.String.*;

import java.util.Scanner;
public class Counter {
    String goods = "";
    int goodsCount = 0;
    double account;
    int userValueGoods;
    Scanner scanner;

    public void counter() {
        String priceInRubles;
        if (goodsCount == 0) {
            System.out.println("Товары не были добавлены");
            return;
        }
        double result = account / userValueGoods;
        int rublesBeginning = (int) Math.floor(account / userValueGoods);
        priceInRubles = switch (userValueGoods % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
        System.out.println("Добавленные товары:" + "\n" + goods);
        System.out.println(String.format("Сумма для каждого человека составляет  %.2f %s", result, priceInRubles));

    }

    public void addGoods() {
        String goodsName, goodsCost;

        System.out.println("Введите название товара");
        goodsName = scanner.nextLine();
        while (true){
            try {
                int idx;
                System.out.println("Введите цену за товар в формате \"рубли.копейки\"");
                goodsCost = scanner.next();

                idx = goodsCost.indexOf(".");
                if ((goodsCost.length() - idx - 3 <= 1 //проверяем кол-во знаков после точки, копейки могут быть в десятичных, отсюда и 1
                        || idx == -1) // или у нас целое значение
                ) // цена может быть только положительной
                {
                    double parsedCost = Double.parseDouble(goodsCost);
                    if (parsedCost > 0) {

                        goods += goodsName + "\n";
                        account += parsedCost;
                        goodsCount++;
                        break; //выходим как только получили корректное значение
                    }
                    else {
                        System.out.println("Введено отрицательное значение цены товара");
                    }
                }
                else{
                    System.out.println("Введено некоректное значение цены товара");
                }
            }
            catch (Exception e) {
                System.out.println("Введено некоректное значение цены товара");
                scanner.nextLine();
            }
        }

        System.out.println("Товар " + goodsName + " успешно добавлен в корзину");

    }
    public void getPeopleCount(){

        Scanner scanner = new Scanner(System.in);
        int getValue;
        while (true)
        {
            System.out.println("Введите количество человек");
            try {
                getValue = scanner.nextInt();
                if (getValue <= 1){

                    System.out.println("Введено некоректное значение, значение людей должно быть больше 1");

                }
                else {
                    userValueGoods = getValue;
                    break;
                }
            }
            catch(Exception e) {
                System.out.println("Введено некоректное значение, значение людей должно быть целым и больше 1");
                scanner.nextLine(); //высвобождает значение в считывании
            }
        }

    }
    public void getGoods(){

        getPeopleCount();

        Scanner scanner = new Scanner(System.in);

        String str;

        while(true){

            System.out.println("Введите любой символ, чтобы добавить товар");
            System.out.println("Или введите \"Заверишить\" чтобы закончить ввод товаров ");
            str = scanner.next();
            if (str.equalsIgnoreCase("завершить")){
                counter();
                break;
            }
            else addGoods();
        }
    }
    }


