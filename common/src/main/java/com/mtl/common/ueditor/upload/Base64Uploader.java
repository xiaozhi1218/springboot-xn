package com.mtl.common.ueditor.upload;

import com.mtl.common.ueditor.PathFormat;
import com.mtl.common.ueditor.define.AppInfo;
import com.mtl.common.ueditor.define.FileType;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public final class Base64Uploader {
    static Logger logger = LoggerFactory.getLogger(Base64Uploader.class);
	public static Map<String, Object> save(String content, Map<String, Object> conf) {
		
		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			Map<String, Object> result=new HashMap<>();
			result.put("state",AppInfo.getStateInfo( AppInfo.MAX_SIZE));
			return result;
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		String localSavePathPrefix = PathFormat.parse((String) conf.get("localSavePathPrefix"),
                (String) conf.get("filename"));
		savePath = savePath + suffix;
		localSavePathPrefix = localSavePathPrefix + suffix;
		String physicalPath = localSavePathPrefix;
		logger.info("Base64Uploader physicalPath:{},savePath:{}",localSavePathPrefix,savePath);
		Map<String, Object> storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.get("state").equals("SUCCESS")) {
			storageState.put("url", PathFormat.format(savePath));
			storageState.put("type", suffix);
			storageState.put("original", "");
		}

		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(StringUtils.getBytesUtf8(content));
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}