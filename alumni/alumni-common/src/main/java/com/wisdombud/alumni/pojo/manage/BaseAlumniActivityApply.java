package com.wisdombud.alumni.pojo.manage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_ALUMNI_ACTIVITY_APPLY")
public class BaseAlumniActivityApply extends UUIDReservePo {
    private static final long serialVersionUID = 1L;

    @Column(name = "TITLE")
    private String            title;

    @Column(name = "PERSON")
    private String            person;

    @Column(name = "PLACE")
    private String            place;

    @Column(name = "START_TIME")
    private Date              startTime;

    @Column(name = "END_TIME")
    private Date              endTime;

    @Column(name = "APPLY_START_TIME")
    private Date              applyStartTime;

    @Column(name = "APPLY_END_TIME")
    private Date              applyEndTime;

    @Column(name = "CONTENT")
    private String            content;

    @Column(name = "STATUS")
    private Integer           status;

    @Column(name = "IS_SIGN_UP")
    private Integer           isSignUp;

    @Column(name = "AUDITOR")
    private String            auditor;

    @Column(name = "AUDIT_TIME")
    private Date              auditTime;

    @Column(name = "AUDIT_OPINION")
    private String            auditOpinion;

    /**
     * 功能:get '标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getTitle() {
        return title;
    }

    /**
     * 功能:set '标题'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 功能:get '申请人'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getPerson() {
        return person;
    }

    /**
     * 功能:set '申请人'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * 功能:get '活动地点'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getPlace() {
        return place;
    }

    /**
     * 功能:set '活动地点'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 功能:get '活动开始时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Date getStartTime() {
        return startTime;
    }

    /**
     * 功能:set '活动开始时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 功能:get '活动结束时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Date getEndTime() {
        return endTime;
    }

    /**
     * 功能:set '活动结束时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 功能:get '内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getContent() {
        return content;
    }

    /**
     * 功能:set '内容'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 功能:get '状态'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Integer getStatus() {
        return status;
    }

    /**
     * 功能:set '状态'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 功能:get '审核人'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getAuditor() {
        return auditor;
    }

    /**
     * 功能:set '审核人'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    /**
     * 功能:get '审核时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 功能:set '审核时间'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 功能:get '审核意见'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */

    public String getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * 功能:set '审核意见'<br/>
     * date: <br/>
     *
     * @author
     * @return
     */
    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    /**
     * applyStartTime.
     * 
     * @return the applyStartTime
     * @since JDK 1.7
     */
    public Date getApplyStartTime() {
        return applyStartTime;
    }

    /**
     * applyStartTime.
     * 
     * @param applyStartTime the applyStartTime to set
     * @since JDK 1.7
     */
    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    /**
     * applyEndTime.
     * 
     * @return the applyEndTime
     * @since JDK 1.7
     */
    public Date getApplyEndTime() {
        return applyEndTime;
    }

    /**
     * applyEndTime.
     * 
     * @param applyEndTime the applyEndTime to set
     * @since JDK 1.7
     */
    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    /**
     * isSignUp.
     * 
     * @return the isSignUp
     * @since JDK 1.7
     */
    public Integer getIsSignUp() {
        return isSignUp;
    }

    /**
     * isSignUp.
     * 
     * @param isSignUp the isSignUp to set
     * @since JDK 1.7
     */
    public void setIsSignUp(Integer isSignUp) {
        this.isSignUp = isSignUp;
    }
}