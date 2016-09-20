# LinkedList源码解析 #

## 前言 ##


![LinkedList结构图](http://i.imgur.com/BK4SIft.png)

## 链表的概念 ##
双向循环链表和双向链表的不同在于，第一个节点的pre指向最后一个节点，最后一个节点的next指向第一个节点，也形成一个“环”。**而LinkedList就是基于双向循环链表设计的。**

![双向循环列表](http://i.imgur.com/AyRGVxL.jpg)

## 正文 ##

### 1、属性 ###

- transient int size = 0; 	//列表的长度
- transient Node<E> first; 	//列表的第一个元素
- transient Node<E> last;	//列表的最后一个元素

### 2、构造函数 ###

### 3、内部类 ###

<pre>
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
</pre>

### 4、方法 ###

#### addAll() ####

<pre>
Node<E> pred, succ
pred : 指向当前操作的节点,相当于一个游标.
succ : 标识插入的位置的点
</pre>



## 参考资料 ##

- [Java集合干货系列-（二）LinkedList源码解析](http://www.jianshu.com/p/681802a00cdf)