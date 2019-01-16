package com.kyee.iot.common.dao;


import com.kyee.iot.common.emqMessage.AbstractEmqMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmqMessageDao {
    /**
     * 存储消息记录
     * @param abstractEmqMessage
     */
    void save(@Param("messageInfo") AbstractEmqMessage abstractEmqMessage);
}
