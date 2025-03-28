
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
 * 三国图文
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tuwen")
public class TuwenController {
    private static final Logger logger = LoggerFactory.getLogger(TuwenController.class);

    private static final String TABLE_NAME = "tuwen";

    @Autowired
    private TuwenService tuwenService;


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
    private TuwenCollectionService tuwenCollectionService;//三国图文收藏
    @Autowired
    private TuwenLiuyanService tuwenLiuyanService;//三国图文评价
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
        params.put("tuwenDeleteStart",1);params.put("tuwenDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = tuwenService.queryPage(params);

        //字典表数据转换
        List<TuwenView> list =(List<TuwenView>)page.getList();
        for(TuwenView c:list){
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
        TuwenEntity tuwen = tuwenService.selectById(id);
        if(tuwen !=null){
            //entity转view
            TuwenView view = new TuwenView();
            BeanUtils.copyProperties( tuwen , view );//把实体数据重构到view中
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
    public R save(@RequestBody TuwenEntity tuwen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuwen:{}",this.getClass().getName(),tuwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TuwenEntity> queryWrapper = new EntityWrapper<TuwenEntity>()
            .eq("tuwen_name", tuwen.getTuwenName())
            .eq("tuwen_types", tuwen.getTuwenTypes())
            .eq("zan_number", tuwen.getZanNumber())
            .eq("cai_number", tuwen.getCaiNumber())
            .eq("shangxia_types", tuwen.getShangxiaTypes())
            .eq("tuwen_delete", tuwen.getTuwenDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuwenEntity tuwenEntity = tuwenService.selectOne(queryWrapper);
        if(tuwenEntity==null){
            tuwen.setTuwenClicknum(1);
            tuwen.setShangxiaTypes(1);
            tuwen.setTuwenDelete(1);
            tuwen.setInsertTime(new Date());
            tuwen.setCreateTime(new Date());
            tuwenService.insert(tuwen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuwenEntity tuwen, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tuwen:{}",this.getClass().getName(),tuwen.toString());
        TuwenEntity oldTuwenEntity = tuwenService.selectById(tuwen.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(tuwen.getTuwenPhoto()) || "null".equals(tuwen.getTuwenPhoto())){
                tuwen.setTuwenPhoto(null);
        }

            tuwenService.updateById(tuwen);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TuwenEntity> oldTuwenList =tuwenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TuwenEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TuwenEntity tuwenEntity = new TuwenEntity();
            tuwenEntity.setId(id);
            tuwenEntity.setTuwenDelete(2);
            list.add(tuwenEntity);
        }
        if(list != null && list.size() >0){
            tuwenService.updateBatchById(list);
        }

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
            List<TuwenEntity> tuwenList = new ArrayList<>();//上传的东西
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
                            TuwenEntity tuwenEntity = new TuwenEntity();
//                            tuwenEntity.setTuwenName(data.get(0));                    //三国图文名称 要改的
//                            tuwenEntity.setTuwenUuidNumber(data.get(0));                    //三国图文编号 要改的
//                            tuwenEntity.setTuwenPhoto("");//详情和图片
//                            tuwenEntity.setTuwenTypes(Integer.valueOf(data.get(0)));   //三国图文类型 要改的
//                            tuwenEntity.setTuwenClicknum(Integer.valueOf(data.get(0)));   //三国图文热度 要改的
//                            tuwenEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            tuwenEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            tuwenEntity.setTuwenContent("");//详情和图片
//                            tuwenEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            tuwenEntity.setTuwenDelete(1);//逻辑删除字段
//                            tuwenEntity.setInsertTime(date);//时间
//                            tuwenEntity.setCreateTime(date);//时间
                            tuwenList.add(tuwenEntity);


                            //把要查询是否重复的字段放入map中
                                //三国图文编号
                                if(seachFields.containsKey("tuwenUuidNumber")){
                                    List<String> tuwenUuidNumber = seachFields.get("tuwenUuidNumber");
                                    tuwenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tuwenUuidNumber = new ArrayList<>();
                                    tuwenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tuwenUuidNumber",tuwenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //三国图文编号
                        List<TuwenEntity> tuwenEntities_tuwenUuidNumber = tuwenService.selectList(new EntityWrapper<TuwenEntity>().in("tuwen_uuid_number", seachFields.get("tuwenUuidNumber")).eq("tuwen_delete", 1));
                        if(tuwenEntities_tuwenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuwenEntity s:tuwenEntities_tuwenUuidNumber){
                                repeatFields.add(s.getTuwenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [三国图文编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tuwenService.insertBatch(tuwenList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<TuwenView> returnTuwenViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = tuwenCollectionService.queryPage(params1);
        List<TuwenCollectionView> collectionViewsList =(List<TuwenCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(TuwenCollectionView collectionView:collectionViewsList){
            Integer tuwenTypes = collectionView.getTuwenTypes();
            if(typeMap.containsKey(tuwenTypes)){
                typeMap.put(tuwenTypes,typeMap.get(tuwenTypes)+1);
            }else{
                typeMap.put(tuwenTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("tuwenTypes",type);
            PageUtils pageUtils1 = tuwenService.queryPage(params2);
            List<TuwenView> tuwenViewList =(List<TuwenView>)pageUtils1.getList();
            returnTuwenViewList.addAll(tuwenViewList);
            if(returnTuwenViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = tuwenService.queryPage(params);
        if(returnTuwenViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnTuwenViewList.size();//要添加的数量
            List<TuwenView> tuwenViewList =(List<TuwenView>)page.getList();
            for(TuwenView tuwenView:tuwenViewList){
                Boolean addFlag = true;
                for(TuwenView returnTuwenView:returnTuwenViewList){
                    if(returnTuwenView.getId().intValue() ==tuwenView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnTuwenViewList.add(tuwenView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnTuwenViewList = returnTuwenViewList.subList(0, limit);
        }

        for(TuwenView c:returnTuwenViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnTuwenViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = tuwenService.queryPage(params);

        //字典表数据转换
        List<TuwenView> list =(List<TuwenView>)page.getList();
        for(TuwenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuwenEntity tuwen = tuwenService.selectById(id);
            if(tuwen !=null){

                //点击数量加1
                tuwen.setTuwenClicknum(tuwen.getTuwenClicknum()+1);
                tuwenService.updateById(tuwen);

                //entity转view
                TuwenView view = new TuwenView();
                BeanUtils.copyProperties( tuwen , view );//把实体数据重构到view中

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
    public R add(@RequestBody TuwenEntity tuwen, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tuwen:{}",this.getClass().getName(),tuwen.toString());
        Wrapper<TuwenEntity> queryWrapper = new EntityWrapper<TuwenEntity>()
            .eq("tuwen_name", tuwen.getTuwenName())
            .eq("tuwen_uuid_number", tuwen.getTuwenUuidNumber())
            .eq("tuwen_types", tuwen.getTuwenTypes())
            .eq("tuwen_clicknum", tuwen.getTuwenClicknum())
            .eq("zan_number", tuwen.getZanNumber())
            .eq("cai_number", tuwen.getCaiNumber())
            .eq("shangxia_types", tuwen.getShangxiaTypes())
            .eq("tuwen_delete", tuwen.getTuwenDelete())
//            .notIn("tuwen_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuwenEntity tuwenEntity = tuwenService.selectOne(queryWrapper);
        if(tuwenEntity==null){
            tuwen.setTuwenClicknum(1);
                tuwen.setZanNumber(1);
                tuwen.setCaiNumber(1);
            tuwen.setTuwenDelete(1);
            tuwen.setInsertTime(new Date());
            tuwen.setCreateTime(new Date());
        tuwenService.insert(tuwen);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

