package com.bootdo.api.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 坐标工具类
 * @author geyy
 * @date 2018年6月7日 下午5:12:05
 */
public class PositionUtil {

	/** 
	 * 查询附近坐标最大最小经纬度map集合 
	 * @param longitude 经度，范围为-180~180，负数表示西经 
	 * @param latitude  纬度，范围为-90~90，负数表示南纬 
	 * @param distance  搜索范围(单位:千米)   
	 * @return  最大最小经纬度map集合，minlat、maxlat、minlng、maxlng
	 */ 
	public static Map<String, Object> findNeighPosition(float longitude, float latitude, double distance){
		//先计算查询点的经纬度范围
        double r = 6371;//地球半径千米
        double dis = distance;//范围(单位:千米)
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = dis/r;
        dlat = dlat*180/Math.PI;        
        double minlat =latitude-dlat;//最小维度
        double maxlat = latitude+dlat;//最大维度
        double minlng = longitude -dlng;//最小经度
        double maxlng = longitude + dlng;//最大经度

        Map<String, Object> map = new HashMap<>();
		map.put("minlat", minlat);
		map.put("maxlat", maxlat);
		map.put("minlng", minlng);
		map.put("maxlng", maxlng);
		
		System.out.println(longitude+"-"+latitude);
		System.out.println(minlat+"-"+maxlat);
		System.out.println(minlng+"-"+maxlng);
		
		return map;
	}
}
