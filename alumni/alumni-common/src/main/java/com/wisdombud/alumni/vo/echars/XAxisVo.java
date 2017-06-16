/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

import java.util.List;

/**
 * 功能: x轴坐标 vo.<br/>
 * date: 2015年4月9日 上午10:51:25 <br/>
 * 
 * @author joseph
 * @version
 * @since JDK 1.7
 */
public class XAxisVo {
    private String       type;
    private List<String> data;
    private AxisLableVo  axisLabel;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public AxisLableVo getAxisLabel() {
        return axisLabel;
    }

    public void setAxisLabel(AxisLableVo axisLabel) {
        this.axisLabel = axisLabel;
    }
}
