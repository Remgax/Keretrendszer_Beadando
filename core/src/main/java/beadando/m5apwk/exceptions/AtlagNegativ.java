package beadando.m5apwk.exceptions;

public class AtlagNegativ extends Exception {
    public AtlagNegativ(double atlag) {
        super(String.valueOf(atlag));
    }
}
