var addressInit = function(_cmbProvince, _cmbCity, _cmbArea, defaultProvince, defaultCity, defaultArea)
{
    var cmbProvince = document.getElementById(_cmbProvince);
    var cmbCity = document.getElementById(_cmbCity);
    var cmbArea = document.getElementById(_cmbArea);

    function cmbSelect(cmb, str)
    {
        for(var i=0; i<cmb.options.length; i++)
        {
            if(cmb.options[i].value == str)
            {
                cmb.selectedIndex = i;
                return;
            }
        }
    }
    function cmbAddOption(cmb, str, obj)
    {
        var option = document.createElement("OPTION");
        cmb.options.add(option);
        option.innerText = str;
        option.value = str;
        option.obj = obj;
    }

    function changeCity()
    {
        cmbArea.options.length = 0;
        if(cmbCity.selectedIndex == -1)return;
        var item = cmbCity.options[cmbCity.selectedIndex].obj;
        for(var i=0; i<item.areaList.length; i++)
        {
            cmbAddOption(cmbArea, item.areaList[i], null);
        }
        cmbSelect(cmbArea, defaultArea);
    }
    function changeProvince()
    {
        cmbCity.options.length = 0;
        cmbCity.onchange = null;
        if(cmbProvince.selectedIndex == -1)return;
        var item = cmbProvince.options[cmbProvince.selectedIndex].obj;
        for(var i=0; i<item.cityList.length; i++)
        {
            cmbAddOption(cmbCity, item.cityList[i].name, item.cityList[i]);
        }
        cmbSelect(cmbCity, defaultCity);
        changeCity();
        cmbCity.onchange = changeCity;
    }

    for(var i=0; i<provinceList.length; i++)
    {
        cmbAddOption(cmbProvince, provinceList[i].name, provinceList[i]);
    }
    cmbSelect(cmbProvince, defaultProvince);
    changeProvince();
    cmbProvince.onchange = changeProvince;
}

var provinceList = [
    {name:'一级分类', cityList:[
            {name:'二级分类', areaList:['三级分类']},
        ]},
    {name:'办公效率', cityList:[
            {name:'办公软件', areaList:['PPT','Excel','Word','Project']},
            {name:'工作效率', areaList:['思维导图','时间管理','Omni系列']},
            {name:'电脑基础', areaList:['基础操作','微课制作','常用工具']},
            {name:'考试认证', areaList:['计算机二级Office','微软MOS认证']}
        ]},
    {name:'职场发展', cityList:[
            {name:'个人提升', areaList:['礼仪形象','演讲能力','个人品牌','目标管理']},
            {name:'职场能力', areaList:['职场经验','人际沟通','团队协作','商务谈判']},
            {name:'求职应聘', areaList:['职业规划','简历制作','面试技巧','笔试技巧']},
            {name:'商学院', areaList:['商业思维','商业通识','商业工具','商业案例']}
        ]},
    {name:'职业岗位', cityList:[
            {name:'设计软件', areaList:['Photoshop','Illustrator','After Effects','Sketch']},
            {name:'平面设计', areaList:['广告海报设计','字体设计','商业插画','设计思维与方法']},
            {name:'其他设计', areaList:['影视动画&游戏','工业设计','建筑家装设计']},
            {name:'市场营销', areaList:['网络营销','市场营销','电子商务','品牌推广']},
            {name:'人力资源管理', areaList:['员工关系','招聘管理','薪酬管理','培训管理']}
        ]},
    {name:'人工智能', cityList:[
            {name:'数据科学', areaList:['数据分析','大数据','数据库']},
            {name:'人工智能', areaList:['机器学习','深度学习','编程基础']},
            {name:'区块链', areaList:['DAPP智能合约开发','比特币']},
            {name:'智能设备和物联网', areaList:['']}
        ]},
    {name:'IT&互联网', cityList:[
            {name:'编程语言', areaList:['Python','PHP','Java','C++','C']},
            {name:'前端开发', areaList:['开发语言','前端框架','开发实践']},
            {name:'后端开发', areaList:['Java Web','Python','PHP Web','.NET']},
            {name:'移动开发', areaList:['微信开发','iOS','React Native','Android','Unity3D']},
            {name:'网络与运维', areaList:['软件工程与方法','网络与通讯','信息安全','测试运维']}
        ]},
    {name:'语言留学', cityList:[
            {name:'英语口语', areaList:['职场口语','生活口语','零基础入门','英式发音','美式发音']},
            {name:'新概念英语', areaList:['新概念']},
            {name:'零基础', areaList:['英语单词']},
            {name:'少儿英语', areaList:['零基础入门','自然拼读','音标','原版绘本','美式发音','英式发音']},
            {name:'英语考试', areaList:['四六级','考研英语','BEC商务英语','大学英语']}
        ]},
    {name:'职场之外', cityList:[
            {name:'摄影影视', areaList:['摄影基础','手机摄影','摄影后期','影视基础','影视后期']},
            {name:'音乐乐器', areaList:['乐理基础','声乐歌唱','编曲创作','中国乐器']},
            {name:'运动健康', areaList:['体育运动','医疗养生','两性健康','箭神','舞蹈','瑜伽']},
            {name:'兴趣修养', areaList:['绘画','书法','手工DIY','科普','人文']},
            {name:'居家生活', areaList:['美食与健康','家居装饰','生活妙招']}
        ]},
];