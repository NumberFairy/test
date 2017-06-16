package com.wisdombud.alumni.threadlocal;


/**
 * ClassName: UserSession. <br/>
 * Function: TODO <br/>
 * date: 2013年8月22日 下午3:44:17 <br/>
 *
 * @author ghlin
 * @version
 * @since JDK 1.6
 */
public class UserSession {

    private String        id;
    private String        loginName;
    private String        userName;
    private String        sessionId;
    private Integer       designation;
    private Integer       isAdmin;

    /**
     * id.
     *
     * @return the id
     * @since JDK 1.6
     */
    public String getId() {
        return this.id;
    }

    /**
     * id.
     *
     * @param id
     *            the id to set
     * @since JDK 1.6
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * sessionId.
     *
     * @return the sessionId
     * @since JDK 1.6
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * sessionId.
     *
     * @param sessionId
     *            the sessionId to set
     * @since JDK 1.6
     */
    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(final String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

}
