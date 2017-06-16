package com.wisdombud.alumni.threadlocal;

/**
 * ClassName: UserThreadLocal. <br/>
 * Function: TODO <br/>
 * date: 2014年7月1日 下午4:08:31 <br/>
 * @author Ghlin
 * @version
 * @since JDK 1.6
 */
public final class UserThreadLocal {
    private static final ThreadLocal<UserSession> LOCAL = new ThreadLocal<UserSession>();

    private UserThreadLocal() {
    }

    public static void setUserSession(final UserSession session) {
        LOCAL.set(session);
    }

    public static UserSession getUserSession() {
        return LOCAL.get();
    }

}
