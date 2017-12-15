# centos配置

### 中文乱码问题

修改`/etc/locale.conf`中的LANG变量，替换为以下：

<pre>
LANG="zh_CN.GB18030"
LANGUAGE="zh_CN.GB18030:zh_CN.GB2312:zh_CN"
SUPPORTED="zh_CN.UTF-8:zh_CN:zh:en_US.UTF-8:en_US:en"
SYSFONT="lat0-sun16"
</pre>

设置成功之后可以利用 `echo $LANG`命令查看当前系统编码格式


### 用于赋予root权限

<pre>
  修改/etc/passwd即可，把用户名的ID和ID组修改成0。
</pre>


### 用户组分配权限

<pre>
chown -R hadoop:hadoop /usr/hadoop/
</pre>
