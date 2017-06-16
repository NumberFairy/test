/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

/**
 * 功能: TitleVo.<br/>
 * date: 2015年7月30日 下午7:54:25 <br/>
 *
 * @author Even.
 * @version
 * @since JDK 1.7
 */
public class TitleVo {
    private String text;
    private String subtext;
    private String x;
    private String y;
    private String textAlign;

    public TitleVo() {
        super();
    }

    public TitleVo(String text, String subtext, String x, String y, String textAlign) {
        super();
        this.text = text;
        this.subtext = subtext;
        this.x = x;
        this.y = y;
        this.textAlign = textAlign;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

}
