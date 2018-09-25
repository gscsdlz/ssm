package com.hospital.service;

import com.hospital.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNotice(int accountId, int type, int status);
}
