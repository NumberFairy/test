package com.wisdombud.alumni.vo.echars;

import java.util.List;

/**
 * 功能: PieVo.<br/>
 * date: 2015年7月31日 上午11:38:38 <br/>
 *
 * @author Even.
 * @version
 * @since JDK 1.7
 */
public class PieVo {
    private TitleVo       title;
    private ToolTipVo     tooltip;
    private LegendVo      legend;
    private List<SerieVo> series;

    public TitleVo getTitle() {
        return title;
    }

    public void setTitle(TitleVo title) {
        this.title = title;
    }

    public ToolTipVo getTooltip() {
        return tooltip;
    }

    public void setTooltip(ToolTipVo tooltip) {
        this.tooltip = tooltip;
    }

    public LegendVo getLegend() {
        return legend;
    }

    public void setLegend(LegendVo legend) {
        this.legend = legend;
    }

    public List<SerieVo> getSeries() {
        return series;
    }

    public void setSeries(List<SerieVo> series) {
        this.series = series;
    }

}
