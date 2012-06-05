---
layout: post
title: "Hello World"
date: 2012-06-03 11:32
comments: true
categories: 
# One category
#categories: Sass

# Multiple categories example 1
#categories: [CSS3, Sass, Media Queries]

# Multiple categories example 2
categories:
- CSS3
- Sass
- Media Queries
---

## 我的第一篇博文
进行一些测试，熟悉一下MarkDown的语法

#### 先来看段视频：
{% video http://s3.imathis.com/video/zero-to-fancy-buttons.mp4 640 320 http://s3.imathis.com/video/zero-to-fancy-buttons.png %}

<!-- more -->

## 代码演示

####  最快速度插入单行代码 
```
$ sudo make me a sandwich
```

``` ruby Discover if a number is prime http://www.noulakaz.net/weblog/2007/03/18/a-regular-expression-to-check-for-prime-numbers/ Source Article
class Fixnum
  def prime?
    ('1' * self) !~ /^1?$|^(11+?)\1+$/
  end
end
```


#### 插入代码片段
{% codeblock lang:objc %}
[rectangle setX: 10 y: 10 width: 20 height: 20];
{% endcodeblock %}

#### 另一种代码片段，指定文件名
{% codeblock Time to be Awesome - awesome.rb %}
puts "Awesome!" unless lame
{% endcodeblock %}

#### 显示文件中的代码
{% include_code Add to_fraction for floats test.rb %}

## 演示引用

#### 不知道这个算什么
{% pullquote %}
Surround your paragraph with the pull quote tags. Then when you come to
the text you want to pull, {" surround it like this "} and that's all there is to it.
{% endpullquote %}

#### 引用是这样的

{% blockquote Seth Godin http://sethgodin.typepad.com/seths_blog/2009/07/welcome-to-island-marketing.html Welcome to Island Marketing %}
Every interaction is both precious and an opportunity to delight.
{% endblockquote %}

## 试试图片

{% img http://farm8.staticflickr.com/7220/7325502022_766512ef80.jpg %} 

{% img legt http://farm8.staticflickr.com/7220/7325502022_766512ef80.jpg '123' %} 
{% img right http://farm8.staticflickr.com/7220/7325502022_766512ef80.jpg '456' %} 

## 强调？

斜体 *point*

粗体 **point**

