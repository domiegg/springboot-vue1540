package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.TuwenLiuyanDao;
import com.entity.TuwenLiuyanEntity;
import com.service.TuwenLiuyanService;
import com.entity.view.TuwenLiuyanView;

/**
 * 三国图文评价 服务实现类
 */
@Service("tuwenLiuyanService")
@Transactional
public class TuwenLiuyanServiceImpl extends ServiceImpl<TuwenLiuyanDao, TuwenLiuyanEntity> implements TuwenLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<TuwenLiuyanView> page =new Query<TuwenLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
