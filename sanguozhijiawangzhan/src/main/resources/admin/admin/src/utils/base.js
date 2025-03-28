const base = {
    get() {
        return {
            url : "http://localhost:8080/sanguozhijiawangzhan/",
            name: "sanguozhijiawangzhan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/sanguozhijiawangzhan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "三国之家网站"
        } 
    }
}
export default base
