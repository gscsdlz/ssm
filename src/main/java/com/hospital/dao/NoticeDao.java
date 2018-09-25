package com.hospital.dao;

import com.hospital.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeDao {
    List<Notice> getNotice(@Param("account_id") int accountId);
}
