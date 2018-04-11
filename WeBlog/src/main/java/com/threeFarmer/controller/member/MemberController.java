package com.threeFarmer.controller.member;

import com.threeFarmer.common.MemberUtil;
import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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

    /**
     * 登陆
     * @param member
     * @param redirectUrl
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Member> login(Member member, @RequestParam(value = "redirectUrl",required = false,defaultValue = "") String redirectUrl){
        System.out.println(0);
       // System.out.print("---------------------登陆成功-----------------------------------------------------------");

        ResponseModel responseModel = memberService.login(member,request);
        if (redirectUrl != null && !"".equals(redirectUrl) && responseModel.getCode() >= 0){
            responseModel.setCode(3);
            responseModel.setUrl(redirectUrl);
        }
        return responseModel;
    }


    /**
     * 注册
     * @param member
     * @param repassword
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel register(Member member,String repassword){
      //  Map<String,String> config = configService.getConfigToMap();
       /* if("0".equals(config.get(ConfigUtil.MEMBER_REGISTER_OPEN))){
            return new ResponseModel(-1,"注册功能已关闭");
        }*/
       /* if(member == null){
            return new ResponseModel(-1,"参数错误");
        }
        if(member.getName().length() < 6){
            return new ResponseModel(-1,"用户名长度最少6位");
        }
        if(!StringUtils.checkNickname(member.getName())){
            return new ResponseModel(-1,"用户名只能由中文、字母、数字、下划线(_)或者短横线(-)组成");
        }
        if(!StringUtils.isEmail(member.getEmail())){
            return new ResponseModel(-1,"邮箱格式错误");
        }
        if(member.getPassword().length() < 6){
            return new ResponseModel(-1,"密码长度最少6位");
        }
        if(!member.getPassword().equals(repassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }*/
        return memberService.register(member,request);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        /*Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember != null){
            return "redirect:/member/";
        }*/
        return MEMBER_FTL_PATH + "/register";
    }

    @RequestMapping(value = "/forgetpwd",method = RequestMethod.GET)
    public String forgetpwd(){
        return MEMBER_FTL_PATH + "/forgetpwd";
    }

    @RequestMapping(value = "/forgetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel forgetpwd(String name,String email){
        return memberService.forgetpwd(name, email, request);
    }

    @RequestMapping(value = "/resetpwd",method = RequestMethod.GET)
    public String resetpwd(String email,String token,Model model){
        model.addAttribute("email",email);
        model.addAttribute("token",token);
        return MEMBER_FTL_PATH + "/resetpwd";
    }


    @RequestMapping(value = "/resetpwd",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel resetpwd(String email,String token,String password,String repassword){
        if(com.lxinet.jeesns.core.utils.StringUtils.isEmpty(password)){
            return new ResponseModel(-1,"新密码不能为空");
        }
        if(password.length() < 6){
            return new ResponseModel(-1,"密码不能少于6个字符");
        }
        if(!password.equals(repassword)){
            return new ResponseModel(-1,"两次密码输入不一致");
        }
        return memberService.resetpwd(email,token,password,request);
    }

}
