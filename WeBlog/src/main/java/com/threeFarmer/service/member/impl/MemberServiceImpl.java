package com.threeFarmer.service.member.impl;

import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.core.utils.Md5Util;
import com.threeFarmer.dao.member.IMemberDao;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    @Resource
    private IMemberDao memberDao;

    @Override
    public ResponseModel login(Member member, HttpServletRequest request) {
        String password = member.getPassword();
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
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

    @Override
    @Transactional
    public ResponseModel register(Member member, HttpServletRequest request) {
        Member m =memberDao.findByName(member.getName());
        if(memberDao.findByName(member.getName()) != null){
            return new ResponseModel(-1,"该用户名已被注册");
        }
        if(memberDao.findByEmail(member.getEmail()) != null){
            return new ResponseModel(-1,"该邮箱已被注册");
        }
        //加密密码
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        //member.setPassword(member.getPassword());
        if(memberDao.register(member) == 1){

            return new ResponseModel(2,"注册成功",request.getServletContext().getContextPath()+"/member/login");
        }
        return new ResponseModel(-1,"注册失败");
    }

    @Override
    public Member findByName(String name) {
        return memberDao.findByName(name);
    }
    @Override
    public Member findByNameAndEmail(String name, String email) {
        return memberDao.findByNameAndEmail(name, email);
    }

    @Override
    public Member manageLogin(Member member, HttpServletRequest request) {
        //System.out.print("--------------------------------------------------------");
        String password = member.getPassword();
        member.setPassword(Md5Util.getMD5Code(member.getPassword()));
        Member findMember = memberDao.manageLogin(member);
        if(findMember != null){
            //登录成功更新状态
            memberDao.loginSuccess(findMember.getId());
            findMember = this.findById(findMember.getId());
        }/*else {
            actionLogService.save(IpUtil.getIpAddress(request),null,ActionUtil.MEMBER_LOGIN_ERROR,"登录用户名："+member.getName()+"，登录密码："+password);
        }*/
        return findMember;
    }

    @Override
    public ResponseModel update(Member member) {
        if(memberDao.update(member) == 1){
            return new ResponseModel(3,"更新成功");
        }
        return new ResponseModel(-1,"更新失败");
    }

    @Override
    public ResponseModel delete(int id) {
        if(memberDao.delete(id) == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public ResponseModel forgetpwd(String name, String email, HttpServletRequest request) {
        Member member = this.findByNameAndEmail(name,email);
        if(member == null){
            return new ResponseModel(-1,"会员不存在");
        }
       /* String randomCode = RandomCodeUtil.uuid();
        ValidateCode validateCode = new ValidateCode(email,randomCode,1);
        if(validateCodeService.save(validateCode)){
            if(EmailSendUtil.forgetpwd(request, email,randomCode)){
                return new ResponseModel(0,"邮件发送成功");
            }
        }*/
        return new ResponseModel(-1,"邮件发送失败，请重试");
    }

    @Transactional
    @Override
    public ResponseModel resetpwd(String email,String token,String password, HttpServletRequest request) {
        Member member = memberDao.findByEmail(email);
        if (member == null) {
            return new ResponseModel(-1, "会员不存在");
        }
        /*ValidateCode validateCode = validateCodeService.valid(email,token,1);
        if(validateCode == null){
            return new ResponseModel(-1,"验证码错误");
        }*/
        password = Md5Util.getMD5Code(password);
        if (memberDao.changepwd(member.getId(), password) == 1) {
                //0 validateCodeService.used(validateCode.getId());
                //actionLogService.save(IpUtil.getIpAddress(request),member.getId(), ActionUtil.FIND_PWD);
            return new ResponseModel(2, "密码重置成功", request.getContextPath() + "/member/login");
        }

        return new ResponseModel(-1, "密码重置失败");
    }
}
