package com.mtl.common.ueditor.hunter;

import com.mtl.common.ueditor.PathFormat;
import com.mtl.common.ueditor.define.AppInfo;
import com.mtl.common.ueditor.define.BaseState;
import com.mtl.common.ueditor.define.MIMEType;
import com.mtl.common.ueditor.upload.StorageManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 图片抓取器
 * @author hancong03@baidu.com
 *
 */
public class ImageHunter {

	private String filename = null;
	private String savePath = null;
	private String rootPath = null;
	private List<String> allowTypes = null;
	private long maxSize = -1;
	private String localSavePathPrefix = null;
	
	private List<String> filters = null;

	public ImageHunter ( Map<String, Object> conf ) {
		
		this.filename = (String)conf.get( "filename" );
		this.savePath = (String)conf.get( "savePath" );
		this.rootPath = (String)conf.get( "rootPath" );
		this.maxSize = (Long)conf.get( "maxSize" );
		this.allowTypes = Arrays.asList( (String[])conf.get( "allowFiles" ) );
		this.filters = Arrays.asList( (String[])conf.get( "filter" ) );
		this.localSavePathPrefix = (String) conf.get("localSavePathPrefix");
		
	}
	
	public Map<String, Object> capture ( String[] list ) {
		
		Map<String, Object> state =BaseState.create(true);
		List<Map<String, Object>> list2=new ArrayList<>();
		state.put("list", list2);
		for ( String source : list ) {
			list2.add( captureRemoteData( source ) );
		}
		
		return state;
		
	}

	public Map<String, Object> captureRemoteData ( String urlStr ) {
		
		HttpURLConnection connection = null;
		URL url = null;
		String suffix = null;
		
		try {
			url = new URL( urlStr );

			if ( !validHost( url.getHost() ) ) {
				return BaseState.create( false, AppInfo.PREVENT_HOST );
			}
			
			connection = (HttpURLConnection) url.openConnection();
		
			connection.setInstanceFollowRedirects( true );
			connection.setUseCaches( true );
		
			if ( !validContentState( connection.getResponseCode() ) ) {
				return BaseState.create( false, AppInfo.CONNECTION_ERROR );
			}
			
			suffix = MIMEType.getSuffix( connection.getContentType() );
			
			if ( !validFileType( suffix ) ) {
				return BaseState.create( false, AppInfo.NOT_ALLOW_FILE_TYPE );
			}
			
			if ( !validFileSize( connection.getContentLength() ) ) {
				return BaseState.create( false, AppInfo.MAX_SIZE );
			}
			
			String savePath = this.getPath( this.savePath, this.filename, suffix );
			String physicalPath = this.localSavePathPrefix + savePath;
			String path = physicalPath.substring(0, physicalPath.lastIndexOf("/"));
			String picName = physicalPath.substring(physicalPath.lastIndexOf("/")+1, physicalPath.length());

			Map<String, Object> state = StorageManager.saveFileByInputStream( connection.getInputStream(), path, picName );
			
			if ( state.get("state").equals("SUCCESS") ) {
				state.put( "url", null);
				state.put( "source", urlStr );
			}
			
			return state;
			
		} catch ( Exception e ) {
			return BaseState.create( false, AppInfo.REMOTE_FAIL );
		}
		
	}
	
	private String getPath ( String savePath, String filename, String suffix  ) {
		
		return PathFormat.parse( savePath + suffix, filename );
		
	}
	
	private boolean validHost ( String hostname ) {
		
		return !filters.contains( hostname );
		
	}
	
	private boolean validContentState ( int code ) {
		
		return HttpURLConnection.HTTP_OK == code;
		
	}
	
	private boolean validFileType ( String type ) {
		
		return this.allowTypes.contains( type );
		
	}
	
	private boolean validFileSize ( int size ) {
		return size < this.maxSize;
	}

	public String getRootPath() {
		return rootPath;
	}
	
}
