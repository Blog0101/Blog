package com.threeFarmer.service.member;

import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.Member;

import javax.servlet.http.HttpServletRequest;

public interface IMemberService {

    /**
     * 会员登录
     * @param member
     * @param request
     * @return
     */
    ResponseModel login(Member member, HttpServletRequest request);

    Member findById(int id);

    ResponseModel register(Member member, HttpServletRequest request);
    Member findByName(String name);
    Member findByNameAndEmail(String name, String email);
    Member manageLogin(Member member, HttpServletRequest request);
    ResponseModel update(Member member);

    ResponseModel delete(int id);


    ResponseModel forgetpwd(String name, String email, HttpServletRequest request);

    ResponseModel resetpwd(String email, String token, String password, HttpServletRequest request);



}
