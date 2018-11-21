package ch.bbw.formelrad;

public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;

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
    }

    /* Hier die Methoden mit den Formlen hinzuf�gen
     */

    //P Methods
    private double pFromUandI(double u, double i) {
        return u * i;
    }

    private double pFromUandR(double u, double r) {
        double temp = u * u;
        return temp / r;
    }

    private double pFromRandI(double r, double i) {
        double temp = i * i;
        return r * temp;
    }

    //U Methods
    private double uFromRandI(double r, double i) {
        return r + i;
    }

    private double uFromPandI(double p, double i) {
        return p / i;
    }

    private double uFromPandR(double p, double r) {
        double temp = p * r;
        return Math.sqrt(temp);
    }

    //R Methods
    private double rFromUandI(double u, double i) {
        return u / i;
    }
}
