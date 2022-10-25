public class FormatToRubles {
    double rubbles;

    FormatToRubles(double rubbles) {
        this.rubbles = rubbles;
    }

    String formatRubbles() {
        int rubleOrRubles;
        rubleOrRubles = (int) Math.floor(rubbles);
        String checkMessage = null;

        if (rubleOrRubles <= 1) {
            checkMessage = "С человека по %.2f рубль";
        } else if (rubleOrRubles < 9) {
            checkMessage = "С человека по %.2f рубля";
        } else if (rubleOrRubles >= 10) {
            checkMessage = "С человека по %.2f рублей";
        }
        return checkMessage;
    }
}



