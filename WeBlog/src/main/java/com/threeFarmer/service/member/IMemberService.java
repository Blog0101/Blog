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
}
