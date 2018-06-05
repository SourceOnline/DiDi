package com.bootdo.api.commen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiSupport {

	protected JsonModel json;
	@SuppressWarnings("rawtypes")
	protected Map reportParameters;
	@SuppressWarnings("rawtypes")
	protected List reportDataSource;

	/**
	 * set success message
	 * 
	 * @param message
	 */
	protected JsonModel success() {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, null, null);
	}

	/**
	 * set success message
	 * 
	 * @param message
	 */
	public JsonModel success(String message) {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, message, null);
	}

	/**
	 * set success message
	 * 
	 * @param message
	 */
	protected JsonModel success(Object data) {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, null, data);
	}

	/**
	 * set success message
	 * 
	 * @param message
	 */
	protected JsonModel successMap(String key, Object value) {
		return successMap(null, key, value);
	}

	/**
	 * 
	 * @param msg
	 * @param key
	 * @param value
	 * @return
	 */
	protected JsonModel successMap(String msg, String key, Object value) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, msg, map);
	}

	/**
	 * set success message
	 * 
	 * @param message
	 */
	protected JsonModel success(String message, Object data) {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, message, data);
	}

	/**
	 * set failure message
	 * 
	 * @param message
	 */
	protected JsonModel failure(String message) {
		return setJsonModel(Constants.JSON_STATUS_FAILURE, message, null);
	}

	/**
	 * set failure message
	 * 
	 * @param message
	 */
	protected JsonModel failure(String message, Object data) {
		return setJsonModel(Constants.JSON_STATUS_FAILURE, message, data);
	}

	/**
	 * 页面跳转
	 * 
	 * @param path
	 * @return
	 */
	protected JsonModel redirect(String path) {
		return setJsonModel(Constants.JSON_STATUS_REDIRECT, null, path);
	}

	/**
	 * set success message
	 * 
	 * @param message
	 */
	protected JsonModel json(String json) {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, null, json);
	}

	/**
	 * set json model
	 * 
	 * @param status
	 * @param message
	 * @param data
	 */
	protected JsonModel setJsonModel(int status, String message, Object data) {
		json = getJsonModel();
		json.setStatus(status);
		json.setMessage(message);
		json.setData(data);
		return json;
	}

	public JsonModel getJsonModel() {
		return json == null ? (json = new JsonModel()) : json;
	}

}
