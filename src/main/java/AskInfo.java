import java.util.Scanner;

public class AskInfo {
    int peopleAmount;
    double checkCount;
    StringBuilder productList;

    AskInfo() {
        productList = new StringBuilder();
    }

    void askPeopleAmount() {
        Scanner scanner = new Scanner(System.in);
        boolean exceptionHappened;
        while (true) {
            exceptionHappened = false;
            System.out.println("Введите количество гостей:");
            try {
                peopleAmount = scanner.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка ввода, попробуйте еще раз.");
                scanner.nextLine();
                exceptionHappened = true;
            }

            if (!exceptionHappened && peopleAmount <= 1) {
                System.out.println("Ошибка ввода количества гостей. Количество гостей должно быть больше 1.");
            } else if (!exceptionHappened){
                break;
            }
        }
    }

    void addProductsNameAndPrice() {
        String productName;
        double price = 0;
        boolean exceptionHappened;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название товара:\nЕсли хотите вывести счет введите: Завершить.");
            productName = scanner.next();

            if (!productName.equalsIgnoreCase("Завершить")) {
                productList.append(productName).append("\n");
            }
            else {
                break;
            }

            while (true) {
                exceptionHappened = false;
                System.out.println("Введите цену товара:");
                try {
                    price = scanner.nextDouble();
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Ошибка ввода. Возможно неверный формат ввода. Повторите ввод.");
                    scanner.nextLine();
                    exceptionHappened = true;
                }
                if (price >= 0 && !exceptionHappened){
                    checkCount += price;
                    break;
                }
                else if (!exceptionHappened) {
                    System.out.println("Ошибка ввода. Цена не может быть меньше нуля. Повторите ввод.");
                }
            }
        }
    }
}
