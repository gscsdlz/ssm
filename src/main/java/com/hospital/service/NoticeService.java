package com.hospital.service;

import com.hospital.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNotice(int accountId, int type, int status);

    void addNotice(int noticeType, int accountId, String start, String end, String frequency);

    void updateNotice(int noticeId, int noticeType, String start, String end, String frequency);

    void delNotice(int noticeId);
}
