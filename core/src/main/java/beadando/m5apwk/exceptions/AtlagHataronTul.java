package beadando.m5apwk.exceptions;

public class AtlagHataronTul extends Exception {
    public AtlagHataronTul(double atlag) {
        super(String.valueOf(atlag));
    }
}
