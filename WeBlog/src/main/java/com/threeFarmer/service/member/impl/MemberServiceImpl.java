package com.threeFarmer.service.member.impl;

import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.dao.member.IMemberDao;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    @Resource
    private IMemberDao memberDao;

    @Override
    public ResponseModel login(Member member, HttpServletRequest request) {

        Member findMember = memberDao.login(member);
        if(findMember != null){
            if(findMember.getStatus() == -1){
                return new ResponseModel(-1,"该账户已被禁用");
            }
            //登录成功更新状态
            memberDao.loginSuccess(findMember.getId());
            findMember = this.findById(findMember.getId());
            request.getSession().setAttribute("Member",findMember);
            return new ResponseModel(3,"登录成功",request.getServletContext().getContextPath()+"/member/");
        }
        return new ResponseModel(-1,"用户名或密码错误");
    }

    @Override
    public Member findById(int id) {
        return memberDao.findById(id);
    }

}
