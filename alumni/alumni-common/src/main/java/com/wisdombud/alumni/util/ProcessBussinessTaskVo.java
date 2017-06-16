/**
 * Date:2015年2月28日 上午10:39:20
 * Copyright (c) 2015, www.wisdombud.com All Rights Reserved.
 */

package com.wisdombud.alumni.util;

/**
 * 功能: TODO <br/>
 * date: 2015年2月28日 上午10:39:20 <br/>
 * 
 * @author guohuilin
 * @version
 * @since JDK 1.6
 */
public class ProcessBussinessTaskVo {
    private String taskId;
    private String taskKey;

    /**
     * @param taskId
     * @param taskKey
     */

    public ProcessBussinessTaskVo(String taskId, String taskKey) {
        this.taskId = taskId;
        this.taskKey = taskKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

}
