/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

/**
 * 功能: tool tip vo.<br/>
 * date: 2015年4月9日 上午10:49:11 <br/>
 *
 * @author joseph
 * @author Even.
 * @version
 * @since JDK 1.7
 */
public class ToolTipVo {
    private boolean show = true;
    private String  trigger;    // 触发类型
    private String  formatter;  // 内容格式器

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

}
