package com.wisdombud.alumni.actions.base;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionContext;

import common.toolkit.java.struts2.AbstractCommonAction;
import common.toolkit.java.util.DateUtil;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@SuppressWarnings("rawtypes")
public class ExcelAction extends AbstractCommonAction {
	private static final Logger	 LOGGER			  = Logger.getLogger(ExcelAction.class);
	private static final long	 serialVersionUID = -1265625283843124115L;
	/**
	 * MAXROWINDEX:TODO(一个工作簿最大导出行数).
	 */
	protected static final int	 MAXROWINDEX	  = 65536;
	protected String			 EXCEL_TITLE	  = "";
	protected String			 SHEETNAME		  = "";
	protected WritableCellFormat headCellFont;
	protected WritableCellFormat cellHeadFormat;
	protected WritableCellFormat mycellFormat;
	protected WritableCellFormat redBgCellFormat;
	protected XSSFCellStyle		 titleCellStyle;
	protected XSSFCellStyle		 cellStyle;

	public void exportRealTime() {
		final Map<String, Object> realTimeMsg = new HashMap<String, Object>();
		realTimeMsg.put("realtime", ActionContext.getContext().getSession().get("excelrealtime"));
		realTimeMsg.put("exportsuccess", ActionContext.getContext().getSession().get("createExcelsuccess"));
		sendSuccessMsg(realTimeMsg, "");
	}

