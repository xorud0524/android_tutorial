package com.sunrin.custom_listview;

/**
 * Created by 1002230 on 16. 12. 2..
 */
public class User2 {

    private int image;
    private String name;
    private String phone;
    private int age;

    public User2(int image, String name, String phone, int age) {
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
