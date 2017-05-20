# shell脚本 #

定义变量  xx=19

调用变量  echo $xx

取消变量 unset xx

shell的id echo $$

xx=19
本地变量，不会影响子shell

export yy=10 或者 通过本地变量转化 export xx
环境变量，会影响到所有的子shell

查看变量
set 命令

显示环境变量
env
export
export -p

declare -x zz=10  环境变量
declare +x zz  本地变量

位置变量
$0 表示文件的名字
$# 所有参数的个数
$* 所有的参数
echo $1 第一个参数
echo {$10} 第十个参数

set a b c d e


`#!/bin/bash`


系统当前的环境变量
echo $PATH
echo $HOME
echo $USER 当前用户
echo $HISTFILESIZE
echo $PSI


locale -a 查看系统所支持的所有编码



### 变量键盘读取、数组与申明：read、array、declare ###

read  xxx
表示让用户手动输入值，并会赋值给xxx变量，可以通过echo $xxx读取。

如果直接写read，后面不接入任何元素，则表示赋值给REPLAY这个变量。

array
xx=(aa bb cc dd),四个元素，下标由零开始。

获取值echo $(xx[0])
查看所有元素 echo $(xx[@/*])
查看下标echo $(!xx[@])
查看元素个数echo $(#xx[@])

declare
定义和转化环境变量

当变量出现在双引号里面，可以正常解析，如果存在于单引号里面则表示值

标准写法echo ${xxx}

### 与文件系统及程序的限制关系 ###
大小的限制
ulimit -a 查看
ulimit -f 20 设置文件的最高限制

### 变量内容的删除、替代与替换 ###

${path#/*kerberos/bin:}
从最前开始找第一个开始往前的全部删除

${path##/*kerberos/bin:}
从最前面开始找，找到最后一个关键字处删除

${path%bin*}
从最后面开始找，找到最近的一个关键字处全部删除

${path%%bin*}
从最后面开始找，找到最后的一个关键字处全部删除

${path/旧字符串/新字符串}
若变量内容符合“旧字符串”，则第一个旧字符串会被新字符串替换

${path/新字符串/旧字符串}
若变量内容符合“旧字符串”，则全部的旧字符串会被新字符串替换

r=${xx-"xxxxx"}
判断xx是否被定义，如果被定义，那么就将xx的值赋值给r，如果xx没有那么就将-后面的"xxxxx"这个值给r

r=${xx：-"xxxxx"}
判断xx是否被定义并且判断是否有值，如果xx没有值，系统不仅会将-后面的值赋值给r，同时也会将其赋值给xx

r=${xx：?-"xxxxx"}
如果xx没有定义或是空值，那么就会将-后面的值显示出来

r=${xx：+-"xxxxx"}

### 命令别名与历史命

alias aa="ifconfig eth0"

`type -a` echo 查看别名执行的顺序

unalias aa

history

### 管道命令 ###














