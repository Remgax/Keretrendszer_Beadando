package uni.eszterhazy.m5apwk.model;
import org.apache.log4j.Logger;
import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.m5apwk.exceptions.Negativ;
import uni.eszterhazy.m5apwk.exceptions.NevNemLehetUres;
import uni.eszterhazy.m5apwk.exceptions.RosszGyartasiDatum;

import java.time.LocalDate;
import java.util.UUID;

public class Robot {
    private String nev;
    private String id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate gyartasIdeje;
    private int magassag;
    private RobotTipus robotTipus;
    private int kilogramm;
    Logger logger = Logger.getLogger(this.getClass());



    public Robot() {
        this.id = UUID.randomUUID().toString();
        logger.info("Uj robot lett hozzáadva: "+ this.id);
    }
    public RobotTipus getRobotTipus(){
        return robotTipus;
    }
    public void setRobotTipus(RobotTipus robotTipus){
        this.robotTipus = robotTipus;
    }
    public int getMagassag() {
        return magassag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(@NotNull String nev) throws NevNemLehetUres {
        if(nev.length()==0)
        {
            throw new NevNemLehetUres();
        }
        this.nev = nev;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getGyartasIdeje() {
        return gyartasIdeje;
    }

    public void setGyartasIdeje(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate gyartasIdeje) throws RosszGyartasiDatum {
        if(gyartasIdeje.isAfter(LocalDate.now())){
            throw new RosszGyartasiDatum("Robot még nem készült el");
        }
        if(gyartasIdeje.isBefore(LocalDate.now().minusYears(561)))
        {
            throw new RosszGyartasiDatum("561 évnél idősebb robot nem létezik: "+ gyartasIdeje);
        }
        this.gyartasIdeje = gyartasIdeje;
    }




    public void setMagassag(int magassag) throws Negativ {
        if (magassag < 0){
            throw new Negativ(magassag);
        }
        this.magassag = magassag;
    }

    public int getKilogramm() {
        return kilogramm;
    }


    public void setKilogramm(int kilogramm) throws Negativ {
        if (kilogramm<0){
            throw new Negativ(kilogramm);
        }
        this.kilogramm = kilogramm;

    }

    @Override
    public String toString() {
        return "Robot{" +
                "nev='" + nev + '\'' +
                ", id='" + id + '\'' +
                ", robottipus='" + robotTipus + '\'' +
                ", gyartasIdeje=" + gyartasIdeje +
                ", magassag=" + magassag +
                ", kilogramm=" + kilogramm +
                '}';
    }
}
