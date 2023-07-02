public class Rubl {
    String sumStr;
    Double sumDouble;
    String rubSogl;

    Rubl(String sumStr, Double sumDouble) {
        this.sumStr = sumStr;
        this.sumDouble = sumDouble;
    }

    public static void rublCorrect(String sumStr, Double sumDouble, String rubSogl) {
        if (sumDouble <= 10) {
            //System.out.println("меньше 10");
            switch (sumStr.substring(sumStr.length() - 4, sumStr.length() - 3)) {
                case "1":
                    rubSogl = "рубль";
                    break;
                case "2":
                case "3":
                case "4":
                    rubSogl = "рубля";
                    break;
                default:
                    rubSogl = "рублей";
                    break;
            }
            System.out.println(sumStr + " " + rubSogl);
        } else if (sumDouble > 10) {
            //System.out.println("больше 10");
            if (sumStr.substring(sumStr.length() - 5, sumStr.length() - 4).equals("1")) {
                rubSogl = "рублей";
                System.out.println(sumStr + " " + rubSogl);
                return;
            }
            switch (sumStr.substring(sumStr.length() - 4, sumStr.length() - 3)) {
                case "1":
                    rubSogl = "рубль";
                    break;
                case "2":
                case "3":
                case "4":
                    rubSogl = "рубля";
                    break;
                default:
                    rubSogl = "рублей";
                    break;
            }
            System.out.println(sumStr + " " + rubSogl);
        }
    }
}


