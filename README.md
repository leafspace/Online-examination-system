# Online examination system

@(Online-examination-system)[在线考试系统|帮助|Markdown]

**Online-examination-system**在线考试系统（支持单选，多选，判断和填空题型，假设每个填空题只有一空且只有一个正确答案），要求：在系统中可设置一次考试的考试开始时间和考试时长，该场考试的考生名单可以通过数据库管理软件导入，每个学生的题目在考试前按照规定进行随机抽取（同一个学生的题目不可重复，题目顺序以及选择题的选项顺序可打乱），考试系统应有防刷新功能和倒计时功能，考试时间结束时自动收卷。系统能自动统计每个学生的得分。

-------------------
    
* 数据库：
    >版本：Mysql 5.3<br/>
    数据库名：online_examination_system<br/>
    数据库字符格式：utf-8<br/>
    数据库数据文件：见附件<br/>
    数据库ip控制：Online_examination_system\DatabaseConnector\MySqlDatabaseConnection.java<br/>

* 运行环境：
   > IDE版本：Inteilj IDEA 2017.1<br/>
    Tomcat版本：9.0.M13<br/>
    
* 设计缺陷：
   > 1.同一个用户能够同时登陆<br/>
    2.当多个班级中存在相同学生名的时候系统无法识别用户人员<br/>
    3.用户提交的bug问题管理员没有设计功能查看<br/>
    4.考试提交时间限制没有控制<br/>
    5.断电保护功能<br/>
  6.系统日志功能<br/>