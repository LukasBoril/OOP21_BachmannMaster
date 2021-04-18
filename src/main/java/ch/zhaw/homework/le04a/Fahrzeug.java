package ch.zhaw.homework.le04a;

import java.io.Serializable;

public class Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;
    private String pSchild;

    public Fahrzeug(String pSchild) { setPschild(pSchild);}

    public void setPschild(String pSchild) {
        this.pSchild = pSchild;
    }

    public String getPschild() {
        return pSchild;
    }

}
