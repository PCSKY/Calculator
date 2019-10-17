# Calculator
这是一款简易的Android计算器，是本人用于熟悉Android的UI布局以及计算器的中缀转后缀算法的一个小项目，若想尝试使用可以打开/app/release文件夹找到apk文件<br/><br/>
[calculator V1.0.1](https://github.com/PCSKY/Calculator/blob/master/app/release/calculator_V1.0_C1release.apk)
<br/>
[calculator_v1.0.2](https://github.com/PCSKY/Calculator/blob/master/app/release/calculator_V1.0_C2release.apk)
<br/><br/><br/>
# 开发工具
Windows10 + Android studio 3.3.0
<br/><br/><br/>
# 布局&取色
* 计算器采用的是Android中的LinearLayout布局，最底部通过一个适应于屏幕的LinearLayout布局作为底层布局，并且设置为黑色
* 在底层布局中加入了7个LinearLayout子布局，2个用于文本框，5个用于键盘按钮，在其中通过设置权值的方式，使得计算机的布局可以适应各种屏幕的手机
* 计算器UI的取色参考了iphone计算器的取色方案<br/><br/>
![计算器UI](https://github.com/PCSKY/Calculator/blob/master/img/calculatorUI.png)
<br/><br/><br/>
# 计算器功能
* 基本的四则运算（+,-,×,÷）
* 支持负数与小数运算
* 实现了简单的阶乘(!)与乘方（^）
* 可输入完整的算式，可实现括号匹配
* 可查看上一次计算的答案
<br/><br/><br/>
# 效果图
![普通四则运算](https://github.com/PCSKY/Calculator/blob/master/img/runTest1.png)
![阶乘](https://github.com/PCSKY/Calculator/blob/master/img/runTest2.png)
![百分号](https://github.com/PCSKY/Calculator/blob/master/img/runTest3.png)
![大数计算](https://github.com/PCSKY/Calculator/blob/master/img/runTest4.png)
<br/><br/><br/>
# 改进
- [x] 基本运算使用BigDecimal进行完善，不会出现小数精度问题
- [x] 答案如果过长则改为科学计数法显示
- [ ] 用BigDecimal类改进阶乘与乘方
- [ ] 尝试增加科学计算器的功能  
- [ ] 保留更多的历史纪录
- [ ] 完善+/-状态变化
- [ ] 参考windows计算器相应增加日常功能
<br/><br/><br/>
# 参考链接
* [Android简单计算器实现](https://blog.csdn.net/sakurakider/article/details/76283801) <br/>
* [android开发button的实现方法](https://blog.csdn.net/qq_37570066/article/details/77431474) <br/>
* [计算器UI设计](http://www.sj33.cn/digital/uisj/201609/46378.html) <br/>
* [运算符优先级](https://baike.baidu.com/item/运算符优先级/4752611?fr=aladdin#2) <br/>
* [中缀转后缀的一些思路](https://blog.csdn.net/BaiBai_Yazi/article/details/83215521) <br/>
* [BigDecimal基本运算](https://blog.csdn.net/haiyinshushe/article/details/82721234) <br/>
* [BigDecimal去掉小数后多余0](https://blog.csdn.net/qq_33157666/article/details/79585225) <br/>
