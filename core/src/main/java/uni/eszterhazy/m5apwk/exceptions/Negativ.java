package uni.eszterhazy.m5apwk.exceptions;

public class Negativ extends Throwable {
    public Negativ(int value) {
        super(String.valueOf(value));
    }
}
