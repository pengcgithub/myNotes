# vim常用操作 #

### 全选 ###

*命令：* ggVG

*解释：*
gg ： 让光标移动首行
V ： 是进入Visual(可视）模式 
G : 光标移到最后一行 

### 复制 ###

*全选复制：* 1,$y（此命令需要在shift+冒号命令中执行）

*复制：* y

### 查找 ###

*单词跳转：* e（向后跳），b（向前跳）

*跳转文件头部与尾部：* gg ： 跳转头部， shift+gg ： 跳转尾部， 行数+gg ： 跳转到指定行

*自当前光标位置向上搜索：* /pattern   Enter : 单个字符， /^place   Enter ： 行首， /place$   Enter ： 行尾

*自当前光标位置向下搜索：* ?pattern   Enter

备注：n：朝同一方向搜索，N:反方向进行搜索，pattern：要搜索的特定字符序列 



