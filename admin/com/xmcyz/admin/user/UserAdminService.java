package com.xmcyz.admin.user;

import java.util.Date;

import com.jfinal.ext.interceptor.Restful;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.xiaomuedu.common.model.User;

public class UserAdminService {
	public static final UserAdminService me=new UserAdminService();
	private static final User dao = new User().dao();
	
	public Page<User> paginate(int pageNumber, int pageSize,String keywords,Boolean enable){
		StringBuilder where=new StringBuilder();
		if(enable!=null){
			where.append(" enable = ").append(enable);
		}
		if(StrKit.notBlank(keywords)){
			if(enable!=null){
				where.append(" and ");
			}
			
			where.append(" (")
			.append("username like '%")
			.append(keywords)
			.append("%'")
			.append(" or ")
			.append("realname like '%")
			.append(keywords)
			.append("%'")
			.append(" or ")
			.append("phone like '%")
			.append(keywords)
			.append("%'")
			.append(" or ")
			.append("email like '%")
			.append(keywords)
			.append("%'")
			.append(") ");
			
		}
		if(where.length()>0){
			where.insert(0, "from user where");
			where.append(" order by id desc");
		}else{
			where.append("from user order by id desc");
		}
		return dao.paginate(pageNumber, pageSize, "select id,username,realname,phone,email,enable,createTime", where.toString());
	}

	public boolean doSubmit(User user) {
		if(user.getId()==null||user.getId()<=0){
			return save(user);
		}else{
			return update(user);
		}
	}

	private boolean update(User user) {
		
		user.setUpdateTime(new Date());
		return user.update();
	}

	private boolean save(User user) {
		
		user.setCreateTime(new Date());
		user.setEnable(true);
		return user.save();
	}

	public User getById(Integer id) {
		return dao.findById(id);
	}

	public Ret delById(Integer id) {
		boolean success=dao.deleteById(id);
		if(success){
			return Ret.ok();
		}else{
			return Ret.fail();
		}
	}

	public Ret doToggleEnable(Integer id) {
		 int count=Db.update("update user set enable=(!enable) where id=?",id);
		 if(count==1){
				return Ret.ok();
			}else{
				return Ret.fail();
			}
	}
}
