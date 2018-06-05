package com.bootdo.api.commen;

import java.util.List;
import java.util.Map;

public abstract class JsonTest {

	protected final static String JSON = "json";
	protected final static String JRPOERT = "jreport";

	protected JsonModel jsonModel;
	@SuppressWarnings("rawtypes")
	protected Map reportParameters;
	@SuppressWarnings("rawtypes")
	protected List reportDataSource;

	

	/**
	 * set success message
	 * 
	 * @param message
	 */
	public String success(String message) {
		return setJsonModel(Constants.JSON_STATUS_SUCCESS, message, null);
	}


	/**
	 * set json model
	 * 
	 * @param status
	 * @param message
	 * @param data
	 */
	protected String setJsonModel(int status, String message, Object data) {
		jsonModel = getJsonModel();
		jsonModel.setStatus(status);
		jsonModel.setMessage(message);
		jsonModel.setData(data);
		return jsonModel.toString();
	}

	public JsonModel getJsonModel() {
		return jsonModel == null ? (jsonModel = new JsonModel()) : jsonModel;
	}

}