	/**
	 * poi-导出Excel . <br/>
	 * 
	 * @author Administrator
	 * @param response
	 * @param voList
	 */
	protected <T> void createExcel(HttpServletResponse response, List<T> voList) {
		String nowStr = new Date().getTime() + "";
		Map<String, Object> strutsSession = ActionContext.getContext().getSession();
		strutsSession.put("excelrealtime", 0);
		strutsSession.put("createExcelsuccess", false);
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setHeader("content-disposition",
							   "attachment;filename=" + new String((EXCEL_TITLE + nowStr).getBytes("gb2312"),
																   "ISO8859-1")
													  + ".xls");
			response.setContentType("APPLICATION/msexcel");
			XSSFWorkbook workbook = new XSSFWorkbook();
			initCellStyle(workbook);
			addDate(workbook, voList, strutsSession);
			workbook.write(out);
		} catch (IOException e) {
			LOGGER.error(e);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e);
		} catch (IllegalAccessException e) {
			LOGGER.error(e);
		} finally {
			strutsSession.put("createExcelsuccess", true);
			try {
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

	/**
	 * 初始化Title. <br/>
	 * 
	 * @author zhang
	 * @param sheet
	 */
	protected void initTitle(XSSFSheet sheet) {
		// 起始行号，终止行号， 起始列号，终止列号
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		XSSFRow row = sheet.createRow(0);
		row.setHeight((short) 30);
		XSSFCell cell = row.createCell(0);
		cell.setCellStyle(titleCellStyle);
		cell.setCellValue(EXCEL_TITLE);
	}

	/**
	 * poi-写入数据. <br/>
	 * 
	 * @author Administrator
	 * @param workbook
	 * @param voList
	 * @param strutsSession
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	protected <T> void addDate(XSSFWorkbook workbook, List<T> voList, Map<String, Object> strutsSession)
			throws IllegalArgumentException, IllegalAccessException {

		int count = voList.size();
		int realtimeIndex = 0;
		int rowIndex = 2;
		int sheetIndex = 1;
		for (int i = 0; i < voList.size(); i++) {
			XSSFSheet sheet = null;
			if ((rowIndex - 2) % 100 == 0) {
				sheetIndex++;
				sheet = workbook.createSheet(SHEETNAME + sheetIndex);
				initTitle(sheet);
				rowIndex = 2;
			}
			XSSFRow row = sheet.createRow(i + 2);

			Class clazz = voList.get(i).getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				fields[j].setAccessible(true);
				XSSFCell cell = row.createCell(j);
				LOGGER.info("====>j=:" + j + ":" + fields[j].get(voList.get(i)));
				if (!fields[j].getName().equals("id")
					&& (Modifier.FINAL + Modifier.PUBLIC + Modifier.STATIC) != fields[j].getModifiers()
					&& (Modifier.FINAL + Modifier.PRIVATE + Modifier.STATIC) != fields[j].getModifiers()) {
					if (fields[j].getType() == Date.class) {
						cell.setCellValue((Date) fields[j].get(voList.get(i)));
					} else if (fields[j].getType() == Short.class) {
						cell.setCellValue(fields[j].get(voList.get(i)).toString().equals("1") ? "是" : "否");
					} else if (fields[j].getType() == Boolean.class) {
						cell.setCellValue(fields[j].get(voList.get(i)).toString().equals("1") ? "是" : "否");
					} else {
						cell.setCellValue(fields[j].get(voList.get(i)).toString());
					}
				}
			}
			realtimeIndex++;
			rowIndex++;
			strutsSession.put("excelrealtime", (double) (realtimeIndex * 10 / count) / 10);
		}
	}

	/**
	 * poi-导出Excel-初始化单元格样式. <br/>
	 * 
	 * @author Administrator
	 * @param workbook
	 */
	protected void initCellStyle(XSSFWorkbook workbook) {
		titleCellStyle = workbook.createCellStyle();
		titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
		XSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeight(18);
		titleCellStyle.setFont(font);
		cellStyle = workbook.createCellStyle();
	}

	/**
	 * jxl-导出. <br/>
	 * 
	 * @author Administrator
	 * @param response
	 * @param voList
	 */
	protected <T> void createExcelWorkBook(HttpServletResponse response, List<T> voList) {
		Map<String, Object> strutsSession = ActionContext.getContext().getSession();
		strutsSession.put("excelrealtime", 0);
		strutsSession.put("createExcelsuccess", false);
		String nowStr = new Date().getTime() + "";
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setHeader("content-disposition",
							   "attachment;filename=" + new String((EXCEL_TITLE + nowStr).getBytes("gb2312"),
																   "ISO8859-1")
													  + ".xls");
			response.setContentType("APPLICATION/msexcel");

			/***************************************************************************
			 * 以下两行用于修复 导出时
			 * jxl.write.biff.WriteAccessRecord.<init>(WriteAccessRecord
			 * .java:59)
			 * java.lang.ArrayIndexOutOfBoundsException 的bug,根据API的说明
			 * When writing worksheets, it uses the value from the
			 * WorkbookSettings object,
			 * if this is not set (null) this is hard coded as
			 * Java Excel API + Version number
			 ***************************************************************************/
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);
			WritableWorkbook exportExcel = Workbook.createWorkbook(out, settings);
			/** ********** 创建工作表 ********** **/
			initCellFormat();
			fillInData(exportExcel, voList, strutsSession);

			exportExcel.write();
			exportExcel.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			strutsSession.put("createExcelsuccess", true);
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

	/**
	 * jxl-导出-初始化标题. <br/>
	 * 
	 * @author Administrator
	 * @param sheetoffice
	 * @throws WriteException
	 */
	protected void initTitle(WritableSheet sheetoffice) throws WriteException {
		sheetoffice.setRowView(0, 1000);
		insertContentCell(sheetoffice, 0, 0, getEXCEL_TITLE(), getHeadCellFont(), 0);
		sheetoffice.mergeCells(0, 0, 2, 0);
		insertContentCell(sheetoffice, 0, 1, "用户", getMycellFormat(), 40);
		insertContentCell(sheetoffice, 1, 1, "操作时间", getMycellFormat(), 40);
		insertContentCell(sheetoffice, 2, 1, "操作内容", getMycellFormat(), 40);
	}

	/**
	 * jxl-插入内容单元格
	 * 
	 * @param sheet
	 * @param colIndex 列
	 * @param rowIndex 行
	 * @param value
	 * @throws WriteException
	 */

	protected void insertContentCell(WritableSheet sheet, int colIndex, int rowIndex, String value,
			WritableCellFormat cellFormat, int width) throws WriteException {
		if (width != 0) {
			sheet.setColumnView(colIndex, width);
		}
		sheet.addCell(new Label(colIndex, rowIndex, value, cellFormat));
	}

	/**
	 * jxl填充数据. ;
	 * 
	 * @author xlzhang
	 * @param sheet
	 * @param listMultimap
	 * @throws WriteException
	 */
	protected <T> void fillInData(WritableWorkbook exportExcel, List<T> voList, Map<String, Object> strutsSession)
			throws WriteException {

		WritableSheet sheet = null;
		int count = voList.size();
		int realtimeIndex = 0;
		int row = 2;
		int sheetIndex = 0;
		for (int i = 0; i < voList.size(); i++) {
			if ((row - 2) % 500 == 0) {
				sheetIndex++;
				sheet = exportExcel.createSheet(SHEETNAME + sheetIndex, sheetIndex);
				initTitle(sheet);
				row = 2;
			}
			T item = voList.get(i);
			Class clazz = item.getClass();
			Field[] fields = clazz.getDeclaredFields();
			// 根据传入的Class动态生成pojo对象
			try {
				int fieldIndex = 0;
				for (Field field : fields) {
					// 设置字段可访问（必须，否则报错）
					field.setAccessible(true);
					// 得到字段的属性名
					if (!field.getName().equals("id")
						&& (Modifier.FINAL + Modifier.PUBLIC + Modifier.STATIC) != field.getModifiers()
						&& (Modifier.FINAL + Modifier.PRIVATE + Modifier.STATIC) != field.getModifiers()) {
						if (field.getType() == Date.class) {
							String time = "";
							if (field.get(item) != null) {
								time = DateUtil.convertDbString2String(field.get(item).toString());
							}
							insertContentCell(sheet, fieldIndex, row, time, mycellFormat, 40);
						} else if (field.getType() == Short.class) {
							insertContentCell(sheet, fieldIndex, row,
											  (field.get(item) == null ? ""
																	   : (field.get(item) + "").equals("1") ? "是"
																											: "否"),
											  mycellFormat, 40);
						} else {
							if (field.getName().indexOf("Time") > 0) {
								insertContentCell(sheet, fieldIndex, row,
												  DateUtil.convertDbString2String(field.get(item) == null ? ""
																										  : field.get(item)
																												  .toString()),
												  mycellFormat, 40);
							} else {
								insertContentCell(sheet, fieldIndex, row,
												  field.get(item) == null ? "" : field.get(item).toString(),
												  mycellFormat, 40);
							}
						}
						fieldIndex++;
					}
				}
			} catch (IllegalAccessException e) {
				LOGGER.error(e);
			}
			realtimeIndex++;
			row++;
			strutsSession.put("excelrealtime", (double) (realtimeIndex * 10 / count) / 10);
		}
	}

	/**
	 * jxl-初始化excel单元格格式. bean初始
	 * 
	 * @author ghlin
	 * @throws WriteException
	 */

	protected void initCellFormat() throws WriteException {
		WritableCellFormat baseFormat = new WritableCellFormat();
		baseFormat.setAlignment(Alignment.CENTRE);
		baseFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		headCellFont = new WritableCellFormat();
		headCellFont.setBorder(Border.ALL, BorderLineStyle.THIN);
		headCellFont.setAlignment(Alignment.CENTRE);// 水平
		headCellFont.setVerticalAlignment(VerticalAlignment.CENTRE);// 纵向
		headCellFont.setFont(new WritableFont(WritableFont.createFont("宋体"),
											  20,
											  WritableFont.BOLD,
											  false,
											  jxl.format.UnderlineStyle.NO_UNDERLINE,
											  jxl.format.Colour.BLACK));

		cellHeadFormat = new WritableCellFormat();
		cellHeadFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		cellHeadFormat.setAlignment(Alignment.CENTRE);// 水平
		cellHeadFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 纵向
		cellHeadFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),
												14,
												WritableFont.BOLD,
												false,
												jxl.format.UnderlineStyle.NO_UNDERLINE,
												jxl.format.Colour.BLACK));

		mycellFormat = new WritableCellFormat(baseFormat);
		mycellFormat.setAlignment(Alignment.CENTRE);// 水平
		mycellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 纵向
		mycellFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),
											  12,
											  WritableFont.NO_BOLD,
											  false,
											  jxl.format.UnderlineStyle.NO_UNDERLINE,
											  jxl.format.Colour.BLACK));
		redBgCellFormat = new WritableCellFormat(baseFormat);
		redBgCellFormat.setWrap(true);
		redBgCellFormat.setBackground(Colour.RED);
	}

	public String getSHEETNAME() {
		return SHEETNAME;
	}

	/**
	 * 设置单元格名称. <br/>
	 * 
	 * @author zhang
	 * @param sHEETNAME
	 */
	public void setSHEETNAME(String sHEETNAME) {
		SHEETNAME = sHEETNAME;
	}

	public String getEXCEL_TITLE() {
		return EXCEL_TITLE;
	}

	/**
	 * 设置头部文字. <br/>
	 * 
	 * @author zhang
	 * @param eXCEL_TITLE
	 */
	public void setEXCEL_TITLE(String eXCEL_TITLE) {
		EXCEL_TITLE = eXCEL_TITLE;
	}

	public WritableCellFormat getHeadCellFont() {
		return headCellFont;
	}

	public void setHeadCellFont(WritableCellFormat headCellFont) {
		this.headCellFont = headCellFont;
	}

	public WritableCellFormat getMycellFormat() {
		return mycellFormat;
	}

	public void setMycellFormat(WritableCellFormat mycellFormat) {
		this.mycellFormat = mycellFormat;
	}

	public WritableCellFormat getRedBgCellFormat() {
		return redBgCellFormat;
	}

	public void setRedBgCellFormat(WritableCellFormat redBgCellFormat) {
		this.redBgCellFormat = redBgCellFormat;
	}

	public XSSFCellStyle getTitleCellStyle() {
		return titleCellStyle;
	}

	public void setTitleCellStyle(XSSFCellStyle titleCellStyle) {
		this.titleCellStyle = titleCellStyle;
	}

	public XSSFCellStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(XSSFCellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}

	public WritableCellFormat getCellHeadFormat() {
		return cellHeadFormat;
	}

	public void setCellHeadFormat(WritableCellFormat cellHeadFormat) {
		this.cellHeadFormat = cellHeadFormat;
	}

}
