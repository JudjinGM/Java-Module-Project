import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Собираю вводные данные
        AskPeople askPeople = new AskPeople();
        askPeople.askPeopleAmount();
        askPeople.addProductsNameAndPrice();

        //Произвожу вычисления
        Calculator calculator = new Calculator(askPeople.peopleAmount, askPeople.checkCount);
        calculator.countFinalCheck();

        //Вывожу результаты
        ShowProductList showProductList = new ShowProductList(askPeople.productList);
        showProductList.printProductList();

        ShowFinalCheck showFinalCheck = new ShowFinalCheck(calculator.finalCheck);
        showFinalCheck.PrintFinalCheck();
    }

    static class AskPeople {
        int peopleAmount;
        double checkCount;
        StringBuilder productList;

        AskPeople() {
            productList = new StringBuilder();
        }

        void askPeopleAmount() {
            Scanner scanner = new Scanner(System.in);
            boolean exceptionHappened;
            while (true) {
                exceptionHappened = false;
                System.out.println("Введите количество гостей");
                try {
                peopleAmount = scanner.nextInt();
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Ошибка ввода, попробуйте еще раз");
                    scanner.nextLine();
                    exceptionHappened = true;
                }

                if (!exceptionHappened && peopleAmount <= 1) {
                    System.out.println("Ошибка ввода количества гостей.\nКоличество гостей должно быть больше 1.");
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
                System.out.println("Введите название товара");
                productName = scanner.next();

                if (!productName.equalsIgnoreCase("Завершить")) {
                    productList.append(productName).append("\n");
                }
                    else {
                        break;
                    }

                while (true) {
                    exceptionHappened = false;
                    System.out.println("Введите цену товара");
                    try {
                        price = scanner.nextDouble();
                    }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Ошибка ввода, попробуйте еще раз");
                        scanner.nextLine();
                        exceptionHappened = true;
                    }
                    if (price >= 0 && !exceptionHappened){
                        checkCount = checkCount + price;
                        break;
                    }
                }
                }
            }
        }

    static class Calculator {
        int peopleAmount;
        double checkCount;
        double finalCheck;

        Calculator(int peopleAmount, double checkCount) {
            this.peopleAmount = peopleAmount;
            this.checkCount = checkCount;
        }

        void countFinalCheck() {
            finalCheck = checkCount / peopleAmount;
        }
    }

    static class ShowProductList {
        StringBuilder productList;

        ShowProductList(StringBuilder productList) {
            this.productList = productList;
        }

        void printProductList(){
            System.out.println(productList);
        }

    }

    static class ShowFinalCheck {
        double finalCheck;

        ShowFinalCheck(double finalCheck) {
            this.finalCheck = finalCheck;
        }

        void PrintFinalCheck() {
            int rubleOrRubles;

            rubleOrRubles = (int) Math.floor(finalCheck);

            if (rubleOrRubles <= 1) {
                String priceMessage = "С человека по %.2f рубль";
                System.out.printf((priceMessage) + "%n", finalCheck);
            } else if (rubleOrRubles < 9) {
                String priceMessage = "С человека по %.2f рубля";
                System.out.printf((priceMessage) + "%n", finalCheck);
            } else if (rubleOrRubles >= 10) {
                String priceMessage = "С человека по %.2f рублей";
                System.out.printf((priceMessage) + "%n", finalCheck);
            }
        }

    }
}
