package com.hospital.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Notice {
    private int noticeId;
    private int noticeType;
    private String start;
    private String end;
    private String frequency;

    public static Map<Integer, String> noticeTypes;
    static {
        noticeTypes = new HashMap<>();
        noticeTypes.put(1, "用药提醒");
        noticeTypes.put(2, "喝水提醒");
        noticeTypes.put(3, "站立提醒");
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public void setNoticeType(int noticeType) {
        this.noticeType = noticeType;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public int getNoticeType() {
        return noticeType;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    /**
     * [1 - 12], [1 - 30], [1 - 12]
     * @return List<Integer>
     */
    public List<Integer> getFrequency() {
        String[] args = frequency.split(":");
        List<Integer> res = new ArrayList<>();
        for(String s : args) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    /**
     * 返回当前提醒的时间状态
     * @return int
     */
    public int getStatus() {
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startT = new Date();
        Date endT = new Date();
        try {
            startT = format.parse(start);
            endT = format.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (now.getTime() < startT.getTime())
            return -1;
        else if (now.getTime() > endT.getTime())
            return 1;
        else
            return 0;
    }
}
