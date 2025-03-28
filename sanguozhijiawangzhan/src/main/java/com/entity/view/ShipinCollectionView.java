package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShipinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 三国视频收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shipin_collection")
public class ShipinCollectionView extends ShipinCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String shipinCollectionValue;

	//级联表 三国视频
		/**
		* 三国视频名称
		*/

		@ColumnInfo(comment="三国视频名称",type="varchar(200)")
		private String shipinName;
		/**
		* 三国视频编号
		*/

		@ColumnInfo(comment="三国视频编号",type="varchar(200)")
		private String shipinUuidNumber;
		/**
		* 三国视频照片
		*/

		@ColumnInfo(comment="三国视频照片",type="varchar(200)")
		private String shipinPhoto;
		/**
		* 三国视频
		*/

		@ColumnInfo(comment="三国视频",type="varchar(200)")
		private String shipinVideo;
		/**
		* 三国视频类型
		*/
		@ColumnInfo(comment="三国视频类型",type="int(11)")
		private Integer shipinTypes;
			/**
			* 三国视频类型的值
			*/
			@ColumnInfo(comment="三国视频类型的字典表值",type="varchar(200)")
			private String shipinValue;
		/**
		* 三国视频热度
		*/

		@ColumnInfo(comment="三国视频热度",type="int(11)")
		private Integer shipinClicknum;
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
		* 三国视频详细介绍
		*/

		@ColumnInfo(comment="三国视频详细介绍",type="longtext")
		private String shipinContent;
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
		private Integer shipinDelete;
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



	public ShipinCollectionView() {

	}

	public ShipinCollectionView(ShipinCollectionEntity shipinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shipinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getShipinCollectionValue() {
		return shipinCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setShipinCollectionValue(String shipinCollectionValue) {
		this.shipinCollectionValue = shipinCollectionValue;
	}


	//级联表的get和set 三国视频

		/**
		* 获取： 三国视频名称
		*/
		public String getShipinName() {
			return shipinName;
		}
		/**
		* 设置： 三国视频名称
		*/
		public void setShipinName(String shipinName) {
			this.shipinName = shipinName;
		}

		/**
		* 获取： 三国视频编号
		*/
		public String getShipinUuidNumber() {
			return shipinUuidNumber;
		}
		/**
		* 设置： 三国视频编号
		*/
		public void setShipinUuidNumber(String shipinUuidNumber) {
			this.shipinUuidNumber = shipinUuidNumber;
		}

		/**
		* 获取： 三国视频照片
		*/
		public String getShipinPhoto() {
			return shipinPhoto;
		}
		/**
		* 设置： 三国视频照片
		*/
		public void setShipinPhoto(String shipinPhoto) {
			this.shipinPhoto = shipinPhoto;
		}

		/**
		* 获取： 三国视频
		*/
		public String getShipinVideo() {
			return shipinVideo;
		}
		/**
		* 设置： 三国视频
		*/
		public void setShipinVideo(String shipinVideo) {
			this.shipinVideo = shipinVideo;
		}
		/**
		* 获取： 三国视频类型
		*/
		public Integer getShipinTypes() {
			return shipinTypes;
		}
		/**
		* 设置： 三国视频类型
		*/
		public void setShipinTypes(Integer shipinTypes) {
			this.shipinTypes = shipinTypes;
		}


			/**
			* 获取： 三国视频类型的值
			*/
			public String getShipinValue() {
				return shipinValue;
			}
			/**
			* 设置： 三国视频类型的值
			*/
			public void setShipinValue(String shipinValue) {
				this.shipinValue = shipinValue;
			}

		/**
		* 获取： 三国视频热度
		*/
		public Integer getShipinClicknum() {
			return shipinClicknum;
		}
		/**
		* 设置： 三国视频热度
		*/
		public void setShipinClicknum(Integer shipinClicknum) {
			this.shipinClicknum = shipinClicknum;
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
		* 获取： 三国视频详细介绍
		*/
		public String getShipinContent() {
			return shipinContent;
		}
		/**
		* 设置： 三国视频详细介绍
		*/
		public void setShipinContent(String shipinContent) {
			this.shipinContent = shipinContent;
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
		public Integer getShipinDelete() {
			return shipinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShipinDelete(Integer shipinDelete) {
			this.shipinDelete = shipinDelete;
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
		return "ShipinCollectionView{" +
			", shipinCollectionValue=" + shipinCollectionValue +
			", shipinName=" + shipinName +
			", shipinUuidNumber=" + shipinUuidNumber +
			", shipinPhoto=" + shipinPhoto +
			", shipinVideo=" + shipinVideo +
			", shipinClicknum=" + shipinClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", shipinContent=" + shipinContent +
			", shipinDelete=" + shipinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
