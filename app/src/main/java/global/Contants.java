package global;

import java.util.ArrayList;
import java.util.List;

import bean.Info;

/**
 * Created by lenovo on 2018/6/17.
 */

public class Contants {
    public static boolean isFirst = true;

    public static List<Info> list = new ArrayList<Info>();

    public static List<Info> getList() {
        if (isFirst) {
            initData();
            isFirst=false;
        }
        return list;
    }

    private static void initData() {

        Info info1 = new Info("Tom", "KH2001", "北京", "03:00");
        Info info2 = new Info("Jerry", "KH2001", "北京", "03:00");
        Info info3 = new Info("Rose", "KH2001", "北京", "03:00");
        Info info4 = new Info("Jack", "KH2001", "北京", "03:00");
        Info info5 = new Info("Marry", "KH2001", "北京", "03:00");
        Info info6 = new Info("Shan", "KH2001", "北京", "03:00");
        Info info7 = new Info("Song", "KH2001", "天的那边", "03:00");
        list.add(info1);
        list.add(info2);
        list.add(info3);
        list.add(info4);
        list.add(info5);
        list.add(info6);
        list.add(info7);
    }

    public static void addData(Info info) {
        list.add(info);
    }

    public static void removeData(Info info) {
        list.remove(info);
    }

}
