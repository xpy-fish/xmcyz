package com.xiaomuedu.common.config;

import com.jfinal.config.Routes;
import com.xmcyz.admin.index.IndexAdminController;
import com.xmcyz.admin.project.ProjectAdminController;
import com.xmcyz.admin.user.UserAdminController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/WEB-INF/view");
		add("/admin", IndexAdminController.class);
		add("/admin/user", UserAdminController.class);
		add("/admin/project", ProjectAdminController.class);
	}

}
