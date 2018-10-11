package com.xmcyz.admin.user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.xiaomuedu.common.model.User;

public class UserAdminController extends Controller {
	static UserAdminService service=UserAdminService.me;
	public void index(){
		render("index.html");
	}
	
	public void list(){
		Integer pageSize=getParaToInt("limit",10);
		Integer offset=getParaToInt("offset",0);
		String keywords=getPara("keywords");
		Boolean enable=getParaToBoolean("enable");
		int pageNumber=offset/pageSize+1;
		Page<User> userPageData=service.paginate(pageNumber, pageSize, keywords, enable);
		
		setAttr("total", userPageData.getTotalRow());
		setAttr("rows", userPageData.getList());
		renderJson();
	}
	
	public void edit(){
		Integer id=getParaToInt(0);
		if(id!=null&&id>=0){
			setAttr("user", service.getById(id));
		}
		render("form.html");
	}
	@Before(UserFormValidator.class)
	public void submit(){
		User user=getModel(User.class,"user");
		boolean success=service.doSubmit(user);
		if(success){
			render("/WEB-INF/view/admin/common/success.html");
		}else{
			render("/WEB-INF/view/admin/common/error.html");
		}
	}
	
	public void save(){
		User user=getModel(User.class,"user");
		boolean success=service.doSubmit(user);
		renderJson(success?Ret.ok():Ret.fail());
	}
	
	
	public void del(){
		Ret ret=service.delById(getParaToInt(0));
		renderJson(ret);
	}
	
	public void toggleEnable(){
		Ret ret=service.doToggleEnable(getParaToInt(0));
		renderJson(ret);
	}
}
