package com.hospital.service.impl;

import com.hospital.dao.NoticeDao;
import com.hospital.entity.Notice;
import com.hospital.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> getNotice(int accountId, int type, int status) {
        List<Notice> list = noticeDao.getNotice(accountId);
        if (type == -2 && status == -2)
            return list;

        List<Notice> res = new ArrayList<>();
        for(Notice notice : list) {
            if ((notice.getNoticeType() == type || type == -2) && (status == -2 || notice.getStatus() == status)){
                res.add(notice);
            }
        }
        return res;
    }

    @Override
    public void addNotice(int noticeType, int accountId, String start, String end, String frequency) {
        noticeDao.addNotice(noticeType, accountId, start, end, frequency);
    }

    @Override
    public void updateNotice(int noticeId, int noticeType, String start, String end, String frequency) {
        noticeDao.updateNotice(noticeId, noticeType, start, end, frequency);
    }

    @Override
    public void delNotice(int noticeId) {
        noticeDao.delNotice(noticeId);
    }


}
