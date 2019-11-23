package cn.edu.aynu.beans;

import java.io.Serializable;

public class Student implements Serializable {
    private int siid;
    private String siname;

    public int getSiid() {
        return siid;
    }

    public void setSiid(int siid) {
        this.siid = siid;
    }

    public String getSiname() {
        return siname;
    }

    public void setSiname(String siname) {
        this.siname = siname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "siid=" + siid +
                ", siname='" + siname + '\'' +
                '}';
    }
}
