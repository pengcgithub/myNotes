# git #

## 1、git暂存区 ##
*1、git暂存区的三个状态*
    
    git diff
    git diff head 
    M 第一列字符含义，版本库和处理中间库状态有差异
    M 第二列字符含义，工作区与当前文件有差异
    git diff --cached 暂存区 和 head（值得是最后一次commit的master代码） 的对比
    git reset head XXX 将文件从暂存区中撤回（通过add添加到暂存区）
    git checkout XXX 撤销修改的文件

*2、理解暂存区*

    git stash
    git stash pop

## 2、git对象 ##

