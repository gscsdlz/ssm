package com.hospital.dao;

import com.hospital.entity.Complaint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintDao {
    List<Complaint> getAllComplaintByHandle(@Param("handle") int handle);

    List<Complaint> getAllCompalint();

    int updateComplaint(@Param("complaint_id") int complaintId, @Param("handle") int handle, @Param("handle_time") String handleTime, @Param("handle_content") String handleContent);

    int delComplaint(@Param("complaint_id") int complaintId);
}
