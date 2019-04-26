package com.course.domain;

public class Major {
    private int id;
    private int  num;
    private String maname;
    private String edu_system;
    private int department;
    private String dename;

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getManame() {
        return maname;
    }

    public void setManame(String maname) {
        this.maname = maname;
    }

    public String getEdu_system() {
        return edu_system;
    }

    public void setEdu_system(String edu_system) {
        this.edu_system = edu_system;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
