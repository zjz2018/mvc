package com.zjz.common.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestDoc {

	public void transDoc(File mainFile) {
		// File mainFile=new File("E:\\Documents\\XMusic");
		File[] files = mainFile.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {// 目录
				transDoc(file);// 递归
			} else if (StringUtils.containsIgnoreCase(file.getName(), "AVI")) {
				File destFile = new File("E:\\Documents\\Video\\thread\\" + file.getName());
				try {
					FileUtils.copyFile(file, destFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testTrans() {
		File mainFile = new File("E:\\Documents\\Video\\thread");
		transDoc(mainFile);
	}

}
