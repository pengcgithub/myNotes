# HTML 小知识点总结 #

### 1、如何去除coords点击时的锚点框显示问题。 ###
    圆形：shape="circle"，coords="x,y,z"
    这里的 x 和 y 定义了圆心的位置（"0,0" 是图像左上角的坐标），r 是以像素为单位的圆形半径。

    多边形：shape="polygon"，coords="x1,y1,x2,y2,x3,y3,..."
    每一对 "x,y" 坐标都定义了多边形的一个顶点（"0,0" 是图像左上角的坐标）。
    定义三角形至少需要三组坐标；高纬多边形则需要更多数量的顶点。
    多边形会自动封闭，因此在列表的结尾不需要重复第一个坐标来闭合整个区域。

    矩形：shape="rectangle"，coords="x1,y1,x2,y2"
    第一个坐标是矩形的一个角的顶点坐标，另一对坐标是对角的顶点坐标，"0,0" 是图像左上角的坐标。

    area{
	outline:none; /*移除超链的虚线框 IE8,FF有用*/
	hide-focus: expression(this.hideFocus=true); /*IE6、IE7*/ }
    
    