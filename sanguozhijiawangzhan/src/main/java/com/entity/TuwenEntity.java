package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 三国图文
 *
 * @author 
 * @email
 */
@TableName("tuwen")
public class TuwenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TuwenEntity() {

	}

	public TuwenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 三国图文名称
     */
    @ColumnInfo(comment="三国图文名称",type="varchar(200)")
    @TableField(value = "tuwen_name")

    private String tuwenName;


    /**
     * 三国图文编号
     */
    @ColumnInfo(comment="三国图文编号",type="varchar(200)")
    @TableField(value = "tuwen_uuid_number")

    private String tuwenUuidNumber;


    /**
     * 三国图文照片
     */
    @ColumnInfo(comment="三国图文照片",type="varchar(200)")
    @TableField(value = "tuwen_photo")

    private String tuwenPhoto;


    /**
     * 三国图文类型
     */
    @ColumnInfo(comment="三国图文类型",type="int(11)")
    @TableField(value = "tuwen_types")

    private Integer tuwenTypes;


    /**
     * 三国图文热度
     */
    @ColumnInfo(comment="三国图文热度",type="int(11)")
    @TableField(value = "tuwen_clicknum")

    private Integer tuwenClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 三国图文详细介绍
     */
    @ColumnInfo(comment="三国图文详细介绍",type="longtext")
    @TableField(value = "tuwen_content")

    private String tuwenContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "tuwen_delete")

    private Integer tuwenDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：三国图文名称
	 */
    public String getTuwenName() {
        return tuwenName;
    }
    /**
	 * 设置：三国图文名称
	 */

    public void setTuwenName(String tuwenName) {
        this.tuwenName = tuwenName;
    }
    /**
	 * 获取：三国图文编号
	 */
    public String getTuwenUuidNumber() {
        return tuwenUuidNumber;
    }
    /**
	 * 设置：三国图文编号
	 */

    public void setTuwenUuidNumber(String tuwenUuidNumber) {
        this.tuwenUuidNumber = tuwenUuidNumber;
    }
    /**
	 * 获取：三国图文照片
	 */
    public String getTuwenPhoto() {
        return tuwenPhoto;
    }
    /**
	 * 设置：三国图文照片
	 */

    public void setTuwenPhoto(String tuwenPhoto) {
        this.tuwenPhoto = tuwenPhoto;
    }
    /**
	 * 获取：三国图文类型
	 */
    public Integer getTuwenTypes() {
        return tuwenTypes;
    }
    /**
	 * 设置：三国图文类型
	 */

    public void setTuwenTypes(Integer tuwenTypes) {
        this.tuwenTypes = tuwenTypes;
    }
    /**
	 * 获取：三国图文热度
	 */
    public Integer getTuwenClicknum() {
        return tuwenClicknum;
    }
    /**
	 * 设置：三国图文热度
	 */

    public void setTuwenClicknum(Integer tuwenClicknum) {
        this.tuwenClicknum = tuwenClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：三国图文详细介绍
	 */
    public String getTuwenContent() {
        return tuwenContent;
    }
    /**
	 * 设置：三国图文详细介绍
	 */

    public void setTuwenContent(String tuwenContent) {
        this.tuwenContent = tuwenContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTuwenDelete() {
        return tuwenDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setTuwenDelete(Integer tuwenDelete) {
        this.tuwenDelete = tuwenDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tuwen{" +
            ", id=" + id +
            ", tuwenName=" + tuwenName +
            ", tuwenUuidNumber=" + tuwenUuidNumber +
            ", tuwenPhoto=" + tuwenPhoto +
            ", tuwenTypes=" + tuwenTypes +
            ", tuwenClicknum=" + tuwenClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", tuwenContent=" + tuwenContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", tuwenDelete=" + tuwenDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
