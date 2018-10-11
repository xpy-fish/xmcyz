package com.xiaomuedu.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProject<M extends BaseProject<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setLogo(java.lang.String logo) {
		set("logo", logo);
	}

	public java.lang.String getLogo() {
		return get("logo");
	}

	public void setShortdesc(java.lang.String shortdesc) {
		set("shortdesc", shortdesc);
	}

	public java.lang.String getShortdesc() {
		return get("shortdesc");
	}

	public void setAchievement(java.lang.String achievement) {
		set("achievement", achievement);
	}

	public java.lang.String getAchievement() {
		return get("achievement");
	}

	public void setSuperior(java.lang.String superior) {
		set("superior", superior);
	}

	public java.lang.String getSuperior() {
		return get("superior");
	}

	public void setPoster(java.lang.String poster) {
		set("poster", poster);
	}

	public java.lang.String getPoster() {
		return get("poster");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public void setUserId(java.lang.Integer userId) {
		set("userId", userId);
	}

	public java.lang.Integer getUserId() {
		return get("userId");
	}

	public void setCityId(java.lang.Integer cityId) {
		set("cityId", cityId);
	}

	public java.lang.Integer getCityId() {
		return get("cityId");
	}

	public void setStage(java.lang.Integer stage) {
		set("stage", stage);
	}

	public java.lang.Integer getStage() {
		return get("stage");
	}

	public void setTrade(java.lang.Integer trade) {
		set("trade", trade);
	}

	public java.lang.Integer getTrade() {
		return get("trade");
	}

}