package com.wisdombud.alumni.pojo.manage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_MEMO")
public class BaseMemo extends UUIDReservePo {
    private static final long serialVersionUID = 1L;

    @Column(name = "TITLE")
    private String            title;

    @Column(name = "MEMO_TIME")
    private Date              memoTime;

    @Column(name = "CONTENT")
    private String            content;

    @Column(name = "STATUS")
    private String            status;

    /**
     * 功能:get 标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getTitle() {
        return title;
    }

    /**
     * 功能:set 标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 功能:get 时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Date getMemoTime() {
        return memoTime;
    }

    /**
     * 功能:set 时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setMemoTime(Date memoTime) {
        this.memoTime = memoTime;
    }

    /**
     * 功能:get 内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getContent() {
        return content;
    }

    /**
     * 功能:set 内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setContent(String content) {
        this.content = content;
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