/**
 * Project Name:career-web
 * File Name:ThymeleafTemplateUtilt.java
 * Package Name:com.wisdombud.career.util
 * Date:2015年10月27日上午11:28:24
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 */

package com.wisdombud.alumni.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import common.toolkit.java.spring.SpringContextHolder;

/**
 * ClassName:ThymeleafTemplateUtilt <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月27日 上午11:28:24 <br/>
 * @author guohuilin
 * @version
 * @since JDK 1.6
 * @see
 */
public class ThymeleafTemplateUtil {
    public static String createHtml(String tplName, WebContext ctx) {
        TemplateEngine templateEngine = SpringContextHolder.getBean("templateEngine");
        // templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());
        return templateEngine.process(tplName, ctx);
    }
}
