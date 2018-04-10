package com.threeFarmer.controller.member;

import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller("memberIndexController")
@RequestMapping("/member")
public class MemberController extends BaseController{
    private static final String MEMBER_FTL_PATH = "/member/";
    @Resource
    private IMemberService memberService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model,@RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){

        System.out.println(1);
        Member loginMember = (Member) request.getSession().getAttribute("Member");
        if(loginMember != null){
            return "redirect:/member/";
        }
        model.addAttribute("redirectUrl",redirectUrl);
        return MEMBER_FTL_PATH + "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Member> login(Member member, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){
        System.out.println(0);
        ResponseModel responseModel = memberService.login(member,request);
        if (redirectUrl != null && !"".equals(redirectUrl) && responseModel.getCode() >= 0){
            responseModel.setCode(3);
            responseModel.setUrl(redirectUrl);
        }
        return responseModel;
    }
}
