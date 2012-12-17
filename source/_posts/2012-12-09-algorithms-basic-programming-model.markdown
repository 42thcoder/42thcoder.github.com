---
layout: post
title: "『算法』读书笔记之基础编程模型"
date: 2012-12-09 18:35
comments: true
categories: 
- SSP
- 算法
- 读书笔记
keywords: SSP, 算法, 读书笔记, 入门, Java, 基础编程模型
description: 这是学习《算法》1.1时所做的读书笔记，这一节简单介绍了本书所用到的基础编程模型 ，即Java语言的一个子集。
---

这是学习《算法》1.1时所做的读书笔记，这一节简单介绍了本书所用到的基础编程模型 ，即Java语言的一个子集。

## 大纲

本节重要知识点如下所示。

{% img /images/blog/basicProgrammingModel.png %}

<!-- more -->

## 代码实例

本小节简单实现了二分搜索，有递归和非递归两种实现方式。

{% include_code 递归实现二分搜索 ch01/RecursionBinarySearch.java %}

{% include_code 普通方式实现二分搜索 ch01/BinarySearch.java %}

## 练习

1. 编写一段代码，讲一个正整数N用二进制表示并转换为一个String类型的值s。

``` java 
public static String toBinaryString(int N){
	String s = "";
	for(int n = N; n > 0; n /= 2)
		s = (n % 2) + s;
}
```

未完待续。。。