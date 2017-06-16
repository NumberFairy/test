/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

/**
 * 功能: y轴 vo.<br/>
 * date: 2015年4月9日 上午10:54:21 <br/>
 * 
 * @author joseph
 * @version
 * @since JDK 1.7
 */
public class YAxisVo {
    private String name;
    private String type;
    private String position;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
