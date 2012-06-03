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

1. 我的第一篇博文

1.1. 先来看段视频：
{% video http://s3.imathis.com/video/zero-to-fancy-buttons.mp4 640 320 http://s3.imathis.com/video/zero-to-fancy-buttons.png %}


2. 代码演示

2.1. 插入代码片段
{% codeblock lang:objc %}
[rectangle setX: 10 y: 10 width: 20 height: 20];
{% endcodeblock %}

2.2. 另一种代码片段，指定文件名
{% codeblock Time to be Awesome - awesome.rb %}
puts "Awesome!" unless lame
{% endcodeblock %}

2.3. 显示文件中的代码
{% include_code Add to_fraction for floats test.rb %}

3. 演示引用

3.1. 不知道这个算什么
{% pullquote %}
Surround your paragraph with the pull quote tags. Then when you come to
the text you want to pull, {" surround it like this "} and that's all there is to it.
{% endpullquote %}

