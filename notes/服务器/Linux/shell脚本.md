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


#!/bin/bash


系统当前的环境变量
echo $PATH
echo $HOME
echo $USER 当前用户
echo $HISTFILESIZE
echo $PSI


locale


