# Blog
## 一、需求完善

#### 1. 给目标用户展现原型，与目标用户进一步沟通理解需求。他们的痛点是什么？场景是什么？（用照片或视频显示开展用户调查的过程)

> ![用户调查](https://github.com/Blog0101/Blog/blob/Mahsin5227-temp/Documents/pictures/user.jpg)

我们通过与目标用户的交流沟通，了解到了他们的痛点所在。对于某一用户来说，整个网站上的博主与博客过多，且种类纷繁复杂，令人眼花缭乱。但是显然很少会有人对所有种类都感兴趣，他们往往希望看到的是自己感兴趣的部分，这样便能高效地获取自己所需。因此，我们可以在系统中加入推送的功能。博主的每篇博客在发表之前需要添加一定的标签，以作归类之用。而浏览者可以选择一些自己感兴趣的标签，以此来订阅博客。而系统也会根据用户的历史浏览记录，进行分析猜测用户的偏好，再向用户推送博客。

#### 2. 用一个场景，像讲故事 （User Story）那样，描述用户怎么使用几个相联系的功能，从而解决其问题。
> 用户小王，在一次上网搜索某技术方面的资料时，点进了一个网页链接。他发现这是某个曾经使用过该技术的人写下的相关指导教程博客，正好符合他当前的需求，但是讲的还不是很清楚。所以他在博客网站的首页以该技术为关键词进行搜索，找到了更多的相关博客，终于解决了他的问题。由于很多技术博客都对他很有启发，他也在该网站注册成为博主，登录并发表了第一篇博文，记录了他的学习经过及心得体会。发表之前，他为该博客加上了标签，以便更好地被归类查询。接着他又浏览了一些更深层次讲解该技术的博客，但是感觉并不能很好的理解，便在博客下的评论区提出了自己的一些疑问，不久之后便得到了其他热心用户的解答。通过一番讨论，小王学习到了很多的知识。后来再次登录博客，他在首页看到推送了很多关于该技术的新博客，小王又逐一观看学习。
#### 3. 参考《构建之法》8.5节功能的定位和优先级，给出功能分析的四个象限

象限|外围功能|杀手功能|
 ------------ | ------------ | -------------|
|必要需求|第二象限：登录个人信息管理、评论、管理员博文管理|第一象限：博客编写、博客搜索、博客界面
|辅助功能|第三象限：历史记录、个人博文管理|第三象限：历史记录、个人博文管理



#### 4. 完成需求规格说明设计

## 二、项目进度安排
#### 1. WBS。对需求进行逐层分解，估算需求所需的工作量。 根据团队成员可承诺的工作时间，选择可能实现的需求集合。

> ![WBS](https://github.com/Blog0101/Blog/blob/master/Documents/pictures/wbs.png)

#### 2. 进度安排、人员分工及占工作量比例情况

#### 甘特图

> ![甘特图](https://github.com/Blog0101/Blog/blob/master/Documents/pictures/gante1.png)
> ![甘特图](https://github.com/Blog0101/Blog/blob/master/Documents/pictures/gante2.png)


#### 主要分工
Alpha版本：
1. 原型设计：马新、黄正达
2. 文档编写：林立鹏、商琳梓
3. 前端设计与实现：林立鹏、商琳梓
4. 后台设计与实现：马新、黄正达

#### Beta版本：
1. 标签：马新、林立鹏、商琳梓
2. 消息：黄正达、林立鹏、商琳梓

#### 工作量比例
|姓名|任务占比|完成度|评分|
-----|----|----|----|
马新|25%|0|0
黄正达|25%|0|0
林立鹏|25%|0|0
商琳梓|25%|0|0

## 需求规格说明书

版本号|修改说明
----|----
v1.0 |
v2.0 |
v3.0 |

## 目录

### 1. 引言

#### 1.1 编写目的

#### 1.2 项目简介

#### 1.3 参考资料

### 2. 总体描述

#### 2.1 项目背景

#### 2.2 项目目标

#### 2.3 典型用户场景

#### 2.4 典型用户需求说明

#### 2.5 运行环境要求

### 3. 前提与假设

### 4. 页面原型设计

### 5. 系统功能描述验收标准

#### 5.1 对功能的规定


## 1. 引言

### 1.1 编写目的

此需求规格说明书的编写目的是为明确软件需求、安排项目规划与进度、组织软件开发与测试，撰写本文档。小组成员为：马新（334）、林立鹏（327）、黄正达（347）、商琳梓（329）。实现本项目使用SSM（Spring+SpringMVC+MyBatis）框架，java语言编写。


### 1.2 项目简介

项目名称：个人博客

项目面向用户：个人博主

项目开发者：农夫三拳

### 1.3 参考资料

构建之法、Java编程思想、Spring开发文档、SpringMVC开发文档、Mybatis开发文档


## 2. 总体描述

### 2.1 项目背景

信息时代的今天，网络已经成为人们工作、学习的一部分，不断充实和改变着人们的生活。在没有自己的博客之前，人们会经常进出于论坛发表贴子或者通过即时通信软件聊天，来表达自已的想法，可是这些都是零散的和杂乱的，通过构建一个个性化的博客，可以充分地表达自己的思想，通过发布文章展示个人才能，记录生活的瞬间，分享学习的心得，结交更多的朋友，网友则可以根据主题发表个人的意见，表达自己的想法，与博主进行思想交流，乐在其中。

### 2.2 项目目标

1. 对于博主：

        登陆
        发表博文
        搜索博文
        浏览博文
        管理个人博文
        管理个人信息
        评论

2. 对于游客：

        搜索
        浏览

3. 对于管理员：

        登陆后台
        系统管理
        博文管理
        用户管理
        查看日志


### 2.3 典型用户场景

系统主要面向三类用户：博主、游客、管理员。

**博主小王**

姓名	|小王
------|------------------------------
性别   | 男
职业 | 武汉大学本科生在读
知识层次和能力 | 本科生有一定计算机基础
动机、目的、困难 | 动机：作为网络个人日记   目的：学习交流
用户偏好 | 扁平化设计风格
用户比例 | 50%
典型场景 | 用户小王登陆了自己的账户，浏览了主页博客内容，并评论了内容，随后有搜索了自己感兴趣的博客，有感而发，编写了一篇博文，并发表了它。
典型描述 | 很不错，我喜欢

**游客小周**

姓名 | 小周
------|------------------------------
性别 | 女
职业 | 销售
知识层次和能力	| 研究生毕业，从小使用计算机
动机、目的、困难 | 动机：浏览网页，发现好玩的东西  目的：学习他人的知识  困难：网上无用知识过多，难以发现好资源
用户偏好 | 有深度的干货
用户比例 | 45%
典型场景 | 小周无意中进入了博客，浏览了博客内容，并搜索了自己感兴趣的内容
典型描述 | 无

**管理员小马**

姓名 | 小马
------|------------------------------
性别 | 男
职业 | 开发人员
知识层次和能力 | 本科生，擅长使用计算机，会编程
动机、目的、困难 | 动机：管理 目的：管理
用户偏好 | 无
用户比例 | 5%
典型场景 | 小马登陆了博客后台，查看了一下日志，发现了一篇内容不适合的博文，随后删除了该博文，并且限制了该用户的发表博文权限。
典型描述 | 可以管理用户、博文、评论

### 2.4 典型用户需求说明
    1. 博主：登陆、发表博文、搜索博文、浏览博文、管理个人博文、评论、管理个人信息
    2. 游客：搜索博文、浏览博文
    3. 管理员： 登陆、管理用户、管理博文、管理评论、查看日志、管理系统
### 2.5 运行环境要求
1. 平台：本项目可在各种系统中使用
2. 浏览器

浏览器 | Ｃhorme | Edge | FireFox | Internet Explorer | Opera | Safiar
-----|-----|-----|----|-----|-----|-----
最低版本 | 5 | Ａll | 4.0 | 10 | 11.50 | 5.0


## 3. 前提与假设
### 3.1 前提
    1. 技术前提：小组成员熟悉java语言，有一定编程经验。
    2. 人员前提： 小组成员不会出现变动，且在开发过程中不会因为突发情况导致成员无法参与开发工作。
### 3.2 假设
    1. 可操作性：假定用户在经过一段时间后即可灵活使用，通过网站即可满足自己的需求。
    2. 用户支持：假定在本网站开发的过程中得到用户的有效支持和配合。
    3. 时间限定：假定项目的截止时间不会提前。
    4. 需求限定：假定项目需求基本确定之后不会有太大改变。
## 4. 界面原型设计

首页
> ![首页](https://github.com/Blog0101/Blog/blob/Mahsin5227-temp/Documents/pictures/index.jpg)

登录页面
> ![登录](https://github.com/Blog0101/Blog/blob/Mahsin5227-temp/Documents/pictures/login.png)

个人页面
> ![user](https://github.com/Blog0101/Blog/blob/Mahsin5227-temp/Documents/pictures/profile.png)

博客页面
> ![blog](https://github.com/Blog0101/Blog/blob/Mahsin5227-temp/Documents/pictures/blogs.png)



## 5. 系统功能描述验收标准
### 5.1 对功能的规定
首页功能 
测试功能 | 测试项 | 输入/操作 | 检验点 | 测试功能 | 完成情况
首页功能	静态功能	
	
	

	
	
	

	
	
	
	

	
	
	
	

	
	
	
	


