package com.springboot.config;

public enum AreaKeyId {
    //已经定义的状态不能被修改,对应了数据库操作
    BEIJING("北京", "010"), CHENGDU("成都","028");

    private String name;
    private String area;

    private AreaKeyId(String name, String area) {
        this.setName(name);
        this.setArea(area);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
