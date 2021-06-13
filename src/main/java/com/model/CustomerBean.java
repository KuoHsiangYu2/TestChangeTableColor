package com.model;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int customerObjKey = 0;/* 識別每一隻物件的 Primary Key */
    private String backgroundColor = "";/* 該列資料背景顏色 */
    private String roleName = "";/* 角色名稱 */
    private int age = 0;/* 角色年齡 */
    private String ability = "";/* 特殊能力 */

    @Override
    public String toString() {
        return "CustomerBean [roleName=" + roleName + "]";
    }

    public CustomerBean() {
        super();
    }

    public CustomerBean(int customerObjKey, String backgroundColor, String roleName, int age, String ability) {
        super();
        this.customerObjKey = customerObjKey;
        this.backgroundColor = backgroundColor;
        this.roleName = roleName;
        this.age = age;
        this.ability = ability;
    }

    public int getCustomerObjKey() {
        return customerObjKey;
    }

    public void setCustomerObjKey(int customerObjKey) {
        this.customerObjKey = customerObjKey;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}