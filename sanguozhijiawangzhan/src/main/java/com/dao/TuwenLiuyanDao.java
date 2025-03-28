package com.dao;

import com.entity.TuwenLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TuwenLiuyanView;

/**
 * 三国图文评价 Dao 接口
 *
 * @author 
 */
public interface TuwenLiuyanDao extends BaseMapper<TuwenLiuyanEntity> {

   List<TuwenLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
