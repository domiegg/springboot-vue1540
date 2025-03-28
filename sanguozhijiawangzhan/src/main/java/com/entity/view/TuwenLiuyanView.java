package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TuwenLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 三国图文评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tuwen_liuyan")
public class TuwenLiuyanView extends TuwenLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 三国图文
		/**
		* 三国图文名称
		*/

		@ColumnInfo(comment="三国图文名称",type="varchar(200)")
		private String tuwenName;
		/**
		* 三国图文编号
		*/

		@ColumnInfo(comment="三国图文编号",type="varchar(200)")
		private String tuwenUuidNumber;
		/**
		* 三国图文照片
		*/

		@ColumnInfo(comment="三国图文照片",type="varchar(200)")
		private String tuwenPhoto;
		/**
		* 三国图文类型
		*/
		@ColumnInfo(comment="三国图文类型",type="int(11)")
		private Integer tuwenTypes;
			/**
			* 三国图文类型的值
			*/
			@ColumnInfo(comment="三国图文类型的字典表值",type="varchar(200)")
			private String tuwenValue;
		/**
		* 三国图文热度
		*/

		@ColumnInfo(comment="三国图文热度",type="int(11)")
		private Integer tuwenClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 三国图文详细介绍
		*/

		@ColumnInfo(comment="三国图文详细介绍",type="longtext")
		private String tuwenContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer tuwenDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public TuwenLiuyanView() {

	}

	public TuwenLiuyanView(TuwenLiuyanEntity tuwenLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, tuwenLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 三国图文

		/**
		* 获取： 三国图文名称
		*/
		public String getTuwenName() {
			return tuwenName;
		}
		/**
		* 设置： 三国图文名称
		*/
		public void setTuwenName(String tuwenName) {
			this.tuwenName = tuwenName;
		}

		/**
		* 获取： 三国图文编号
		*/
		public String getTuwenUuidNumber() {
			return tuwenUuidNumber;
		}
		/**
		* 设置： 三国图文编号
		*/
		public void setTuwenUuidNumber(String tuwenUuidNumber) {
			this.tuwenUuidNumber = tuwenUuidNumber;
		}

		/**
		* 获取： 三国图文照片
		*/
		public String getTuwenPhoto() {
			return tuwenPhoto;
		}
		/**
		* 设置： 三国图文照片
		*/
		public void setTuwenPhoto(String tuwenPhoto) {
			this.tuwenPhoto = tuwenPhoto;
		}
		/**
		* 获取： 三国图文类型
		*/
		public Integer getTuwenTypes() {
			return tuwenTypes;
		}
		/**
		* 设置： 三国图文类型
		*/
		public void setTuwenTypes(Integer tuwenTypes) {
			this.tuwenTypes = tuwenTypes;
		}


			/**
			* 获取： 三国图文类型的值
			*/
			public String getTuwenValue() {
				return tuwenValue;
			}
			/**
			* 设置： 三国图文类型的值
			*/
			public void setTuwenValue(String tuwenValue) {
				this.tuwenValue = tuwenValue;
			}

		/**
		* 获取： 三国图文热度
		*/
		public Integer getTuwenClicknum() {
			return tuwenClicknum;
		}
		/**
		* 设置： 三国图文热度
		*/
		public void setTuwenClicknum(Integer tuwenClicknum) {
			this.tuwenClicknum = tuwenClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 三国图文详细介绍
		*/
		public String getTuwenContent() {
			return tuwenContent;
		}
		/**
		* 设置： 三国图文详细介绍
		*/
		public void setTuwenContent(String tuwenContent) {
			this.tuwenContent = tuwenContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getTuwenDelete() {
			return tuwenDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTuwenDelete(Integer tuwenDelete) {
			this.tuwenDelete = tuwenDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "TuwenLiuyanView{" +
			", tuwenName=" + tuwenName +
			", tuwenUuidNumber=" + tuwenUuidNumber +
			", tuwenPhoto=" + tuwenPhoto +
			", tuwenClicknum=" + tuwenClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", tuwenContent=" + tuwenContent +
			", tuwenDelete=" + tuwenDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
