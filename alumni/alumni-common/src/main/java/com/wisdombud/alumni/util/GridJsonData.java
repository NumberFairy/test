package com.wisdombud.alumni.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GridJsonData. <br/>
 * Function: TODO <br/>
 * date: 2013年11月25日 下午9:04:58 <br/>
 * @author ghlin
 * @version
 * @since JDK 1.6
 */
public class GridJsonData<T extends Serializable> {
    private long    totalProperty;
    private List<T> data = new ArrayList<T>();
    private long    pageNum;

    /**
     * Creates a new instance of GridJsonData.
     */

    public GridJsonData() {
    }

    /**
     * Creates a new instance of GridJsonData.
     * @param totalProperty
     * @param data
     */

    public GridJsonData(long totalProperty, List<T> data, long pageNum) {
        this.totalProperty = totalProperty;
        this.data = data;
        this.pageNum = pageNum;
    }

    /**
     * totalProperty.
     * @return the totalProperty
     * @since JDK 1.6
     */
    public long getTotalProperty() {
        return this.totalProperty;
    }

    /**
     * data.
     * @return the data
     * @since JDK 1.6
     */
    public List<T> getData() {
        return this.data;
    }

    /**
     * totalProperty.
     * @param totalProperty the totalProperty to set
     * @since JDK 1.6
     */
    public void setTotalProperty(long totalProperty) {
        this.totalProperty = totalProperty;
    }

    /**
     * data.
     * @param list the data to set
     * @since JDK 1.6
     */
    public void setData(List<T> list) {
        this.data = list;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

}
