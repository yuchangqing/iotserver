package com.kyee.iot.common.domain.response;

/**
 * Created by huis on 2017/5/3.
 */
public class AccountBusinessCode {

    /**
     * 用户密码更新成功
     */
    public static final String ACCOUNT_PASSWORD_UPDATE_SUCCESS = "ACCOUNT_001";
    /**
     * 用户密码更新失败
     */
    public static final String ACCOUNT_PASSWORD_UPDATE_ERROR = "ACCOUNT_002";

    /**
     * 用户信息更新成功
     */
    public static final String ACCOUNT_EDIT_SUCCESS = "ACCOUNT_010";

    /**
     * 用户信息更新失败
     */
    public static final String ACCOUNT_EDIT_PARAM_ERROR = "ACCOUNT_011";

    /**
     * 解锁用户（重置尝试次数）成功
     * */
    public static final String ACCOUNT_UNLOCK_SUCCESS = "ACCOUNT_020";

    /**
     * 解锁用户失败
     */
    public static final String ACCOUNT_UNLOCK_FAIL = "ACCOUNT_021";
}
