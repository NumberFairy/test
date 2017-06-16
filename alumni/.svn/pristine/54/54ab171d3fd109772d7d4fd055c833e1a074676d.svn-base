/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo.echars;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能: 柱状图 vo.<br/>
 * date: 2015年4月9日 上午10:47:51 <br/>
 *
 * @author joseph
 * @version
 * @since JDK 1.7
 */
public class BarVo {
    /**
     *
     */

    public BarVo() {
        this.title = new TitleVo();
        this.tooltip = new ToolTipVo();
        this.legend = new LegendVo();
        this.xAxis = new ArrayList<XAxisVo>();
        this.yAxis = new ArrayList<YAxisVo>();
        this.series = new ArrayList<SerieVo>();

    }

    private TitleVo             title;
    private final ToolTipVo     tooltip;
    private final LegendVo      legend;
    private final List<XAxisVo> xAxis;
    private final List<YAxisVo> yAxis;
    private final List<SerieVo> series;

    public ToolTipVo getTooltip() {
        return tooltip;
    }

    public LegendVo getLegend() {
        return legend;
    }

    public List<XAxisVo> getxAxis() {
        return xAxis;
    }

    public List<YAxisVo> getyAxis() {
        return yAxis;
    }

    public List<SerieVo> getSeries() {
        return series;
    }

    public TitleVo getTitle() {
        return title;
    }

    public void setTitle(TitleVo title) {
        this.title = title;
    }

}
