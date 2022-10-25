public class ShowFinalCheck {
   String priceMessage;
   double finalCheck;

    ShowFinalCheck(String priceMessage, double finalCheck) {
        this.priceMessage = priceMessage;
        this.finalCheck = finalCheck;
    }

    void PrintFinalCheck() {
        System.out.printf((priceMessage) + "%n", finalCheck);
    }

}
