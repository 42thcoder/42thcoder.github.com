---
layout: post
title: "jQuery学习笔记之jQuery基础篇"
date: 2012-06-06 18:09
comments: true
categories: 
- jQuery
- 读书笔记
keywords: jQuery, 读书笔记, 基础
description: 通过阅读《jQuery基本原理》来了解jQuery时所做的读书笔记：只记重点，概括思想，以作备忘。
---

jQuery是目前最实用的JavaScript库，号称前端开发的利器，能大大简化开发，很有必要学习。这篇文章，是我通过阅读《[jQuery基本原理](http://docs.huihoo.com/jquery/jquery-fundamentals/zh-cn/index.html)》来了解jQuery时所做的读书笔记：只记重点，概括思想，以作备忘。

部分内容参考了阮一峰先生的博文[《jQuery设计思想》](http://www.ruanyifeng.com/blog/2011/07/jquery_fundamentals.html)。如果想了解JavaScript的一些基础知识，请参看我的上一篇读书笔记[《jQuery学习笔记之JavaScript基础语法篇》](http://oncoding.in/blog/2012/06/05/jqueryxue-xi-bi-ji-zhi-javascriptji-chu-yu-fa-pian/)

## jQuery基础

这一部分主要记录jQuery的基础知识。

## ready：一切的前提

ready可以用来判断当前页面是否已经加载完毕

``` js 
//常规写法
$(document).ready(function() {
    console.log('ready!');
});

//精简写法
$(function() {
    console.log('ready!');
})
```
<!-- more -->

``` js 指定某函数在页面加载完毕后执行
function readyFn() {
    console.log('run when page is ready.');
}

$(document).ready(readyFn);
```

## 选择元素：最基础的功能

使用jQuery的第一步，往往就是将一个选择表达式，放进构造函数jQuery()（**简写为$**），然后得到被选中的元素。jQuery支持大部分的CSS3选择器，完整的列表请参考[jQuery官方API](http://api.jquery.com/category/selectors/)

#### 如何选择元素

``` js 最常用的选择表达式
//选择整个文档对象
$(document)

//选择ID为myId的网页元素
$('#myId');

//选择class为myClass的div元素
$('div.myClass');

//选择name属性为first_name的input元素
$('input[name=first_name]');
```

``` js jQuery特殊的选择表达式
$('a:first') //选择网页中第一个a元素

$('tr:odd') //选择表格的奇数行

$('#myForm :input') // 选择表单中的input元素

$('div:visible') //选择可见的div元素

$('div:gt(2)') // 选择所有的div元素，除了前三个

$('div:animated') // 选择当前处于动画状态的div元素
```

#### 判断选择元素的操作是否成功

使用 $() 指定一个选择器，将会返回一个对象。即使选择器没有包含任何元素，该对象的值也为true。

``` js
if ($('div.foo')) { 
    //不管$('div.foo')的操作是否成功，此处的代码都会被执行 
}
```

正确的做法：测试返回对象的长度属性

``` js 测试选择器是否包含多个元素
if ($('div.foo').length) { ... }
```

#### 在变量中保存选择器

``` js
var $divs = $('div');
```

**注意**：当 DOM 改变时被保存的选择器不会自动更新。

#### 筛选结果集

jQuery提供了各种强大的过滤器，对结果集进行筛选，缩小选择结果。

``` js
$('div').has('p'); // 选择包含p元素的div元素
$('div').not('.myClass'); //选择class不等于myClass的div元素
$('div').filter('.myClass'); //选择class等于myClass的div元素
$('div').first(); //选择第1个div元素
$('div').eq(5); //选择第6个div元素
````

同时，jQuery还提供了在DOM树上移动的功能

``` js
$('div').next('p'); //选择div元素后面的第一个p元素
$('div').parent(); //选择div元素的父元素
$('div').closest('form'); //选择离div最近的那个form父元素
$('div').children(); //选择div的所有子元素
$('div').siblings(); //选择div的同级元素
```

## 操作元素

在成功选择元素后，jQuery支持对其进行一系列的操作

#### 链式操作

选中网页元素以后，可以对它进行一系列操作，并且所有操作可以连接在一起，以链条的形式写出来
。另外，jQuery还提供了.end()方法，使得结果集可以后退一步
``` js
$('#content')   //找到class为content的元素
    .find('h3') //选择所有的h3元素
    .eq(2)  //选择第三个h3元素
        .html('new text for the third h3!') //将它的内容改为
    .end() // 恢复选择器到 #content 中的所有 h3 部分 
    .eq(0)
        .html('new text for the first h3!');
```
**注意**：大量的链式处理会给代码的修改和调试带来困难。

#### Getters & Setters

Getters & Setters“重载”了同一个函数，根据参数列表确定最终的操作。

``` js
$('h1').html(); //html()没有参数，表示取出h1的值
$('h1').html('Hello')   //html()有参数hello，表示对h1进行赋值  
```

常见的Getters & Setters函数：

*   .html() html内容
*   .text() text内容
*   .attr() 某个属性的值
*   .width() 某个元素的宽度
*   .height() 某个元素的高度
*   .val() 表单元素的值

**注意**：如果结果集包含多个元素，那么赋值的时候，将对其中所有的元素赋值；取值的时候，则是只取出第一个元素的值（.text()例外，它取出所有元素的text内容）。

#### 移动元素

假定我们选中了一个div元素，需要把它移动到p元素后面。

``` js
//第一种方法是使用.insertAfter()，把div元素移动p元素后面：
$('div').insertAfter('p');
//第二种方法是使用.after()，把p元素加到div元素前面：
$('p').after('div');
```

两种操作的**区别**：返回的元素不一样。第一种方法返回div元素，第二种方法返回p元素。你可以根据需要，选择到底使用哪一种方法。

使用这种模式的操作方法，一共有四对：

*   .insertAfter()和.after()：在现存元素的外部，从后面插入元素
*   .insertBefore()和.before()：在现存元素的外部，从前面插入元素
*   .appendTo()和.append()：在现存元素的内部，从后面插入元素
*   .prependTo()和.prepend()：在现存元素的内部，从前面插入元素


``` js 使用appendTo()函数实现元素的移动
// 将第一个列表项作为最后一项 
var $li = $('#myList li:first').appendTo('#myList');

// 同一问题的另一种处理
$('#myList').append($('#myList li:first'));
```

#### 拷贝元素

在调用元素的移动函数之前，调用clone()函数即可。

#### 删除元素

使用.remove()和.detach()函数可以实现。两者的区别在于，前者不保留被删除元素的事件，后者保留，有利于重新插入文档时使用。
清空元素内容（但是不删除该元素）使用.empty()。

#### 新建元素

``` js
//创建新元素
$('<p>This is a new paragraph</p>');
$('<li class="new">new list item</li>');
//创建一个包含属性对象的新元素
$('<a/>', { 
    html : 'This is a <strong>new</strong> link',
    'class' : 'new',
    href : 'foo.html'
});
```
一个新元素被创建之后，它**不会**立刻被添加到页面中去，需要调用一次appendTo()函数。

``` js 添加新元素的完整示例
var $myNewElement = $('<p>New element</p>');
$myNewElement.appendTo('#content');
```

另外，需要添加多个新元素时，最好将其存储到数组中，再一次性的append。

``` js
var myItems = [], $myList = $('#myList');

for (var i=0; i<100; i++) {
    myItems.push('<li>item ' + i + '</li>');
}

$myList.append(myItems.join(''));
```

## 工具方法

jQuery提供了许多有用的工具方法，这些方法不需要选取元素就可以调用。

``` js $.trim()去除行间和末尾的空白。
$.trim('    大量额外空白    ');
// 返回 '大量额外空白'
```

``` js $.each()在数组和对象上迭代。
$.each([ 'foo', 'bar', 'baz' ], function(idx, val) {
    console.log('element ' + idx + 'is ' + val);
});

$.each({ foo : 'bar', baz : 'bim' }, function(k, v) {
    console.log(k + ' : ' + v);
});
```

 $.fn.each，也可用于在一个选择的元素中进行迭代。

``` js $.inArray()在数组中返回值索引，如果值不在数组中就为 -1 。
var myArray = [ 1, 2, 3, 5 ];

if ($.inArray(4, myArray) !== -1) {
    console.log('found it!');
}
```

``` js $.extend() 使用后面对象的属性改变第一个对象的属性。
var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };

var newObject = $.extend(firstObject, secondObject);
console.log(firstObject.foo); // 'baz'
console.log(newObject.foo);   // 'baz'
//如果你不打算改变任何对象你可传递 $.extend，作为第一个参数传递一个空对象。

var firstObject = { foo : 'bar', a : 'b' };
var secondObject = { foo : 'baz' };

var newObject = $.extend({}, firstObject, secondObject);
console.log(firstObject.foo); // 'bar'
console.log(newObject.foo);   // 'baz'
```

``` js $.proxy()返回一个函数它总是运行在一个提供的作用域里 — 就是说，this 的设置意味着内部传递函数到第二个参数。

var myFunction = function() { console.log(this); };
var myObject = { foo : 'bar' };

myFunction(); // 记录 window 对象

var myProxyFunction = $.proxy(myFunction, myObject);
myProxyFunction(); // 记录 myObject 对象
//如果你拥有一个带方法的对象，你能传递对象和方法名去返回一个总运行在对象作用域里的函数。

var myObject = {
    myFn : function() {
        console.log(this);
    }
};

$('#foo').click(myObject.myFn); // 记录 DOM 元素 #foo
$('#foo').click($.proxy(myObject, 'myFn')); // 记录 myObject
```

## 事件操作

曾经有一段时间，在浏览器中处理事件十分的混乱，导致API各不相同，缺少一致性。jQuery提供了一个统一的API消除了浏览器之间的差异。

#### 绑定事件

jQuery支持把事件直接绑定在元素上，可以使用bind()函数同时传入事件类型和回调函数作为参数。

``` js 
$('input').bind(
　　　　'click change', //同时绑定click和change事件
　　　　function() {
　　　　　　alert('Hello');
　　　　}
　　);
```

jQuery为常用事件提供一些快捷方法。

``` js
$('p').click(function(){
　　alert('Hello');
});
```

只想让绑定的事件执行一次

``` js
$('p').one('click', function() {
    console.log('You just clicked this for the first time!');
    $(this).click(function() { console.log('You have clicked this before!'); });
});
```
如果希望只在某个元素第一次被点击的时候做一些复杂的初始化， $.fn.one方法是很好的选择。

#### 事件对象

所有的事件处理函数，都可以接受一个事件对象（event object）作为参数，比如下面例子中的e：
``` js
$("p").click(function(e) {
　　alert(e.type); // "click"
});
```

这个事件对象有一些很有用的属性和方法：

+	event.pageX 事件发生时，鼠标距离网页左上角的水平距离
+	event.pageY 事件发生时，鼠标距离网页左上角的垂直距离
+	event.type 事件的类型（比如click）
+	event.which 按下了哪一个键
+	event.data 在事件对象上绑定数据，然后传入事件处理函数
+	event.target 事件针对的网页元素
+	event.preventDefault() 阻止事件的默认行为（比如点击链接，会自动打开新页面）
+	event.stopPropagation() 停止事件向上层元素冒泡


在事件处理函数中，可以用this关键字，返回事件针对的DOM元素：

``` js
$('a').click(function(e) {

　　　　if ($(this).attr('href').match('evil')) { //如果确认为有害链接
　　　　　　e.preventDefault(); //阻止打开
　　　　　　$(this).addClass('evil'); //加上表示有害的class
　　　　}
　　});
```

回调函数中的上下文this会发生改变

``` js
$('.clicky').click(function() {
    //this指向事件的目标对象
    assert( $(this).hasClass(".clicky") );
});
```

其中一个解决办法是在进入回调函数前，将上下文保存在一个局部变量中。

``` js

var self = this;

$('.clicky').click(function() {
    self.clickedClick();
});
```

另一种方法是使用代理函数将回调函数包装起来

``` js
$('.clicky').click($.proxy(function() {
    //上下文不会改变
}, this));
```

#### 支持事件列表

*	.blur() 表单元素失去焦点。
*   .change() 表单元素的值发生变化
*   .click() 鼠标单击
*   .dblclick() 鼠标双击
*   .focus() 表单元素获得焦点
*   .focusin() 子元素获得焦点
*   .focusout() 子元素失去焦点
*   .hover() 同时为mouseenter和mouseleave事件指定处理函数
*   .keydown() 按下键盘（长时间按键，只返回一个事件）
*   .keypress() 按下键盘（长时间按键，将返回多个事件）
*   .keyup() 松开键盘
*   .load() 元素加载完毕
*   .mousedown() 按下鼠标
*   .mouseenter() 鼠标进入（进入子元素不触发）
*   .mouseleave() 鼠标离开（离开子元素不触发）
*   .mousemove() 鼠标在元素内部移动
*   .mouseout() 鼠标离开（离开子元素也触发）
*   .mouseover() 鼠标进入（进入子元素也触发）
*   .mouseup() 松开鼠标
*   .ready() DOM加载完成
*   .resize() 浏览器窗口的大小发生改变
*   .scroll() 滚动条的位置发生变化
*   .select() 用户选中文本框中的内容
*   .submit() 用户递交表单
*   .toggle() 根据鼠标点击的次数，依次运行多个函数
*   .unload() 用户离开页面

#### 解除绑定

.unbind()用来解除事件绑定。

``` js
$('p').unbind('click');
```
