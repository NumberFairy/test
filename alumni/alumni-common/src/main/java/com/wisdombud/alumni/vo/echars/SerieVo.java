/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

import java.util.List;

/**
 * 功能: 曲线.<br/>
 * date: 2015年4月9日 上午10:55:10 <br/>
 *
 * @author joseph
 * @version
 * @since JDK 1.7
 */
public class SerieVo {
    private String      name;
    private String      type;
    private String      stack;
    private String      radius;
    private List<?>     data;
    private int         yAxisIndex;

    private ItemStyleVo itemStyle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public ItemStyleVo getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(ItemStyleVo itemStyle) {
        this.itemStyle = itemStyle;
    }

    public int getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(int yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

}
