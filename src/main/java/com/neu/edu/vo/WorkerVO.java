package com.neu.edu.vo;

public class WorkerVO {
    /*
           属性名               数据库字段名
           workerNum            int not null,
           name                 varchar(20),
           age                  smallint,
           sex                  varchar(6),
           phoneNum             varchar(11),
           workTime             smallint,
           office               varchar(20),
           salary               bigint,
       */
    private Integer workerNum;
    private String name;
    private Integer age;
    private String sex;
    private String phoneNum;
    private Integer workTime;
    private String office;
    private Integer salary;

    public Integer getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(Integer workerNum) {
        this.workerNum = workerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }



}
