/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.util;

import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * 功能: TODO.<br/>
 * date: 2015年3月11日 下午4:30:29 <br/>
 * 
 * @author xzzhao@wisdombud.com
 * @version
 * @since JDK 1.7
 */
public class JZipUtils {

	public static void unzip(String source, String dest, String psw) throws ZipException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(dest, "dest must not be null");

		ZipFile zipFile = new ZipFile(source);
		if (zipFile.isEncrypted()) {
			zipFile.setPassword(psw);
		}
		zipFile.extractAll(dest);
	}

	public static void zipFolder(String folderToAdd, String zipFilePath, String psw) throws ZipException {
		ZipFile zipFile = new ZipFile(zipFilePath);
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		if (StringUtils.isNotEmpty(psw)) {
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(psw);
		}
		zipFile.addFolder(folderToAdd, parameters);
	}

	public static void zipFiles(ArrayList<File> files, String zipFilePath, String psw) throws ZipException {
		File file = new File(zipFilePath);
		if (file.exists()) {
			// boolean res = file.delete();
			// 删除被进程占用的文件，可以先判断文件是否被删除，如果没有，则让系统强制回收资源，再进行文件的删除
			// if(!res){
			// System.gc();//系统进行资源强制回收
			// file.delete();
			// }
		}
		ZipFile zipFile = new ZipFile(zipFilePath);
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		if (StringUtils.isNotEmpty(psw)) {
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(psw);
		}
		zipFile.addFiles(files, parameters);
	}

	public static void main(String[] args) {
		String zipFilePath = "/Users/guohuilin/Code/java/wisdombud-pku/pku-career-m1/career-web/src/main/webapp/attached/tmp/国辉林和测试下载汇款凭证--汇款凭证.zip";
		String file = "/Users/guohuilin/Downloads/1.png";
		ArrayList<File> fileList = new ArrayList<>();
		fileList.add(new File(file));
		try {
			JZipUtils.zipFiles(fileList, zipFilePath, null);
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}
}
