package com.wisdombud.alumni.manage.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.BaseEventSrv;
import com.wisdombud.alumni.manage.ExcelXiaoYouService;
import com.wisdombud.alumni.pojo.manage.BaseEvent;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友工作大事记Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseEventSrv")
public class BaseEventSrvImpl extends BaseSrvImpl<BaseEvent> implements BaseEventSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseEventSrvImpl.class);
	@Autowired
	private ExcelXiaoYouService excelXYSrv;

	public BaseEventSrvImpl() {
	}

	@Autowired
	public BaseEventSrvImpl(@Qualifier(value = "baseEventDao") CommonDao<BaseEvent, String> commonDao) {
		super(commonDao);
	}

	
	@Override
	public void createExcelWorkBookInfo(HttpServletResponse response, List<BaseEvent> eList) {
		String nowStr = new Date().getTime() + "";
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setHeader("content-disposition",
					"attachment;filename=" + new String(("校友工作大事记" + nowStr).getBytes("gb2312"), "ISO8859-1") + ".xls");
			response.setContentType("APPLICATION/msexcel");
			HSSFWorkbook workbook = new HSSFWorkbook();

			Map<String, String> fildsMap = new HashMap<>();
			fildsMap.put("eventTitle", "标题");
			fildsMap.put("eventTime", "时间");
			fildsMap.put("eventContent", "内容");

			excelXYSrv.export(eList, fildsMap, workbook);
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 强行将响应缓存中的内容发送到目的地
				response.flushBuffer();
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}
}
