package com.mtl.common.ueditor.upload;

import com.mtl.common.ueditor.define.AppInfo;
import com.mtl.common.ueditor.define.BaseState;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="nginx")
public class StorageManager {
	public static final int BUFFER_SIZE = 8192;
	
	private static String fileurl;

	public static String getFileurl() {
		return fileurl;
	}

	public static void setFileurl(String fileurl) {
		StorageManager.fileurl = fileurl;
	}

	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public StorageManager() {
	}

	public static Map<String, Object> saveBinaryFile(byte[] data, String path) {
		File file = new File(path);

		Map<String, Object> state = valid(file);

		if (!state.get("state").equals("SUCCESS")) {
			return state;
		}

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			bos.write(data);
			bos.flush();
			bos.close();
		} catch (IOException ioe) {
			return BaseState.create(false, AppInfo.IO_ERROR);
		}

		state = BaseState.create(true, file.getAbsolutePath());
		state.put( "size", data.length );
		state.put( "title", file.getName() );
		return state;
	}

	public static Map<String, Object> saveFileByInputStream(HttpServletRequest request, InputStream is, String path, String picName,
                                                            long maxSize) {
		
		Map<String, Object> state = null;
		File tmpFile = getTmpFile();
		byte[] dataBuf = new byte[ 2048 ];

		try {
			//转成字节流
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
	        int rc = 0;  
	        while ((rc = is.read(dataBuf, 0, 100)) > 0) {  
	            swapStream.write(dataBuf, 0, rc);  
	        }
	        
	        dataBuf = swapStream.toByteArray();
	        swapStream.flush();
	        swapStream.close();

			if (tmpFile.length() > maxSize) {
				tmpFile.delete();
				return BaseState.create(false, AppInfo.MAX_SIZE);
			}
			//调用DFS的存储服务上传文件
			//:TODO
			/**
			 * 此处调用文件上传服务，并获取返回结果返回
			 */
//			UploadResult result = baseFileService.upload(dataBuf, picName, "OM", null);
			
			boolean success = true;
			//如果上传成功
			if (success) {
				state = BaseState.create(true);
				state.put( "size", tmpFile.length() );
				state.put( "title", "");//文件名填入此处
				state.put( "group", "");//所属group填入此处
				state.put( "url", "");//文件访问的url填入此处
				tmpFile.delete();
			}else{
				state = BaseState.create(false, 4);
				tmpFile.delete();
			}

			return state;
			
		} catch (IOException e) {
		}
		return BaseState.create(false, AppInfo.IO_ERROR);
	}

	public static Map<String, Object> saveFileByInputStream(InputStream is, String path, String picName) {
		Map<String, Object> state = null;

		File tmpFile = getTmpFile();

		byte[] dataBuf = new byte[ 2048 ];
		BufferedInputStream bis = new BufferedInputStream(is, StorageManager.BUFFER_SIZE);

		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(tmpFile), StorageManager.BUFFER_SIZE);

			int count = 0;
			while ((count = bis.read(dataBuf)) != -1) {
				bos.write(dataBuf, 0, count);
			}
			bos.flush();
			bos.close();

			//state = saveTmpFile(tmpFile, path);
			//重新将文件转成文件流的方式
//			InputStream in = new FileInputStream(tmpFile);
//			UploadUtils uploadUtils = new UploadUtils();
//			boolean success = uploadUtils.uploadFile(in, path, picName);
			boolean success = true;
			
			//如果上传成功
			if (success) {
				state = BaseState.create(true);
				state.put( "size", tmpFile.length() );
				state.put( "title", tmpFile.getName() );
				tmpFile.delete();
			}else{
				state = BaseState.create(false, 4);
				tmpFile.delete();
			}

			return state;
		} catch (IOException e) {
		}
		return BaseState.create(false, AppInfo.IO_ERROR);
	}

	private static File getTmpFile() {
		File tmpDir = FileUtils.getTempDirectory();
		String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
		return new File(tmpDir, tmpFileName);
	}

	private static Map<String, Object> saveTmpFile(File tmpFile, String path) {
		Map<String, Object> state = null;
		File targetFile = new File(path);

		if (targetFile.canWrite()) {
			return BaseState.create(false, AppInfo.PERMISSION_DENIED);
		}
		try {
			FileUtils.moveFile(tmpFile, targetFile);
		} catch (IOException e) {
			return BaseState.create(false, AppInfo.IO_ERROR);
		}

		state = BaseState.create(true);
		state.put( "size", targetFile.length() );
		state.put( "title", targetFile.getName() );
		
		return state;
	}

	private static Map<String, Object> valid(File file) {
		File parentPath = file.getParentFile();

		if ((!parentPath.exists()) && (!parentPath.mkdirs())) {
			return BaseState.create(false, AppInfo.FAILED_CREATE_FILE);
		}

		if (!parentPath.canWrite()) {
			return BaseState.create(false, AppInfo.PERMISSION_DENIED);
		}

		return BaseState.create(true);
	}
}
