package com.wisdombud.alumni.vo.echars;


public class ItemStyleVo {
    private NormalVo normal;

    public NormalVo getNormal() {
        return normal;
    }

    public void setNormal(NormalVo normal) {
        this.normal = normal;
    }

    public ItemStyleVo(String color) {
        this.normal = new NormalVo(color);
    }
}
