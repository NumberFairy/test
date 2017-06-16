package com.wisdombud.alumni.actions.common;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.wisdombud.alumni.dao.common.MongoGridFsDao;
import com.wisdombud.alumni.vo.CommonResult;

import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 操作MongoGridFs的Action.<br/>
 * date: 2017年3月21日 下午5:46:06 <br/>
 *
 * @author zlliu
 * @version
 * @since JDK 1.7
 */
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace(value = "/")
public class GridFSAction extends AbstractCommonAction {
	private static final long	serialVersionUID = 1L;

	private static final Logger	LOGGER			 = Logger.getLogger(GridFSAction.class);

	private static final int	MAXSIZE			 = 500;

	@Autowired
	private MongoGridFsDao		gridFsDao;

	private List<File>			upload;													// 得到上传的文件
	private List<String>		uploadFileName;											// 得到文件的名称

	private List<File>			imgFile;												// 得到上传的文件
	private List<String>		imgFileFileName;										// 得到文件的名称

	@Action(value = "gridfs-upload")
	public void upload() {
		response.setContentType("text/html; charset=UTF-8");
		StringBuilder f_ids = new StringBuilder();
		StringBuilder fileNames = new StringBuilder();
		for (int i = 0; i < upload.size(); i++) {
			final File file = upload.get(i);
			final String fileName = uploadFileName.get(i);

			LOGGER.info("-------->上传的文件的文件名为：" + fileName);
			// 检查文件大小
			if (file.length() > MAXSIZE * 1024 * 1024) {
				LOGGER.error("-------->上传文件大小超过限制,当前允许的最大文件大小为：" + MAXSIZE + "MB");
				continue;
			}
			String f_id = gridFsDao.uploadFile(file, fileName);
			if (i == upload.size() - 1) {
				f_ids.append(f_id);
				fileNames.append(fileName);
			} else {
				f_ids.append(f_id + ",");
				fileNames.append(fileName + ",");
			}
			LOGGER.info("保存上传附件：f_id：" + f_id + "文件名：" + fileName + "成功!");

		}
		this.sendResponseMsg(new Gson().toJson(new Result(f_ids.toString(), fileNames.toString())));
	}

	@Action(value = "ueditor-upload")
	public void ueditorUpload() {
		response.setCharacterEncoding("UTF-8"); // 防止中文乱码
		response.setContentType("text/html; charset=UTF-8");

		UResult result = new UResult();
		for (int i = 0; i < imgFile.size(); i++) {
			final File file = imgFile.get(i);
			final String fileName = imgFileFileName.get(i);

			LOGGER.info("-------->上传的文件的文件名为：" + fileName);
			result.size = file.length();
			result.original = result.title = fileName;
			// 检查文件大小
			if (file.length() > MAXSIZE * 1024 * 1024) {
				LOGGER.error("-------->上传文件大小超过限制,当前允许的最大文件大小为：" + MAXSIZE + "MB");
				result.state = "上传文件大小超过限制,当前允许的最大文件大小为：" + MAXSIZE + "MB";
				break;
			}
			String f_id = gridFsDao.uploadFile(file, fileName);
			LOGGER.info("保存上传附件：f_id：" + f_id + "文件名：" + fileName + "成功!");
			result.state = "SUCCESS";
			result.url = "/gridfs-download?f_id=" + f_id;
			break;

		}
		this.sendResponseMsg(new Gson().toJson(result));
	}

	@Action(value = "gridfs-download")
	public void download() {
		String f_id = request.getParameter("f_id");
		gridFsDao.downloadFile(f_id, response);
	}

	@Action(value = "gridfs-delete")
	public void delete() {
		String f_id = request.getParameter("f_id");
		gridFsDao.deleteFile(f_id);
		this.sendResponseMsg(new Gson().toJson(new CommonResult(CommonResult.SUCCESS)));
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<File> getImgFile() {
		return imgFile;
	}

	public void setImgFile(List<File> imgFile) {
		this.imgFile = imgFile;
	}

	public List<String> getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(List<String> imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	class Result {
		public String  f_id;
		public String  fileName;

		public String  url;
		public Integer error;
		public String  message;

		public Result() {
		}

		public Result(String f_id, String fileName) {
			this.f_id = f_id;
			this.fileName = fileName;
		}
	}
	
	class UResult {
		public String original;
		public long size;
		public String state;
		public String title;
		public String type;
		public String url;
	}
}
