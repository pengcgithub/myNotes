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
添加方法
<pre>
Node<E> pred, succ
pred : 指向当前操作的节点,相当于一个游标.
succ : 标识插入的位置的节点

public boolean addAll(int index, Collection<? extends E> c) {
    //检查是否越界
    checkPositionIndex(index);

    //集合转换为数组，并判断如果数组为零的话则直接return false；
    Object[] a = c.toArray();
    int numNew = a.length;
    if (numNew == 0)
        return false;

    //pred ： 此节点位置的后面插入新的节点
    //succ ： 此节点的前面位置插入节点
    Node<E> pred, succ;

    //如果插入的下标等于集合的长度，则表示在集合末端插入元素
    if (index == size) {	//最后一个节点
        succ = null;
        pred = last;
    } else {
        succ = node(index);
        pred = succ.prev;
    }

    for (Object o : a) {
        @SuppressWarnings("unchecked") E e = (E) o;
        Node<E> newNode = new Node<>(pred, e, null);
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        pred = newNode;
    }

    if (succ == null) {
        last = pred;
    } else {
        pred.next = succ;
        succ.prev = pred;
    }

    size += numNew;
    modCount++;
    return true;
}
</pre>



## 参考资料 ##

- [Java集合干货系列-（二）LinkedList源码解析](http://www.jianshu.com/p/681802a00cdf)