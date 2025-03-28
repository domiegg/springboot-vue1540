package com.entity.vo;

import com.entity.TuwenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 三国图文
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tuwen")
public class TuwenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 三国图文名称
     */

    @TableField(value = "tuwen_name")
    private String tuwenName;


    /**
     * 三国图文编号
     */

    @TableField(value = "tuwen_uuid_number")
    private String tuwenUuidNumber;


    /**
     * 三国图文照片
     */

    @TableField(value = "tuwen_photo")
    private String tuwenPhoto;


    /**
     * 三国图文类型
     */

    @TableField(value = "tuwen_types")
    private Integer tuwenTypes;


    /**
     * 三国图文热度
     */

    @TableField(value = "tuwen_clicknum")
    private Integer tuwenClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 三国图文详细介绍
     */

    @TableField(value = "tuwen_content")
    private String tuwenContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "tuwen_delete")
    private Integer tuwenDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：三国图文名称
	 */
    public String getTuwenName() {
        return tuwenName;
    }


    /**
	 * 获取：三国图文名称
	 */

    public void setTuwenName(String tuwenName) {
        this.tuwenName = tuwenName;
    }
    /**
	 * 设置：三国图文编号
	 */
    public String getTuwenUuidNumber() {
        return tuwenUuidNumber;
    }


    /**
	 * 获取：三国图文编号
	 */

    public void setTuwenUuidNumber(String tuwenUuidNumber) {
        this.tuwenUuidNumber = tuwenUuidNumber;
    }
    /**
	 * 设置：三国图文照片
	 */
    public String getTuwenPhoto() {
        return tuwenPhoto;
    }


    /**
	 * 获取：三国图文照片
	 */

    public void setTuwenPhoto(String tuwenPhoto) {
        this.tuwenPhoto = tuwenPhoto;
    }
    /**
	 * 设置：三国图文类型
	 */
    public Integer getTuwenTypes() {
        return tuwenTypes;
    }


    /**
	 * 获取：三国图文类型
	 */

    public void setTuwenTypes(Integer tuwenTypes) {
        this.tuwenTypes = tuwenTypes;
    }
    /**
	 * 设置：三国图文热度
	 */
    public Integer getTuwenClicknum() {
        return tuwenClicknum;
    }


    /**
	 * 获取：三国图文热度
	 */

    public void setTuwenClicknum(Integer tuwenClicknum) {
        this.tuwenClicknum = tuwenClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：三国图文详细介绍
	 */
    public String getTuwenContent() {
        return tuwenContent;
    }


    /**
	 * 获取：三国图文详细介绍
	 */

    public void setTuwenContent(String tuwenContent) {
        this.tuwenContent = tuwenContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTuwenDelete() {
        return tuwenDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTuwenDelete(Integer tuwenDelete) {
        this.tuwenDelete = tuwenDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
