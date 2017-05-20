# Iterator 和 ListIterator 的区别 #

## 方法比较 ##

### Iterator ###

- `hashNext` *如果能够迭代出更多的元素，那么就返回true*
- `next` *返回迭代的下一个元素。*
- `remove` *移除当前迭代元素*


### ListIterator ###

- `hashNext` 
- `next` 
- `remove` 
- `hasPrevious` *如果能够逆向迭代出更多的元素，那么就返回true。应用于lastIndexOf（）方法*
- `previous` *返回逆向迭代的下一个元素*
- `nextIndex` *返回迭代元素的索引,通过 `next()`调用*
- `previousIndex` *返回迭代元素的索引，通过`previous()`调用*
- `set` *可以对迭代的元素执行修改操作*
- `add` *想迭代的元素中增加元素*


## 代码片段 ##

<pre>
public int indexOf(Object o) {
    ListIterator<E> it = listIterator();
    if (o==null) {
        //按照顺序输出迭代中元素
        while (it.hasNext())
            //如果当前元素与迭代元素相等，那么就返回迭代元素的索引。
            if (it.next()==null)
                return it.previousIndex();
    } else {
        while (it.hasNext())
            if (o.equals(it.next()))
                return it.previousIndex();
    }
    return -1;
}
</pre>

<pre>
public int lastIndexOf(Object o) {
    ListIterator<E> it = listIterator(size());
    if (o==null) {
        //按照逆序输出迭代元素
        while (it.hasPrevious())
            if (it.previous()==null)
                return it.nextIndex();
    } else {
        while (it.hasPrevious())
            if (o.equals(it.previous()))
                return it.nextIndex();
    }
    return -1;
}
</pre>


## 区别总结 ##

- ListIterator有add()方法，可以向List中添加对象，而Iterator不能

- ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历。但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。

- ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator 没有此功能。

- 都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。因为ListIterator的这些功能，可以实现对LinkedList等List数据结构的操作。