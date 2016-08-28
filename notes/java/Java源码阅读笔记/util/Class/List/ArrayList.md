# ArrayList #

ArrayList底层有object[]组成，初始化容量为10，可以通过`ArrayList(int initialCapacity)`和`ArrayList(Collection<? extends E> c)`进行初始化。

## 变量 ##

> `transient Object[] elementData`    用于存储arraylist的缓存区，此处的transient标识elementData属性不需要自动序列化。

> `int size`    数组的长度

## 不理解点 ##

### ensureCapacity ###

<pre>
    /**
     *如有必要，增加此 ArrayList 实例的容量，
     *以确保它至少能够容纳最小容量参数所指定的元素数。
     * @param   minCapacity   the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > 0)
            ensureCapacityInternal(minCapacity);
    }

    private void ensureCapacityInternal(int minCapacity) {
        //此参数引用了abstractList中的属性，用于记录ArrayList结构性变化的次数。
        //protected transient int modCount = 0;
        modCount++;
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
</pre>


<pre>
    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        //>>表示每次扩容原长度的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        //>> minCapacity 表示估算的最接近需要扩容的长度
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
</pre>

clone

toArray

remove

Arrays.copyOf(elementData, size);