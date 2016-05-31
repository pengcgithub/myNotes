# AbstractCollection #

## 说明 ##

AbstractCollection是一个抽象类，它实现了Collection中除iterator()和size()之外的函数。
AbstractCollection的主要作用：它实现了Collection接口中的大部分函数。从而方便其它类实现Collection，比如ArrayList、LinkedList等，它们这些类想要实现Collection接口，通过继承AbstractCollection就已经实现了大部分的接口了。


## 方法 ##

### iterator() ###

### size() ###

### isEmpty() ###
<pre>
public boolean isEmpty() {
        return size() == 0;
    }
</pre>

### contains() ###

