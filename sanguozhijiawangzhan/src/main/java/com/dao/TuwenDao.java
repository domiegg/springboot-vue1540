package com.dao;

import com.entity.TuwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TuwenView;

/**
 * 三国图文 Dao 接口
 *
 * @author 
 */
public interface TuwenDao extends BaseMapper<TuwenEntity> {

   List<TuwenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
