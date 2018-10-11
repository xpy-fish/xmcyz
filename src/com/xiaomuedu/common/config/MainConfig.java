package com.xiaomuedu.common.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.xiaomuedu.common.model._MappingKit;

public class MainConfig extends JFinalConfig {
	/**
	 * 配置JFinal常量
	 */
	@Override
	public void configConstant(Constants me) {
		//读取数据库配置文件
		PropKit.use("config.properties");
		//设置当前是否为开发模式
		me.setDevMode(PropKit.getBoolean("devMode"));
		//设置默认上传文件保存路径 getFile等使用
		me.setBaseUploadPath("upload");
		//设置上传最大限制尺寸
		//me.setMaxPostSize(1024*1024*10);
		//设置默认下载文件路径 renderFile使用
		//me.setBaseDownloadPath("");
		//设置默认视图类型
		//me.setViewType(ViewType.JSP);
		//设置404渲染视图
		//me.setError404View("404.html");
		//配置JSON第三方 fastJson
		me.setJsonFactory(FastJsonFactory.me());
		
	}
	/**
	 * 配置JFinal路由映射
	 */
	@Override
	public void configRoute(Routes me) {
		me.add(new AdminRoutes());
	}
	/**
	 * 配置JFinal插件
	 * 数据库连接池
	 * ORM
	 * 缓存等插件
	 * 自定义插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		//配置数据库连接池插件
		DruidPlugin druidPlugin=new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		//orm映射 配置ActiveRecord插件
		ActiveRecordPlugin arp=new ActiveRecordPlugin(druidPlugin);
		arp.setShowSql(PropKit.getBoolean("devMode"));
		arp.setDialect(new MysqlDialect());
		/********在此添加数据库 表-Model 映射*********/
		_MappingKit.mapping(arp);
		//TODO #小木 缓存配置
		//添加到插件列表中
		me.add(druidPlugin);
		me.add(arp);
	}
	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}
	/**
	 * 配置全局处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new BasePathHandler());
	}
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
	@Override
	public void configEngine(Engine me) {
		//配置模板引擎 
		me.addSharedFunction("/WEB-INF/view/admin/common/innerlayout.html");
		me.addSharedFunction("/WEB-INF/view/admin/common/layerformlayout.html");
	}
	

}
