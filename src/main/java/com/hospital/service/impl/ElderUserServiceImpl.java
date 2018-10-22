package com.hospital.service.impl;

import com.hospital.dao.ElderUserDao;
import com.hospital.entity.ElderUser;
import com.hospital.service.ElderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderUserServiceImpl implements ElderUserService {

    @Autowired
    private ElderUserDao elderUserDao;

    @Override
    public int addElderUser(int accountId, String realname) {
        return elderUserDao.addElderUser(accountId, realname);
    }

    @Override
    public ElderUser getElderUser(int accountId) {
        return elderUserDao.getElderUser(accountId);
    }

    @Override
    public int updateUser(ElderUser user) {
        return elderUserDao.updateElderUser(
                user.getAccountId(),
                user.getRealname(),
                user.getGenderInt(),
                user.getAge(),
                user.getAddress(),
                user.getPhone(),
                user.getIdCard(),
                user.getSsId(),
                user.getHasAllergy().equals("有") ? 1 : 0,
                user.getHasTrauma().equals("有") ? 1 : 0,
                user.getHasOperation().equals("有") ? 1 : 0,
                user.getHasInheritance().equals("有") ? 1 : 0);
    }

    @Override
    public List<ElderUser> getElderUserByRealnameOrPhone(String realname, String phone) {
        return elderUserDao.getElderUserByRealnameOrPhone(realname, phone);
    }

    @Override
    public ElderUser getElderUserByIdCard(String idCard) {
        return elderUserDao.getElderUserByIdCard(idCard);
    }

    @Override
    public List<ElderUser> getAllElderUser() {
        return elderUserDao.getAllElderUser();
    }
}
