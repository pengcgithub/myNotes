# git命令 #

### diff ###

`Git diff` 比较的是工作目录树与暂存区之间的区别。

`git diff --cached` 比较的是暂存区和版本库最后一个版本的区别。

`git diff HEAD` 比较的是工作目录树（包括暂存的和未暂存的修改）与版本库最后一个版本的差别。

这三个应用可以简单地理解为： <br>
如果你想看自己对照前一个版本所做的修改用： git diff HEAD <br>
如果你有边修改边保存的习惯，打个比喻：
你做git add可以比喻成你做保存(ctrl+s)，而git diff就是看你哪些东西没保存，git diff --cached则是看哪些东西保存了。

![diff命令](./diff.png)

**初始化git.md**文件是修改了，但是没有存入暂存区。 **HashMap.md**不仅被修改了而且还被存入暂存区。所有按照上述的文字描述，使用`git diff HEAD`命令，则显示所有被修改的内容，无论该文件是否已经存放到暂存区。而使用`git diff`只会展示修改且没有保存到暂存区的内容。`git diff --cached`则会展示修改并且已经保存到暂存区的内容。

## 参考资料 ##

### diff ###

- [读懂diff](http://www.ruanyifeng.com/blog/2012/08/how_to_read_diff.html)

- [git diff用法解释](http://blog.csdn.net/joe_007/article/details/6957108)
