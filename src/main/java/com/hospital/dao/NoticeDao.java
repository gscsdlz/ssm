package com.hospital.dao;

import com.hospital.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeDao {
    List<Notice> getNotice(@Param("account_id") int accountId);

    int addNotice(@Param("notice_type") int noticeType,
                  @Param("account_id") int accountId,
                  @Param("start") String start,
                  @Param("end") String end,
                  @Param("frequency") String frequency);

    int updateNotice(@Param("notice_id") int NoticeId,
                  @Param("notice_type") int noticeType,
                  @Param("start") String start,
                  @Param("end") String end,
                  @Param("frequency") String frequency);

    int delNotice(@Param("notice_id") int noticeId);
}
