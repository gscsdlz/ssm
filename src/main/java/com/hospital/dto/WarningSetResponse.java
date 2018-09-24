package com.hospital.dto;

import com.hospital.entity.Warning;

import java.util.List;
import java.util.Map;

public class WarningSetResponse extends NormalResponse{
    private List<Warning> data;
    private int currentPage;
    private int totalPage;
    private Map<String, String> selectMap;

    public void setSelectMap(Map<String, String> selectMap) {
        this.selectMap = selectMap;
    }

    public Map<String, String> getSelectMap() {
        return selectMap;
    }


    public void setData(List<Warning> data) {
        this.data = data;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Warning> getData() {
        return data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
