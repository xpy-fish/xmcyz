package com.xmcyz.admin.user;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.xiaomuedu.common.model.User;

public class UserFormValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateEmail("user.email", "emailmsg", "Email格式不正确");
		Integer id=c.getParaToInt("user.id");
		if(id==null||id<=0){
			validateRequiredString("user.password", "passwordmsg", "密码不能为空");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(User.class,"user");
		c.render("form.html");
	}

}
