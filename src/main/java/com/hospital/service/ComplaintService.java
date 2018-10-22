package com.hospital.service;

import com.hospital.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    List<Complaint> getComplaint(int handle);

    int updateRows(List<String[]> updateStringList);

    List<Integer> delRows(String[] delList);

    List<Complaint> getAllComplaint();
}
