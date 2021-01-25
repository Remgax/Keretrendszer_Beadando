package beadando.m5apwk.model;

public class Tantargyak {
    private String tantargy;
    private String osztalyzat;
    private int id;

    public Tantargyak() {
    }

    public Tantargyak(String tantargy, String osztalyzat) {
        this.tantargy = tantargy;
        this.osztalyzat = osztalyzat;
    }

    public String getTantargy() {
        return tantargy;
    }

    public void setTantargy(String tantargy) {
        this.tantargy = tantargy;
    }

    public String getOsztalyzat() {
        return osztalyzat;
    }

    public void setOsztalyzat(String osztalyzat) {
        this.osztalyzat = osztalyzat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tantargyak{" +
                "tantargy='" + tantargy + '\'' +
                ", osztalyzat='" + osztalyzat + '\'' +
                ", id=" + id +
                '}';
    }
}