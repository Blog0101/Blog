package com.threeFarmer.controller.front;


import com.threeFarmer.common.MemberUtil;
import com.threeFarmer.controller.common.BaseController;
import com.threeFarmer.core.ResponseModel;
import com.threeFarmer.model.member.Member;
import com.threeFarmer.service.member.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController {

}
