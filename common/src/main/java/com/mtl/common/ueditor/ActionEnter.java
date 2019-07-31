package com.mtl.common.ueditor;

import com.mtl.common.ueditor.define.ActionMap;
import com.mtl.common.ueditor.define.AppInfo;
import com.mtl.common.ueditor.define.BaseState;
import com.mtl.common.ueditor.hunter.FileManager;
import com.mtl.common.ueditor.hunter.ImageHunter;
import com.mtl.common.ueditor.upload.Uploader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionEnter {
	
//	private SysOssService sysOssService;
	
	private HttpServletRequest request = null;

	private String actionType = null;
	
	private ConfigManager configManager = null;

	public ActionEnter (HttpServletRequest request) {
		this.request = request;
		this.actionType = request.getParameter( "action" );
		this.configManager = ConfigManager.getInstance();
	}
	
	public Object exec () {
		
		String callbackName = this.request.getParameter("callback");
		if ( callbackName != null ) {

			if ( !validCallbackName( callbackName ) ) {
				return BaseState.create( false, AppInfo.ILLEGAL );
			}
			
			return this.invoke();
			
		} else {
			return this.invoke();
		}

	}
	
	public Object invoke(){
		
		if ( actionType == null || !ActionMap.mapping.containsKey( actionType ) ) {
			return BaseState.create( false, AppInfo.INVALID_ACTION );
		}
		
		if ( this.configManager == null || !this.configManager.valid() ) {
			return BaseState.create( false, AppInfo.CONFIG_ERROR );
		}
		
		Map<String, Object> state = null;
		
		int actionCode = ActionMap.getType( this.actionType );
		Map<String, Object> conf = null;
		
		switch ( actionCode ) {
		
			case ActionMap.CONFIG:
				return this.configManager.getAllConfig();
				
			case ActionMap.UPLOAD_IMAGE:
			case ActionMap.UPLOAD_SCRAWL:
			case ActionMap.UPLOAD_VIDEO:
			case ActionMap.UPLOAD_FILE:
				conf = this.configManager.getConfig( actionCode );
				state = new Uploader( request, conf ).doExec();
				break;
				
			case ActionMap.CATCH_IMAGE:
				conf = configManager.getConfig( actionCode );
				String[] list = this.request.getParameterValues( (String)conf.get( "fieldName" ) );
				state = new ImageHunter( conf ).capture( list );
				break;
				
			case ActionMap.LIST_IMAGE:
				int start=this.getStartIndex();
				String size=request.getParameter("size");
				Map<String, Object> param=new HashMap<>();
				param.put("offset",start);
				param.put("limit", Integer.valueOf(size));
//				List<SysOssEntity> sysOssList = sysOssService.queryList(param);
				state=BaseState.create(true,AppInfo.SUCCESS);
				List<Map<String, Object>> imgs=new ArrayList<>();
				state.put("list", imgs);
				state.put("start", start);
//				state.put("total", sysOssService.queryTotal());
//				for (SysOssEntity oss : sysOssList) {
//					Map<String, Object> s=new HashMap<>();
//					s.put("id", oss.getId());
//					s.put("url", oss.getUrl());
//					SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//					s.put("create_date", sdf.format(oss.getCreateTime()));
//					imgs.add(s);
//				}
				break;
			case ActionMap.LIST_FILE:
				conf = configManager.getConfig( actionCode );
				start = this.getStartIndex();
				state = new FileManager( conf ).listFile( start );
				break;
				
		}
		
		return state;
		
	}
	
	public int getStartIndex () {
		
		String start = this.request.getParameter( "start" );
		
		try {
			return Integer.parseInt( start );
		} catch ( Exception e ) {
			return 0;
		}
		
	}
	
	/**
	 * callback参数验证
	 */
	public boolean validCallbackName ( String name ) {
		
		if ( name.matches( "^[a-zA-Z_]+[\\w0-9_]*$" ) ) {
			return true;
		}
		
		return false;
		
	}
	
}