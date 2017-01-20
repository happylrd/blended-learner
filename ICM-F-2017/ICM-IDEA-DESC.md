# ICM F's Idea

## Introduction

### Assumptions
just for basic model:
经过预处理后的样本数为10000


## Model
### Parameters
| Abbr | Params | Description  |
|---|---|---|
| __I__ | Income | 收入
| __E__ | Education | 教育
| __SE__ | Social Equality | 社会平等

### Idea
> AHP(Analytic Hierarchy Process) 层次分析法
运筹学理论，用于决策。
目标层、准则层、次准则层、方案层。

我们使用的方法思路来源于AHP，但并不是好吧。*需要寻找具体的模型的种类*。

**Model 1 数据->准则集**

**Input**
预处理后的数据集: {persion_info, persion_info, persion_info, ...}

**Procedure**
数据被次准则（I、E、SE的具体属性，暂未想好）处理，得到准则集。

**Output**
准则集:  {[I, E, SE],[I, E, SE],[I, E, SE],...}

**Model 2 准则集->目标**

化为一个典型的 多目标最优化 问题来进行处理。

**Input**
准则集:  {[I, E, SE],[I, E, SE],[I, E, SE],...}

**Output**
均衡解:  {GDP: , Happiness: }

## Appendix
多目标最优化：在一定约束下，它希望使得多个目标都能达到最优。
在现实生活中，很多问题都要求多个目标最好，或者是**妥协最好**。比如买车，要便宜，又要省油，还要快。
但是一般来说，多个目标同时达到最优的情况是不存在的。

多目标优化算法归结起来有传统优化算法和智能优化算法两大类。
1. 传统优化算法包括加权法、约束法和线性规划法等，实质上就是将多目标函数转化为单目标函数，通过采用单目标优化的方法达到对多目标函数的求解。
2. 智能优化算法包括进化算法（Evolutionary Algorithm, 简称EA）、粒子群算法（Particle Swarm Optimization, PSO）等。

## Reference
http://www.math168.com/sxxs/390.htm
http://blog.csdn.net/mimi9919/article/details/51234456
