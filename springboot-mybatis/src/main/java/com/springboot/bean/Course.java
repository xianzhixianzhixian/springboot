package com.springboot.bean;

public class Course {

    private Long cno;
    private String cname;
    private String credit;
    private String cterm;
    private String ctea;

    public Long getCno() {
        return cno;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public String getCtea() {
        return ctea;
    }

    public void setCtea(String ctea) {
        this.ctea = ctea;
    }

}
