# object、video使用说明 #


## 1、object标签（播放flash） ##
### 1.1、代码实现 ###
    <object width="700" height="320">
	<param class="test1" name="data" value="播放路径">
	<param value="high">
	<param value="#FFFFFF">
	<param name="wmode" value="transparent">
	<embed class="test2" src="播放路径" wmode="transparent" quality="high"         	bgcolor="#FFFFFF" width="700" height="320" name="myMovieName" align="" 	type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/	go/getflashplayer" title="Adobe Flash Player">
	</object>

    标签说明：上处标注的两点，填入flash播放路径即可。

### 1.2、代码说明 ###
    此处需要注意以下几点
    1、虽然用object标签也是可以直接播放flash的，但是会出现各种各样的问题，所以最好建议用以上代码去实现。
    2、object标签本身有自己封装了很多方法，这些方法貌似都是有通过classid去实现的，但是classid的属性在IE8下回出现不兼容的情况，所以需要慎用。
    3、object标签将jQuery下能够使用的方法全部禁用（例如:onclick），所以这边无法利用本身标签进行事件实现，以下会单独说明如何实现jQuery常用的一些事件。（以下会用onclick事件为例）
    4、object标签不能够动态实现flash动画的切换，所以需要直接利用覆盖整个标签的方式才能够实现js的动态切换效果。

### 1.3、扩展实现 ###

*1、onclick事件具体实现*

    由于object标签会禁用本身事件，也包括该标签以上的父级标签，所以此处的解决方案是通过另一个div覆盖object标签，使div全透明，让其显示object标签的内容，但是onclick是在div标签上实现的。
    
    <div style="position:relative; height: 170px; width: 250px; float: left; margin-left: 65px; " >
		<div style="height: 130px;" >
			<object  id="obj" class="flashObj"></object>
		</div>
		<div style="left: 0; height: 130px; width: 250px; background-color: red;  	position:absolute; filter: alpha(opacity=0); opacity: 0;margin-	top:-130px; 	cursor:pointer" onclick="alert("单击事件");">
    	</div>
    </div>

    注意：
    1、上面的object考虑代码行数，所以没有写全。（可参照以上标准写法写全）
    2、position:absolute; filter: alpha(opacity=0); opacity: 0; 用于标识该div块设置为透明，并且覆盖于object标签之上。
    3、cursor:pointer 小手样式

*2、动态追加flash*

    由于object标签没有像video标签具有paly的操作，所以他无法实现动态的再加载flash动画的操作。以下将通过替换整个object标签的方式去实现动态追加flash的效果。


## 2、video标签 （播放视频） ##
### 2.1、代码实现 ###
    <video id="videoPlayer" class="video-js vjs-default-skin vjs-controls-enabled 	vjs-has-started vjs-paused vjs-user-inactive" 
		controls=controls preload="none" width="700" height="320" poster="播放路径" data-setup="{}">
	<source src="播放路径" type='video/mp4'>
	</video>

    标签说明： 上处标注处，填入播放路径。此标签以mp4格式为例，如需播放其他格式的，只需要修改source标签中的type属性。

### 2.2、代码说明 ###
    暂无

### 2.3、扩展实现 ###
*动态追加vedio* 
> var video = videojs('videoPlayer');
> video.src("路径");
> video.poster("路径");
> video.load();

videojs是video.js中给出的方法，利用此方法便可以解决动态追加vedio问题，同时该操作兼容IE8版本。
之后会在文档中给出video.js文件。




*以上纯属个人兴趣总结，如有错误还请指出。*

