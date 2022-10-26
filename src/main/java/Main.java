public class Main {

    public static void main(String[] args) {
        // Собираю вводные данные
        AskInfo askPeople = new AskInfo();
        askPeople.askPeopleAmount();
        askPeople.addProductsNameAndPrice();

        //Произвожу вычисления
        Calculator calculator = new Calculator(askPeople.checkCount, askPeople.peopleAmount);
        double calculatedCheck = calculator.division();

        //Вывожу список товаров
        ShowProductList showProductList = new ShowProductList(askPeople.productList);
        showProductList.printProductList();

        //Форматирую окончание слова рубль для сообщения
        FormatToRubles formatToRubles = new FormatToRubles(calculatedCheck);
        String checkMessage = formatToRubles.formatRubbles();

        //Вывожу сколько должен заплатить каждый гость
        ShowFinalCheck showFinalCheck = new ShowFinalCheck(checkMessage);
        showFinalCheck.printFinalCheck();
    }
}
