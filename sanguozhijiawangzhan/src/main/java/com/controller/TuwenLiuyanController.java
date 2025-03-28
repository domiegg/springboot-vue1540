
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 三国图文评价
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tuwenLiuyan")
public class TuwenLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(TuwenLiuyanController.class);

    private static final String TABLE_NAME = "tuwenLiuyan";

    @Autowired
    private TuwenLiuyanService tuwenLiuyanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ExampaperService exampaperService;//试卷
    @Autowired
    private ExampapertopicService exampapertopicService;//试卷选题
    @Autowired
    private ExamquestionService examquestionService;//试题表
    @Autowired
    private ExamrecordService examrecordService;//考试记录表
    @Autowired
    private ExamredetailsService examredetailsService;//答题详情表
    @Autowired
    private ExamrewrongquestionService examrewrongquestionService;//错题表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ShipinService shipinService;//三国视频
    @Autowired
    private ShipinCollectionService shipinCollectionService;//三国视频收藏
    @Autowired
    private ShipinLiuyanService shipinLiuyanService;//三国视频评价
    @Autowired
    private TuwenService tuwenService;//三国图文
    @Autowired
    private TuwenCollectionService tuwenCollectionService;//三国图文收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZixunService zixunService;//三国资讯
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = tuwenLiuyanService.queryPage(params);

        //字典表数据转换
        List<TuwenLiuyanView> list =(List<TuwenLiuyanView>)page.getList();
        for(TuwenLiuyanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuwenLiuyanEntity tuwenLiuyan = tuwenLiuyanService.selectById(id);
        if(tuwenLiuyan !=null){
            //entity转view
            TuwenLiuyanView view = new TuwenLiuyanView();
            BeanUtils.copyProperties( tuwenLiuyan , view );//把实体数据重构到view中
            //级联表 三国图文
            //级联表
            TuwenEntity tuwen = tuwenService.selectById(tuwenLiuyan.getTuwenId());
            if(tuwen != null){
            BeanUtils.copyProperties( tuwen , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTuwenId(tuwen.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tuwenLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TuwenLiuyanEntity tuwenLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuwenLiuyan:{}",this.getClass().getName(),tuwenLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tuwenLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        tuwenLiuyan.setCreateTime(new Date());
        tuwenLiuyan.setInsertTime(new Date());
        tuwenLiuyanService.insert(tuwenLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuwenLiuyanEntity tuwenLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tuwenLiuyan:{}",this.getClass().getName(),tuwenLiuyan.toString());
        TuwenLiuyanEntity oldTuwenLiuyanEntity = tuwenLiuyanService.selectById(tuwenLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            tuwenLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        tuwenLiuyan.setUpdateTime(new Date());

            tuwenLiuyanService.updateById(tuwenLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TuwenLiuyanEntity> oldTuwenLiuyanList =tuwenLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tuwenLiuyanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<TuwenLiuyanEntity> tuwenLiuyanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TuwenLiuyanEntity tuwenLiuyanEntity = new TuwenLiuyanEntity();
//                            tuwenLiuyanEntity.setTuwenId(Integer.valueOf(data.get(0)));   //三国图文 要改的
//                            tuwenLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tuwenLiuyanEntity.setTuwenLiuyanText(data.get(0));                    //评价内容 要改的
//                            tuwenLiuyanEntity.setInsertTime(date);//时间
//                            tuwenLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            tuwenLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            tuwenLiuyanEntity.setCreateTime(date);//时间
                            tuwenLiuyanList.add(tuwenLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tuwenLiuyanService.insertBatch(tuwenLiuyanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = tuwenLiuyanService.queryPage(params);

        //字典表数据转换
        List<TuwenLiuyanView> list =(List<TuwenLiuyanView>)page.getList();
        for(TuwenLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuwenLiuyanEntity tuwenLiuyan = tuwenLiuyanService.selectById(id);
            if(tuwenLiuyan !=null){


                //entity转view
                TuwenLiuyanView view = new TuwenLiuyanView();
                BeanUtils.copyProperties( tuwenLiuyan , view );//把实体数据重构到view中

                //级联表
                    TuwenEntity tuwen = tuwenService.selectById(tuwenLiuyan.getTuwenId());
                if(tuwen != null){
                    BeanUtils.copyProperties( tuwen , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTuwenId(tuwen.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tuwenLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TuwenLiuyanEntity tuwenLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tuwenLiuyan:{}",this.getClass().getName(),tuwenLiuyan.toString());
        tuwenLiuyan.setCreateTime(new Date());
        tuwenLiuyan.setInsertTime(new Date());
        tuwenLiuyanService.insert(tuwenLiuyan);

            return R.ok();
        }

}

