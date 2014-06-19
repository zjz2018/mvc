<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<script type="text/javascript">
//2，截取字符串abcdefg的efg
//alert('abcdefg'.substring(4));

//3，判断一个字符串中出现次数最多的字符，统计这个次数
/*var str = 'asdfssaaasasasasaa';
var json = {};

for (var i = 0; i < str.length; i++) {
      if(!json[str.charAt(i)]){
              json[str.charAt(i)] = 1;
      }else{
              json[str.charAt(i)]++;
      }
};
var iMax = 0;
var iIndex = '';
for(var i in json){
      if(json[i]>iMax){
              iMax = json[i];
              iIndex = i;
      }
}
alert('出现次数最多的是:'+iIndex+'出现'+iMax+'次');*/

//4，IE与FF脚本兼容性问题
/*obj.addEventListener(sEv, fn, false);
obj.attachEvent('on'+sEv,fn);
detachevet
removeEventListener
DOMContentLoaded
onreadystatechange  complete
DOMMouseScroll FF
onmousewheel   非FF
event.wheelDelta 上滚120 下-120
event.detail     上滚-3   下3  
obj.getCurrentStyle[attr]
getComputedStyle(obj,false)[attr]
XMLHttpRequest
ActiveXObject('Mircorsoft.XMLHttp')
FF本地能设置读取cookie 其他不行
event  ev
事件源
srcElement||target
toElement||relatedTarget
obj.setCapture();只有ie认
obj.releaseCapture();*/

//5，规避javascript多人开发函数重名问题
/*命名空间
封闭空间
js模块化mvc（数据层、表现层、控制层）
seajs
变量转换成对象的属性
对象化*/

//6，javascript面向对象中继承实现
/*function Person(name){
      this.name = name;
}

Person.prototype.showName = function(){
      alert(this.name);
}

function Worker(name, job){
      Person.apply(this,arguments)
      this.job = job;
}
for(var i in Person.prototype){
      Worker.prototype = Person.prototype;
}
new Worker('sl', 'coders').showName();*/

//7，FF下面实现outerHTML
/*var oDiv = document.createElement('div');
var oDiv1 = document.getElementById('div1');
var oWarp = document.getElementById('warp');

oWarp.insertBefore(oDiv, oDiv1);
oDiv.appendChild(oDiv1);
var sOut = oDiv.innerHTML;
oWarp.insertBefore(oDiv1, oDiv);
oWarp.removeChild(oDiv);
alert(sOut);*/


//8，编写一个方法 求一个字符串的字节长度;
//假设一个中文占两个字节
/*var str = '22两是';

alert(getStrlen(str))

function getStrlen(str){
      var json = {len:0};
      var re = /[\u4e00-\u9fa5]/;
      for (var i = 0; i < str.length; i++) {
              if(re.test(str.charAt(i))){
                      json['len']++;
              }
      };
      return json['len']+str.length;
}*/

//9，编写一个方法 去掉一个数组的重复元素
/*var arr = [1,2,3,1,43,12,12,1];
var json = {};
var arr2 = [];
for (var i = 0; i < arr.length; i++) {
      if(!json[arr[i]]){
              json[arr[i]] = true;
      }else{
              json[arr[i]] = false;
      }

      if(json[arr[i]]){
              arr2.push(arr[i]);
      }
};

for (var i = 0; i < arr.length; i++) {
      if(!aa(arr[i], arr2)){
              arr2.push(arr[i])
      }
};
function aa(obj, arr){
      for (var i = 0; i < arr.length; i++) {
              if(arr[i] == obj) return true;
              else return false;
      };
}
alert(arr2)*/

//10，写出3个使用this的典型应用
/*
事件： 如onclick  this->发生事件的对象
构造函数          this->new 出来的object
call/apply        改变this*/

