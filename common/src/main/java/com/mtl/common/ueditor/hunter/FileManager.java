package com.mtl.common.ueditor.hunter;

import com.mtl.common.ueditor.PathFormat;
import com.mtl.common.ueditor.define.AppInfo;
import com.mtl.common.ueditor.define.BaseState;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;


public class FileManager {

	private String dir = null;
	private String rootPath = null;
	private String[] allowFiles = null;
	private int count = 0;
	
	public FileManager ( Map<String, Object> conf ) {

		this.rootPath = (String)conf.get( "rootPath" );
		this.dir = this.rootPath + (String)conf.get( "dir" );
		this.allowFiles = this.getAllowFiles( conf.get("allowFiles") );
		this.count = (Integer)conf.get( "count" );
		
	}
	
	public Map<String, Object> listFile ( int index ) {
		
		File dir = new File( this.dir );
		Map<String, Object> state = null;

		if ( !dir.exists() ) {
			return BaseState.create( false, AppInfo.NOT_EXIST );
		}
		
		if ( !dir.isDirectory() ) {
			return BaseState.create( false, AppInfo.NOT_DIRECTORY );
		}
		
		Collection<File> list = FileUtils.listFiles( dir, this.allowFiles, true );
		
		if ( index < 0 || index > list.size() ) {
			state = BaseState.create( true );
		} else {
			Object[] fileList = Arrays.copyOfRange( list.toArray(), index, index + this.count );
			state = this.getState( fileList );
		}
		
		state.put( "start", index );
		state.put( "total", list.size() );
		
		return state;
		
	}
	
	private Map<String, Object> getState ( Object[] files ) {
		
		Map<String, Object> state = BaseState.create( true );
		Map<String, Object> fileState = null;
		List<Map<String, Object>> list=new ArrayList<>();
		state.put("list", list);
		File file = null;
		
		for ( Object obj : files ) {
			if ( obj == null ) {
				break;
			}
			file = (File)obj;
			fileState = BaseState.create( true );
			fileState.put( "url", PathFormat.format( this.getPath( file ) ) );
			list.add( fileState );
		}
		
		return state;
		
	}
	
	private String getPath ( File file ) {
		
		String path = file.getAbsolutePath();
		
		return path.replace( this.rootPath, "/" );
		
	}
	
	private String[] getAllowFiles ( Object fileExt ) {
		
		String[] exts = null;
		String ext = null;
		
		if ( fileExt == null ) {
			return new String[ 0 ];
		}
		
		exts = (String[])fileExt;
		
		for ( int i = 0, len = exts.length; i < len; i++ ) {
			
			ext = exts[ i ];
			exts[ i ] = ext.replace( ".", "" );
			
		}
		
		return exts;
		
	}
	
}
