package ch.bbw.formelrad;

public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;
    private boolean isPCaclulated = false;
    private boolean isUCaclulated = false;
    private boolean isICaclulated = false;
    private boolean isRCaclulated = false;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */
        if (leistung == 0 && spannung == 0) {
            leistung = pFromRandI(widerstand, strom);
            spannung = uFromRandI(widerstand, strom);
            isPCaclulated = true;
            isUCaclulated = true;
        } else if (leistung == 0 && strom == 0) {
            leistung = pFromUandR(spannung, widerstand);
            strom = iFromUandR(spannung, widerstand);
            isPCaclulated = true;
            isICaclulated = true;
        } else if (leistung == 0 && widerstand == 0) {
            leistung = pFromUandI(spannung, strom);
            widerstand = rFromUandI(spannung, strom);
            isPCaclulated = true;
            isRCaclulated = true;
        } else if (spannung == 0 && strom == 0) {
            spannung = uFromPandR(leistung, widerstand);
            strom = iFromPandR(leistung, widerstand);
            isUCaclulated = true;
            isICaclulated = true;
        } else if (spannung == 0 && widerstand == 0) {
            spannung = uFromPandI(leistung, strom);
            widerstand = rFromPandI(leistung, strom);
            isUCaclulated = true;
            isRCaclulated = true;
        } else if (strom == 0 && widerstand == 0) {
            strom = iFromPandU(leistung, spannung);
            widerstand = rFromUandP(spannung, leistung);
            isICaclulated = true;
            isRCaclulated = true;
        } else if (leistung != 0 && spannung != 0 && strom != 0) {
            System.out.println("Es wurden mehr als zwei Grössen angegeben");
            leistung = 0;
            spannung = 0;
            strom = 0;
            widerstand = 0;
        } else if (leistung != 0 && spannung != 0 && widerstand != 0) {
            System.out.println("Es wurden mehr als zwei Grössen angegeben");
            leistung = 0;
            spannung = 0;
            strom = 0;
            widerstand = 0;
        } else if (leistung != 0 && strom != 0 && widerstand != 0) {
            System.out.println("Es wurden mehr als zwei Grössen angegeben");
            leistung = 0;
            spannung = 0;
            strom = 0;
            widerstand = 0;
        } else if (spannung != 0 && strom != 0 && widerstand != 0) {
            System.out.println("Es wurden mehr als zwei Grössen angegeben");
            leistung = 0;
            spannung = 0;
            strom = 0;
            widerstand = 0;
        }
    }

    /* Hier die Methoden mit den Formlen hinzuf�gen
     */

    //P Methods
    private double pFromUandI(double u, double i) {
        System.out.println("P (" + u * i + ") is calculated from U (" + u + ") and I (" + i + ")");
        return u * i;
    }

    private double pFromUandR(double u, double r) {
        double temp = u * u;
        System.out.println("P (" + temp / r + ") is calculated from U (" + u + ") and R(" + r + ")");
        return temp / r;
    }

    private double pFromRandI(double r, double i) {
        double temp = i * i;
        System.out.println("P (" + temp * r + ") is calculated from R (" + r + ") and I (" + i + ")");
        return r * temp;
    }

    //U Methods
    private double uFromRandI(double r, double i) {
        System.out.println("U (" + (r + i) + ") is calculated from R (" + r + ") and I (" + i + ")");
        return r + i;
    }

    private double uFromPandI(double p, double i) {
        System.out.println("U is calculated from P and I");
        return p / i;
    }

    private double uFromPandR(double p, double r) {
        double temp = p * r;
        System.out.println("U is calculated from P and R");
        return Math.sqrt(temp);
    }

    //I Methods
    private double iFromUandR(double u, double r) {
        System.out.println("I is calculated from U and R");
        return u / r;
    }

    private double iFromPandU(double p, double u) {
        System.out.println("I is calculated from P and U");
        return p / u;
    }

    private double iFromPandR(double p, double r) {
        double temp = p / r;
        System.out.println("I is calculated from P and R");
        return Math.sqrt(temp);
    }

    //R Methods
    private double rFromUandI(double u, double i) {
        System.out.println("R is calculated from U and I");
        return u / i;
    }

    private double rFromUandP(double u, double p) {
        double temp = u * u;
        System.out.println("R is calculated from U and P");
        return temp / p;
    }

    private double rFromPandI(double p, double i) {
        double temp = i * i;
        System.out.println("R is calculated from P and I");
        return p / temp;
    }

    public boolean isPCaclulated() {
        return isPCaclulated;
    }

    public boolean isUCaclulated() {
        return isUCaclulated;
    }

    public boolean isICaclulated() {
        return isICaclulated;
    }

    public boolean isRCaclulated() {
        return isRCaclulated;
    }
}
