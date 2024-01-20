package son.lab2.model;

import java.io.Serializable;
import java.util.Date;

public class CheckResult implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean result;
    private Date time;

    public CheckResult(double x, double y, double r, boolean result, Date time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}