//11、如何深度克隆
/*var arr = [1,2,43];
var json = {a:6,b:4,c:[1,2,3]};
var str = 'sdfsdf';

var json2 = clone(json);

alert(json['c'])
function clone(obj){
      var oNew = new obj.constructor(obj.valueOf());
      if(obj.constructor == Object){
              for(var i in obj){
                      oNew[i] = obj[i];
                      if(typeof(oNew[i]) == 'object'){
                              clone(oNew[i]);
                      }
              }
      }
      return oNew;
}*/

//12，JavaScript中如何检测一个变量是一个String类型？请写出函数实现
//typeof(obj) == 'string'
//obj.constructor == String;

//13，网页中实现一个计算当年还剩多少时间的倒数计时程序，要求网页上实时动态显示“××年还剩××天××时××分××秒”
/*var oDate = new Date();
var oYear = oDate.getFullYear();

var oNewDate = new Date();
oNewDate.setFullYear(oYear, 11, 31, 23, 59, 59);
var iTime = oNewDate.getTime()-oDate.getTime();

var iS = iTime/1000;
var iM = oNewDate.getMonth()-oDate.getMonth();
var iDate =iS*/

//2.你能描述一下你制作一个网页的工作流程吗？

//3.你能描述一下渐进增强和优雅降级之间的不同吗?

//4. 请解释一下什么是语义化的HTML。
//内容使用特定标签，通过标签就能大概了解整体页面的布局分布

//6. 你如何对网站的文件和资源进行优化？

//7. 为什么利用多个域名来存储网站资源会更有效？
//确保用户在不同地区能用最快的速度打开网站，其中某个域名崩溃用户也能通过其他域名访问网站

//8.请说出三种减低页面加载时间的方法
/*1、压缩css、js文件
2、合并js、css文件，减少http请求
3、外部js、css文件放在最底下
4、减少dom操作，尽可能用变量替代不必要的dom操作*/

//9.什么是FOUC？你如何来避免FOUC？
/*由于css引入使用了@import 或者存在多个style标签以及css文件在页面底部引入使得css文件加载在html之后导致页面闪烁、花屏
用link加载css文件，放在head标签里面*/

//10.文档类型的作用是什么？你知道多少种文档类型？
/*影响浏览器对html代码的编译渲染
html2.0
xHtml
html5*/

//11.浏览器标准模式和怪异模式之间的区别是什么？
//盒模型解释不同

//1.* 你使用过那些Javascript库？
//jquery seajs yui

//2.哈希表
//具有散列（映射）特性的数据模型

//3.闭包
//子函数能被外部调用到，则该作用连上的所有变量都会被保存下来。

//4.请解释什么是Javascript的模块模式，并举出实用实例。
/*js模块化mvc（数据层、表现层、控制层）
seajs
命名空间*/

//5.你如何组织自己的代码？是使用模块模式，还是使用经典继承的方法？
/*对内：模块模式
对外：继承*/

//9* 你如何优化自己的代码？
/*代码重用
避免全局变量（命名空间，封闭空间，模块化mvc..）
拆分函数避免函数过于臃肿
注释
*/

//10.你能解释一下JavaScript中的继承是如何工作的吗？
/*
 *构造继承 
 *子构造函数中执行父构造函数，并用call\apply改变this
 *克隆父构造函数原型上的方法
*/

//11.useraget.nav

//12.请尽可能详尽的解释AJAX的工作原理。
/*创建ajax对象（XMLHttpRequest/ActiveXObject(Microsoft.XMLHttp)）
判断数据传输方式(GET/POST)
打开链接 open()
发送 send()
当ajax对象完成第四步（onreadystatechange）数据接收完成，判断http响应状态（status）200-300之间或者304（缓存）执行回调函数*/

//闭包
/*内部函数可以访问其所在的外部函数的变量
 *通常用来创建内部变量，使得这些变量不能被外部随意修改，同时又可以通过指定的接口修改
 */
 
//原型
/*
 *新建函数的同时创建prototype对象，函数对象的所有实例共享prototype中的属性
 */


</script>
</html>