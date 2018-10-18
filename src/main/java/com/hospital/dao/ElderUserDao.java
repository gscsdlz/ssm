package com.hospital.dao;

import com.hospital.entity.ElderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElderUserDao {
    int addElderUser(@Param("account_id") int accountId, @Param("realname") String realname);

    ElderUser getElderUser(@Param("account_id") int accountId);

    int updateElderUser(@Param("account_id") int accountId,
                        @Param("realname") String realname,
                        @Param("gender") int gender,
                        @Param("age") int age,
                        @Param("address") String address,
                        @Param("phone") String phone,
                        @Param("id_card") String idCard,
                        @Param("ss_id") String ssId,
                        @Param("has_allergy") int v1,
                        @Param("has_trauma") int v2,
                        @Param("has_operation") int v3,
                        @Param("has_inheritance") int v4
                        );

    List<ElderUser> getElderUserByRealnameOrPhone(@Param("realname") String realname, @Param("phone") String phone);

    ElderUser getElderUserByIdCard(@Param("id_card") String id);
}
