package com.mtl.common.ueditor.define;

import java.util.HashMap;
import java.util.Map;

public class BaseState {

	private BaseState() {
	}

	public static Map<String, Object> create() {
		return create(true);
	}

	public static Map<String, Object> create(boolean state) {
		return create(state, null);
	}

	public static Map<String, Object> create(boolean state, String info) {
		Map<String, Object> result = new HashMap<>();
		result.put("state", info);
		return result;
	}

	public static Map<String, Object> create(boolean state, int infoCode) {
		return create(state, AppInfo.getStateInfo(infoCode));
	}
}
