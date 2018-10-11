package com.xiaomuedu.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFigureProject<M extends BaseFigureProject<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setFigureId(java.lang.Integer figureId) {
		set("figureId", figureId);
	}

	public java.lang.Integer getFigureId() {
		return get("figureId");
	}

	public void setProjectId(java.lang.Integer projectId) {
		set("projectId", projectId);
	}

	public java.lang.Integer getProjectId() {
		return get("projectId");
	}

}