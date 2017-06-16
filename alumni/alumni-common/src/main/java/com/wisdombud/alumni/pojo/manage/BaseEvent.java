package com.wisdombud.alumni.pojo.manage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_EVENT")
public class BaseEvent extends UUIDReservePo {
    private static final long serialVersionUID = 1L;

    @Column(name = "EVENT_TITLE")
    private String            eventTitle;

    @Column(name = "EVENT_TIME")
    private Date              eventTime;

    @Column(name = "EVENT_CONTENT")
    private String            eventContent;

    @Column(name = "STATUS")
    private String            status;

    /**
     * 功能:get 标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getEventTitle() {
        return eventTitle;
    }

    /**
     * 功能:set 标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    /**
     * 功能:get 时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Date getEventTime() {
        return eventTime;
    }

    /**
     * 功能:set 时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * 功能:get 内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getEventContent() {
        return eventContent;
    }

    /**
     * 功能:set 内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    /**
     * status.
     * 
     * @return the status
     * @since JDK 1.7
     */
    public String getStatus() {
        return status;
    }

    /**
     * status.
     * 
     * @param status the status to set
     * @since JDK 1.7
     */
    public void setStatus(String status) {
        this.status = status;
    }
}