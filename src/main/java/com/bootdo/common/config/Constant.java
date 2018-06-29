package com.bootdo.common.config;

public class Constant {
    //演示系统账户
    public static String DEMO_ACCOUNT = "test";
    //自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    //停止计划任务
    public static String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
    public static String STATUS_RUNNING_START = "start";
    //通知公告阅读状态-未读
    public static String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
    public static int OA_NOTIFY_READ_YES = 1;
    //部门根节点id
    public static Long DEPT_ROOT_ID = 0l;
    //缓存方式
    public static String CACHE_TYPE_REDIS ="redis";

    public static String LOG_ERROR = "error";
    
    //数据状态（是否存在）
    public static final int ENABLE_EXIST = 1;
    public static final int ENABLE_DELETE = 0;
    
    //分页数据
    public static final int PAGE_LIMIT = 10;//分页查询，数据长度

    //角色身份以及id（long）
    public static final long ROLE_TEACHER = 2L;//教员身份，也是教员身份id
    public static final long ROLE_STUDENT = 3L;//学员身份，也是学员身份id
    
    //订单状态
    public static final int ORDER_STATUS_UNDO = 0;// 未处理
    public final static int ORDER_STATUS_ON = 1; // 接单中
    public final static int ORDER_STATUS_FINISH = 2; // 已完成
	public final static int ORDER_STATUS_CANCLE = 3; // 撤销
	public final static int ORDER_STATUS_DELETE = 4; // 已删除
	public final static int ORDER_STATUS_ADVANCE = 5; // 预约某人
}
