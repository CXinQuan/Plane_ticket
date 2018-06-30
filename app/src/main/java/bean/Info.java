package bean;

/**
 * Created by lenovo on 2018/6/11.
 */

public class Info {
    String name;
    String hb;
    String place;
    String time;

    public Info() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Info(String name, String hb, String place,String time) {
        this.name = name;
        this.hb = hb;
        this.place = place;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String plane) {
        this.place = plane;
    }
}
