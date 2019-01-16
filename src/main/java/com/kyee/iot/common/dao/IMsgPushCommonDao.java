package com.kyee.iot.common.dao;


import com.kyee.iot.common.emqMessage.PushMessage;
import com.kyee.iot.common.emqMessage.QuickMsgPushResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMsgPushCommonDao {

    /**
     * 根据消息Id和患者Id更新消息状态
     * @param messageId 消息Id
     * @param patientId 患者Id
     * @param visitId visitId
     * @param status 状态信息
     */
    void updateMsgStatus(@Param("messageId") String messageId, @Param("patientId") String patientId, @Param("visitId") String visitId, @Param("status") int status);

    /**
     * 存储消息记录
     * @param messageInfo
     */
    void saveMsgRecord(@Param("messageInfo") PushMessage messageInfo);

    QuickMsgPushResult queryRecievedResult(@Param("originId") String originId);

    String queryNurseMac(@Param("wardNo") String wardNo);
}
