# AbstractCollection #

![AbstractCollection](http://i.imgur.com/By2WpAW.png)

## 说明 ##

AbstractCollection是一个抽象类，它实现了Collection中除iterator()和size()之外的函数。
AbstractCollection的主要作用：它实现了Collection接口中的大部分函数。从而方便其它类实现Collection，比如ArrayList、LinkedList等，它们这些类想要实现Collection接口，通过继承AbstractCollection就已经实现了大部分的接口了。


## 方法 ##

### iterator() ###

- next() 返回当前元素，并指向下一个元素。
- hasNext()， 则是判断当前元素是否存在(`如果有元素可以迭代，则返回true`)，并指向下一个元素（即所谓的索引）
- remove() 移除当前元素，并指向下一个元素。


### size() ###

### isEmpty() ###
<pre>
    public boolean isEmpty() {
        return size() == 0;
    }
</pre>

### contains() ###

<pre>
    public boolean contains(Object o) {
	//=> 当前实现类对应的 Iterator
        Iterator<E> it = iterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }
</pre>

### toArray ###

<pre>
    public Object[] toArray() {
        // Estimate size of array; be prepared to see more or fewer elements
	//=> 根据集合大小，给定数组的初始长度。
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
	//=> 如果当前元素不存在，也就是出现比预期元素少的情况，那么就拷贝当前长度的数组返回。
            if (! it.hasNext()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return it.hasNext() ? finishToArray(r, it) : r;
    }
</pre>

### add ###

*没看懂是什么意思？*


### remove ###

<pre>
   /**
    * o==null ? e==null : o.equals(e)
    * @return 该元素存在当前collection集合中则返回true，否则就返回false。
    */
    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o==null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
</pre>


### containsAll ###
*判断当前集合是否包含指定集合的所有元素，如果包含则返回true，否则false。*

<pre>
public boolean containsAll(Collection<?> c) {
    for (Object e : c)
        if (!contains(e))
            return false;
    return true;
}
</Pre>


### toString ###

<pre>
public String toString() {
    Iterator<E> it = iterator();
    if (! it.hasNext())
        return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
        E e = it.next();
        sb.append(e == this ? "(this Collection)" : e);
        if (! it.hasNext())
            return sb.append(']').toString();
        sb.append(',').append(' ');
    }
}
</pre>
