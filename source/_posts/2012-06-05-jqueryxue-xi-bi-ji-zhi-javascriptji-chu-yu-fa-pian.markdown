---
layout: post
title: "jQuery学习笔记之JavaScript基础语法篇"
date: 2012-06-05 23:29
comments: true
categories: 
- 读书笔记
- jQuery
keywords: jQuery, 读书笔记, 基础
description: 通过阅读《jQuery基本原理》来了解jQuery时所做的读书笔记：只记重点，概括思想，以作备忘。
---


jQuery是目前最实用的JavaScript库，号称前端开发的利器，能大大简化开发，很有必要学习。这篇文章，是我通过阅读《[jQuery基本原理](http://docs.huihoo.com/jquery/jquery-fundamentals/zh-cn/index.html)》来了解jQuery时所做的读书笔记：只记重点，概括思想，以作备忘。

## JavaScript基础语法

这一部分主要记录JavaScript的*非常见*基本语法，适合看完W3Shool中JavaScript简介的人。

#### 逻辑表达式

或运算符（ ||） 返回第一个值为真的操作数, 如果两个操作数的值都为假，则返回最后一个操作数。  

与运算符（ &&） 返回第一个值为假的运算符，如果两个操作数的值都为真，则返回最后一个操作数。

该特性可用于取代if进行流程控制，非常优雅

``` js
// 当foo的值为真的时候执行doSomething来处理foo
foo && doSomething(foo);

// 如果baz为真，则把baz的值赋给bar
// 否则bar的值为函数craetBar的返回值
var bar = baz || createBar();
```

<!-- more -->

#### 何时为真&&何时为假
``` js 被判断为true的值
'0'; //字符串0。
'any string';//任意字符串。
[];  // 一个空数组。
{};  // 一个空对象。
1;   // 不为0的数。
```

```js 被判断为false的值
0;
'';  // 一个空串。
NaN; // JavaScript中的 "not-a-number"（NaN是一个不确定的数）。 
null;
undefined;  // 注意 -- undefined 可以被重新定义!
```

#### 把字符串转换为数字
``` js
var foo = 1;
var bar = '2';

// 使用Number对象的构造函数
console.log(foo + Number(bar));
// 使用 + 进行强制类型转换
console.log(foo + +bar);
```

#### 比较运算符

``` js
var foo = 1;
var bar = 0;
var baz = '1';
var bim = 2;

foo == baz;	//返回真
foo === parseInt(baz);	//	返回真
bim > baz;	//返回真
```

#### 三元运算符

``` js
//如果bar为1，则foo值为1
//否则，foo的值为0
var foo = bar ? 1 : 0
```

#### switch语句

switch语句支持值为字符串。在JavaScript中很少使用switch语句，通过创建对象来实现更好。我没懂为什么更好，搜到挺有意思的文章，[“使用面向对象技术取代switch和if”](http://zhangjunhd.blog.51cto.com/113473/68070/)，改天看看，mark。

``` js
var stuffToDo = {
    'bar' : function() { 
        alert('the value was bar -- yay!');
    },

    'baz' : function() { 
        alert('boo baz :(');
    },

    'default' : function() { 
        alert('everything else is just ok');
    }
};

if (stuffToDo[foo]) {
    stuffToDo[foo]();
} else {
    stuffToDo['default']();
}
```

#### 数组

``` js
// 获取测试数组长度
var myArray = [ 'hello', 'world' ];
console.log(myArray.length);   // logs 2

// 加入元素到数组中
var myArray = [ 'hello', 'world' ];
myArray.push('new');

// 数组元素的切割与合并
var myArray = [ 'h', 'e', 'l', 'l', 'o' ];
var myString = myArray.join('');   // 'hello'
var mySplit = myString.split('');  // [ 'h', 'e', 'l', 'l', 'o' ]
```
#### 函数

###### 自执行匿名函数

创建一个函数表述式然后立即执行函数，避免在代码中乱用全局命名空间

``` js
(function(){
    var foo = 'Hello world';
})();

console.log(foo);   // undefined!
```

###### 函数作为参数

``` js 以参数的方式传递一个匿名函数
var myFn = function(fn) {
    var result = fn();
    console.log(result);
};

myFn(function() { return 'hello world'; });   // logs 'hello world'
```

``` js 以参数的方式传递一个命名函数
var myFn = function(fn) {
    var result = fn();
    console.log(result);
};

var myOtherFn = function() {
    return 'hello world';
};

myFn(myOtherFn);   // logs 'hello world'
```
#### 作用域

声明变量时一定要加var关键字。否则，该变量被当做全局变量，即使该声明发生在函数内部
