package com.hospital.service.impl;

import com.hospital.dao.ComplaintDao;
import com.hospital.entity.Complaint;
import com.hospital.service.ComplaintService;
import com.hospital.utils.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public List<Complaint> getComplaint(int handle) {
        return complaintDao.getAllComplaintByHandle(handle);
    }

    @Override
    public int updateRows(List<String[]> updateStringList) {
        int sum = 0;
        for(String[] args : updateStringList) {
            sum += complaintDao.updateComplaint(Integer.parseInt(args[0]), Integer.parseInt(args[4]), DateTime.dateNow(), args[5]);
        }
        return sum;
    }

    @Override
    public List<Integer> delRows(String[] delList) {
        List<Integer> res = new ArrayList<>();
        for(String id : delList) {
            complaintDao.delComplaint(Integer.parseInt(id));
            res.add(Integer.parseInt(id));
        }
        return res;
    }

    @Override
    public List<Complaint> getAllComplaint() {
        return complaintDao.getAllComplaint();
    }
}
