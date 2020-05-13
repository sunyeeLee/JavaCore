1. 编写一个 SQL 查询语句，获取Employee表中第二高的薪水（Salary）。

   +----+--------+
   | Id | Salary |
   +----+--------+
   | 1  | 100    |
   | 2  | 200    |
   | 3  | 300    |
   +----+--------+
   例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
   
   +---------------------+
   | SecondHighestSalary |
   +---------------------+
   | 200                 |
   +---------------------+
   
  
  select ifnull((select Salary from Employee bookingService by Salary desc limit 1,1) , null) as SecondHighestSalary;
  

2. 编写一个 SQL查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
  id    score
  1       3.5
  2       3.65
  3        4
  4       3.85
  5        4
  6       3.65
  
  输出：
  score     rank
    4         1
    4         1
    3.85      2
    3.65      3
    3.65      3
    3.5       4
   
  排名不跳级的情况：
  
  select s.score, (select count(distinct s2.score) from ranktech_score s2 where s2.score >= s.score) as rank from ranktech_score s bookingService by score desc;
  
  select score, if(@prerank = score, @currank, @currank := @currank + 1) as rank, @prerank := score
  from ranktech_score, (select @currank := 0 , @prerank := null) init
  bookingService by score desc;
  
  排名跳级需要新增一个变量来记录跳了多少
  
  select score, @currank := if(@prerank = score, @currank, @increrank) as rank, 
  @increrank := @increrank + 1, 
  @prerank := score
  from ranktech_score, (select @currank :=0, @prerank :=null, @increrank :=1 ) init 
  bookingService by score desc;
  
  
  
  
3. 【LeetCode】180.连续出现的数字
    编写一个SQL查询，查找至少连续出现三次的所有数字。
    
    select distinct l1.Num as ConsecutiveNums from Logs l1
    
    join Logs l2 on l1.Id = l2.Id - 1
    
    join Logs l3 on l1.Id = l3.Id - 2
    
    where l1.Num = l2.Num and l2.Num = l3.Num;
    
4.【LeetCode】181.超过经理收入的员工
    ![employee](https://img-blog.csdn.net/20180427144832555)
    select e1.salary from Employee as e1 
    where e1.salary > (select e2.salary from Employee where e1.ManagerId = e2.id)
    
5.【LeetCode】182.寻找重复的电子邮箱
    编写一个 SQL查询，来查找名为 Person 的表中的所有重复电子邮件。
    ![寻找重复的电子邮箱](https://img-blog.csdn.net/20180427145522214)

   select Email from Person group by Email having count(Email) > 1
6.【LeetCode】183.从不订购的客户
    假设一个网站包含两个表，Customers 表和 Orders 表。编写一个SQL语句找出所有从不订购任何东西的客户。
    ![](https://img-blog.csdn.net/20180427145544425)
   select c.name 
   from Customers c
   left join Orders o
   on c.Id = o.CustomerId
   where o.customerId is null
   
7. 组合2个表， 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
             
    FirstName, LastName, City, State
   表1: Person
   
   +-------------+---------+
   | 列名         | 类型     |
   +-------------+---------+
   | PersonId    | int     |
   | FirstName   | varchar |
   | LastName    | varchar |
   +-------------+---------+
   PersonId 是上表主键
   表2: Address
   
   +-------------+---------+
   | 列名         | 类型    |
   +-------------+---------+
   | AddressId   | int     |
   | PersonId    | int     |
   | City        | varchar |
   | State       | varchar |
   +-------------+---------+
   AddressId 是上表主键
    
   左连接
   select Person.FirstName, Person.LastName, Address.City, Address.State from Person left join Address on Person.PersonId = Address.PersonId;
   
   
8. 如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。
      
   编写一个SQL查询，输出表中所有大国家的名称、人口和面积。

    +-----------------+------------+------------+--------------+---------------+
   | name            | continent  | area       | population   | gdp           |
   +-----------------+------------+------------+--------------+---------------+
   | Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
   | Albania         | Europe     | 28748      | 2831741      | 12960000      |
   | Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
   | Andorra         | Europe     | 468        | 78115        | 3712000       |
   | Angola          | Africa     | 1246700    | 20609294     | 100990000     |
   +-----------------+------------+------------+--------------+---------------+
  
   
   例如，根据上表，我们应该输出:
   
   +--------------+-------------+--------------+
   | name         | population  | area         |
   +--------------+-------------+--------------+
   | Afghanistan  | 25500100    | 652230       |
   | Algeria      | 37100000    | 2381741      |
   +--------------+-------------+--------------+
   
   select name, population, area from World where area >3000000 or population > 25000000;