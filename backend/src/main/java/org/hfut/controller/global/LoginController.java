package org.hfut.controller.global;

import org.hfut.tool.global.PasswordEncryption;
import org.hfut.pojo.ProjectPeople;
import org.hfut.service.global.LoginService;
import org.hfut.tool.global.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panbaoqiang
 * @date 2019/1/15
 **/
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Map<String, Object> login(@RequestParam(name = "account") String account,
                                     @RequestParam(name = "password") String password) throws Exception {
        Map<String,Object> userMap = new HashMap<String,Object>(2){{
            put("token","");
            put("person","");
        }};
        List<ProjectPeople> projectPeopleList =(List<ProjectPeople>)loginService.getProjectPeopleByEmailOrPhone(account, false);
        if(projectPeopleList.isEmpty()){
            return userMap;
        }
        ProjectPeople projectPeople = projectPeopleList.get(0);
        String userPhone = projectPeople.getPhoneNumber();
        String userEmail = projectPeople.getEmail();
        //将获取到的password跟数据用户的email和手机号加密
        String finalCodePassword = PasswordEncryption.getPasswordEncryptionWithUserName(userPhone,userEmail,password);
        //获取实际密码
        String userPassword =projectPeople.getPassword();
        if(!finalCodePassword.equals(userPassword)){
            return userMap;
        }
        userMap.put("person", projectPeople);
        userMap.put("token", Token.getToken(projectPeople.getId(),projectPeople.getPermissions(),Token.VALIDITY_PERIOD_LOGIN));
        return userMap;
    }
}
