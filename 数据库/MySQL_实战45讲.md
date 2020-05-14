#### 1. 如果表T中没有字段k，而你执行了这个语句 select * from T where k=1, 那肯定是会报“不存在这个列”的错误： “Unknown column ‘k’ in ‘where clause’”。你觉得这个错误是在我们上面提到的哪个阶段报出来的呢？
    
问题的备选答案，按照这一课里的内容，是个二选一的问题：分析器阶段，还是执行器阶段。这两个阶段做的事：

问题解决思路: 首先创建2张表: a和b表， 然后创建用户user_test。赋予user_test a表的权限，b表无权限.

SELECT a1 FROM a;
```
 Error for unknown column
```
SELECT a2 FROM a;
```
 Error for unknown column
```
SELECT b1 FROM b;
SELECT b2 FROM b;
```
    ERROR 1142 (42000): SELECT command denied to user 'user_test'@'localhost' for table 'b'
```

对于后2行无权限的直接报该用户没有没有该表的权限。而前2行查询a表报的是没有该列。且用户是否拥有表的
权限是在执行期开始的时候校验的。如果没有权限，则报权限错误，否则，则打开该表，通过存储引擎提供的接口
，对表进行操作。这样的话，就可以知道获知某个表是否存在某个列，是需要打开一个表后才能知道该列是否存在的
<<<<<<< HEAD
。这样分析后，整个逻辑链条就清晰了。所以是执行期阶段报出的错误。
=======
。这样分析后，整个逻辑链条就清晰了。
>>>>>>> 69e81ebaf5f10d2f02c787dc6e09a6368fd24275
