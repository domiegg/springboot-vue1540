package com.entity.model;

import com.entity.TuwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 三国图文
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TuwenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 三国图文名称
     */
    private String tuwenName;


    /**
     * 三国图文编号
     */
    private String tuwenUuidNumber;


    /**
     * 三国图文照片
     */
    private String tuwenPhoto;


    /**
     * 三国图文类型
     */
    private Integer tuwenTypes;


    /**
     * 三国图文热度
     */
    private Integer tuwenClicknum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 三国图文详细介绍
     */
    private String tuwenContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer tuwenDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
