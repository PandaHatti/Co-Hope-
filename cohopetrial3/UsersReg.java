package com.example.cohopetrial3;

public class UsersReg
{
    public String name, phone, email, age;
    public UsersReg()
    {

    }

    public UsersReg(String name,String phone,String email, String age)
    {
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.age=age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
