package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.CustomerBean;

public class Database {
    private static List<CustomerBean> databaseList = new ArrayList<CustomerBean>();

    public static void initializeDatabaseList() {
        databaseList.add(new CustomerBean(1, "#98CCF6", "司波達也", 16, "『施法干擾』【Cast Jamming】"));
        databaseList.add(new CustomerBean(2, "#CCFFFF", "司波深雪", 15, "『冰霧神域』【Niflheimr】"));
        databaseList.add(new CustomerBean(3, "#CCFF66", "十文字克人", 17, "『連壁方陣』【Phalanx】"));
        databaseList.add(new CustomerBean(4, "#FFFF66", "渡邊摩利", 17, "『壓斬』【へしぎり】"));
        databaseList.add(new CustomerBean(5, "#FFCC66", "北山雫", 15, "『動態空中機雷』【Active Air Mine】"));
        databaseList.add(new CustomerBean(6, "#FF9966", "一方通行", 15, "『向量操作』【Accelerator】"));
        databaseList.add(new CustomerBean(7, "#98CCF6", "垣根帝督", 16, "『未元物質』【Dark Matter】"));
        databaseList.add(new CustomerBean(8, "#98CCF6", "禦坂美琴", 25, "『超電磁炮』【Railgun】"));
        databaseList.add(new CustomerBean(9, "#98CCF6", "麥野沈利", 26, "『原子崩壞』【Melt Downer】"));
        databaseList.add(new CustomerBean(10, "#98CCF6", "食蜂操祈", 27, "『心理掌握』【Mental Out】"));
    }

    public static List<CustomerBean> getDatabaseList() {
        return Database.databaseList;
    }

    public static void setDatabaseList(List<CustomerBean> databaseList) {
        Database.databaseList = databaseList;
    }

    public static void settingRowColorData(int customerObjKey, String backgroundColor) {
        /* 使用 iterator 走訪整個 ArrayList */
        Iterator<CustomerBean> iterator = Database.databaseList.iterator();
        while (true == iterator.hasNext()) {
            CustomerBean unit = iterator.next();

            /* 用識別每一隻物件的 Primary Key 去抓取特定物件出來，改變他內部的 backgroundColor屬性 */
            if (unit.getCustomerObjKey() == customerObjKey) {
                unit.setBackgroundColor(backgroundColor);
            }
        }
    }
}