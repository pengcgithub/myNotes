# Linux文件与目录管理 #

## 目录与路径 ##

绝对路径 ： 路径的写法一定由根目录/写起，例如 /usr/share/doc

相对路径 ： 路径的写法不是由/写起，例如由/usr/share/doc，要到/usr/share/man下面时，可以改写为"cd ../man"即可。

建议 ： 如果是写程序最好用绝对路径的写法，这样可以肯定这个写法绝对不会有问题。

### 目录的相关操作 ###

`.` ，代表此层目录

`..`，代表上一层目录

`-`，代表前一个工作目录

`~`，代表"目前用户身份"所在的主文件夹

`cd ~` : 回到当前用户的工作目录

`cd -` : 返回到上次个工作目录

mkdir -p test/test1/test2    # 加了这个 -p 的参数，可以自行创建多层目录。

mkdir -p test/{xx.yy.cc}    #建立test文件夹，同时建立test下的xx,yy,cc文件夹

rmdir [-p] 目录名称    # 上述一致

### 关于执行文件路径变量 ： $PATH ###

存在可执行命令的路径，例如ls命令，之所有能够在任何路径下使用，主要是PATH路径中存放了/bin/ls这个命令的路径。主要归功于环境变量PATH的帮助。

echo $PATH    #显示目前的路径


## 文件与目录管理 ##

cp /path/xx /path/yy
如果yy是个文件夹，那么就将xx文件拷贝到yy目录下，如果yy不是文件夹，那么就相当于是将xx拷贝到path目录，并重命名为yy。

cp -rf /ect /mnt
拷贝文件夹，r递归 f强制，复制文件夹的同时也将文件夹的文件一同复制

cp /ect/services /mnt -p
复制文件一同复制属性信息， -p 复制属性信息

cp -a /ect /mnt

cp -d 连接文件1 连接文件2
若复制连接文件的属性，就使用-d的参数！ 否则就直接复制的源文件。

rm

取得路径的文件名与目录名称
basename /ect/network    #获取文件名

dirname /ect/network    #获取路径名


## 文件内容查阅 ##

 

## 命令与文件的查询 ##

### 脚本文件名查询 ###

which (寻找“执行文件”), 例如：which ifconfig

which -a (文件)， 可以找到同名的执行文件，而非只显示一个。

which cd, 显示效果为no cd. 由于which是默认查找PATH规范内的目录，但是cd是属于bash目录下的问价，所以会找不到

### 文件名的查找 ###

whereis (寻找特定文件)

<pre>
whereis [-bmsu] 文件或目录名
-b : 只查找二进制文件
-m : 只找在说明文件manual路径下的文件
-s : 只找source源文件
-u : 查找不在上诉三个选项中的特殊文件
</pre>


locate
<pre>
locate [-ir] keyword
参数
-i : 忽略大小写
-r ： 后面可接正则表达式的显示方式
</pre>

以上两种查询方式都是基于数据库查询，所有不用硬盘扫描，所以会快很多。不过由于数据库会默认一天执行一次，将硬盘中的数据存入(/var/lib/mlocate)，所以当使用以上命令查询不到数据时，可以使用updatedb命令更新数据库。

find
<pre>
find 目录 -属性 值
参数：
目录 ： 如果不指定目录，就在当前目录查找
属性 ： name/size/user/uid/group/nouser/nogroup

关于时间的属性参数， atime、ctime、mtime。
find /var -mtime +4    大于等于五天前的修改的文件夹名
find /var -mtime -4    小雨等于四天内的文件名
find /var -mtime +4    代表4-5那一天的文件夹名

-size [+-]SIZE : 大小查询
-type TYPE : 类型查询
-newr NEW : 查询比NEW还有新的文件

-perm mode : 权限刚好等于mode权限文件
-perm -mode : 查找文件权限“必须全部包括mode文件” 
-perm +mode : 查找文件权限“包含一mode的权限”的文件
</pre>

## 7.6 权限与命令间的关系 ##

r : 读取权限

w : 写入权限

x : 可执行权限