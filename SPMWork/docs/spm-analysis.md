# SPM Analysis

> 在没有文档与注释的情况下接手一个ugly project，并且要在这个基础上进行开发，无奈之下对项目做一些分析。

## Task List

- [ ] action
- [ ] service
- [x] dao
- [x] domain
- [x] filter
- [x] interceptor
- [x] util

### 分析过程

> 持续更新中...:worried:

#### 感受

:broken_heart:

这tm谁写的代码...，该写的注释不写，没用的注释到是写了一大堆，真是醉了。
这数据库设计的真的是...
这代码编写的真的是一点规范都没有...
这配置文件感觉就是从别人的博客上乱拷的...

#### 问题与改进

`domain`问题

风格问题
  - 数据表命名风格混用，部分数据字段语义化差，一些数据字段命名简直让人无语。
  - 类的属性名 驼峰 下划线 混用。

数据属性限制在配置文件中随意添加。

`ConfigInfo`类无相应表，`fileinfo`表无相应类。

`domain`改进

编码风格类问题参见[编码风格](./code-style.md)。

计划 将 基于xml文件的配置 替换成 基于注解的配置。

`util`, `filter`, `interceptor`改进

通过全局搜索
发现 `util` 包下的 `HibernateUtils` 没有被显式使用，考虑删除；
发现 `filter`包下只有 `SessionFilter` 被显式使用，其余3个过滤器考虑删除；
发现 `interceptor`包下的 `MethodCacheInterceptor` 没有被显式使用，考虑删除。
用时自己再写。

`dao`改进

规范`dao`层代码

## Database Design

### BasicInfo(basicinfo)

data field      | value range                                 | desc
----------      | -----------                                 | ---
idCourseInfo    | int not null auto_increment primary key     | id
name            | varchar(50) null                            |
content         | varchar(10000) null                         |


### Code(code)

data field      | value range                                 | desc
----------      | -----------                                 | ---
id              | int not null auto_increment primary key     | id
codeType        | varchar(50) null                            |
codeCode        | varchar(50) null                            |
codeName        | varchar(50) null                            |
validate        | char null                                   |
remark          | varchar(200) null                           |


### Course(course)

data field      | value range                                 | desc
----------      | -----------                                 | ---
studentId       | varchar(15) not null primary key            | id
name            | varchar(45) not null                        |
classId         | varchar(45) not null                        |
email           | varchar(45) not null                        |
telno           | varchar(20) not null                        |
status          | varchar(45) not null                        |
dailyGrade      | decimal(5,2) default '0.00' null            |
midGrade        | decimal(5,2) default '0.00' null            |
finalGrade      | decimal(5,2) default '0.00' null            |
practiceGrade   | decimal(5,2) default '0.00' null            |
totalGrade      | decimal(5,2) default '0.00' null            |
syear           | char(4) null                                |


### DownLoad(download)

data field      | value range                                 | desc
----------      | -----------                                 | ---
id              | int not null auto_increment primary key     | id
title           | varchar(45) not null                        |
statement       | varchar(200) null                           |
filepath        | varchar(100) not null                       |


### Exam(exam)

data field      | value range                                 | desc
----------      | -----------                                 | ---
examName        | varchar(50) not null {{1/2 primary key}}    |
number          | int not null {{1/2 primary key}}            |
question        | varchar(500) not null                       |
answerA         | varchar(100) null                           |
answerB         | varchar(100) null                           |
answerC         | varchar(100) null                           |
answerD         | varchar(100) null                           |
answerRight     | varchar(2) null                             |


### Message(message)

data field      | value range                                 | desc
----------      | -----------                                 | ---
id              | int not null auto_increment primary key     | id
name            | varchar(800) null                           |
title           | varchar(800) null                           |
detail          | varchar(800) null                           |


### Schedule(schedule)

data field       | value range                                 | desc
----------       | -----------                                 | ---
chapter_id       | int not null {{1/3 primary key}}            |
video_step_order | int(32) not null {{1/3 primary key}}        |
percent          | int null                                    |
userId           | varchar(45) not null {{1/3 primary key}}    |


### SpChapter(sp_chapter)

data field          | value range              | desc
----------          | -----------              | ---
chapter_id          | int not null primary key | id
chapter_name_number | int null                 | 章编号
chapter_name        | varchar(64) null         | 章名称
chapter_desc        | varchar(256) null        | 章描述
chapter_pic         | varchar(256) null        | 图片路径
chapter_courseware  | varchar(256) null        | 课件路径


### SpChapterVideo(sp_chapter_video)

data field        | value range                      | desc
----------        | -----------                      | ---
id                | varchar(32) not null primary key | id
chapter_id        | int not null                     | 章编号
video_time        | int null                         | 时长，单位:分钟
video_name_number | varchar(32) null                 | 视频小节序号
video_name        | varchar(128) null                | 视频名称
video_desc        | varchar(512) null                | 视频描述
video_path        | varchar(512) null                | 视频地址
video_pic         | varchar(512) null                | 视频图片地址
video_step_order  | int(32) null                     | 视频顺序，标示用户学到哪个阶段


### TeachingPlan(teachingplan)

data field  | value range                             | desc
----------  | -----------                             | ---
id          | int not null auto_increment primary key | id
pieceId     | int null                                |
pieceName   | varchar(45) null                        |
chapterId   | int null unique                         |
chapterName | varchar(45) null unique                 |
filepath    | varchar(45) null                        |


### TradeInfo(tradeinfo)

data field  | value range                             | desc
----------  | -----------                             | ---
idtradeinfo | int not null auto_increment primary key | id
title       | varchar(100) null                       |
content     | varchar(2000) null                      |

### User(user)

data field | value range                      | desc
---------- | -----------                      | ---
id         | varchar(15) not null primary key | id
userName   | varchar(45) not null             |
password   | varchar(45) not null             |
position   | varchar(45) null                 |
userId     | varchar(45) null                 |
videoTime  | int default '0' null             |
