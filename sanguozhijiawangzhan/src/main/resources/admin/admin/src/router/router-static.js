import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import exampaper from '@/views/modules/exampaper/list'
    import exampapertopic from '@/views/modules/exampapertopic/list'
    import examquestion from '@/views/modules/examquestion/list'
    import examrecord from '@/views/modules/examrecord/list'
    import examredetails from '@/views/modules/examredetails/list'
    import examrewrongquestion from '@/views/modules/examrewrongquestion/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import shipin from '@/views/modules/shipin/list'
    import shipinCollection from '@/views/modules/shipinCollection/list'
    import shipinLiuyan from '@/views/modules/shipinLiuyan/list'
    import tuwen from '@/views/modules/tuwen/list'
    import tuwenCollection from '@/views/modules/tuwenCollection/list'
    import tuwenLiuyan from '@/views/modules/tuwenLiuyan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zixun from '@/views/modules/zixun/list'
    import config from '@/views/modules/config/list'
    import dictionaryExampaper from '@/views/modules/dictionaryExampaper/list'
    import dictionaryExamquestion from '@/views/modules/dictionaryExamquestion/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryKemu from '@/views/modules/dictionaryKemu/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShipin from '@/views/modules/dictionaryShipin/list'
    import dictionaryShipinCollection from '@/views/modules/dictionaryShipinCollection/list'
    import dictionaryTuwen from '@/views/modules/dictionaryTuwen/list'
    import dictionaryTuwenCollection from '@/views/modules/dictionaryTuwenCollection/list'
    import dictionaryZixun from '@/views/modules/dictionaryZixun/list'
    import dictionaryZujuan from '@/views/modules/dictionaryZujuan/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryExampaper',
        name: '试卷状态',
        component: dictionaryExampaper
    }
    ,{
        path: '/dictionaryExamquestion',
        name: '试题类型',
        component: dictionaryExamquestion
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryKemu',
        name: '科目',
        component: dictionaryKemu
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShipin',
        name: '三国视频类型',
        component: dictionaryShipin
    }
    ,{
        path: '/dictionaryShipinCollection',
        name: '收藏表类型',
        component: dictionaryShipinCollection
    }
    ,{
        path: '/dictionaryTuwen',
        name: '三国图文类型',
        component: dictionaryTuwen
    }
    ,{
        path: '/dictionaryTuwenCollection',
        name: '收藏表类型',
        component: dictionaryTuwenCollection
    }
    ,{
        path: '/dictionaryZixun',
        name: '三国资讯类型',
        component: dictionaryZixun
    }
    ,{
        path: '/dictionaryZujuan',
        name: '组卷方式',
        component: dictionaryZujuan
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/exampaper',
        name: '试卷',
        component: exampaper
      }
    ,{
        path: '/exampapertopic',
        name: '试卷选题',
        component: exampapertopic
      }
    ,{
        path: '/examquestion',
        name: '试题表',
        component: examquestion
      }
    ,{
        path: '/examrecord',
        name: '考试记录表',
        component: examrecord
      }
    ,{
        path: '/examredetails',
        name: '答题详情表',
        component: examredetails
      }
    ,{
        path: '/examrewrongquestion',
        name: '错题表',
        component: examrewrongquestion
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/shipin',
        name: '三国视频',
        component: shipin
      }
    ,{
        path: '/shipinCollection',
        name: '三国视频收藏',
        component: shipinCollection
      }
    ,{
        path: '/shipinLiuyan',
        name: '三国视频留言',
        component: shipinLiuyan
      }
    ,{
        path: '/tuwen',
        name: '三国图文',
        component: tuwen
      }
    ,{
        path: '/tuwenCollection',
        name: '三国图文收藏',
        component: tuwenCollection
      }
    ,{
        path: '/tuwenLiuyan',
        name: '三国图文留言',
        component: tuwenLiuyan
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zixun',
        name: '三国资讯',
        component: zixun
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
