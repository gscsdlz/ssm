package com.hospital.dao;

import com.hospital.entity.ElderUser;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.apache.ibatis.annotations.Param;

public interface ElderUserDao {
    boolean addUser(int accountId);

    ElderUser getElderUser(@Param("account_id") int accountId);

    int updateElderUser(@Param("account_id") int accountId,
                        @Param("realname") String realname,
                        @Param("gender") int gender,
                        @Param("birth") String birth,
                        @Param("address") String address,
                        @Param("phone") String phone,
                        @Param("id_card") String idCard,
                        @Param("ss_id") String ssId,
                        @Param("has_allergy") int v1,
                        @Param("has_trauma") int v2,
                        @Param("has_operation") int v3,
                        @Param("has_inheritance") int v4
                        );
}
