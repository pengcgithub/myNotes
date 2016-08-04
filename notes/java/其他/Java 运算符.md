# Java 运算符 #

- **<< : 左移运算符，num << 1,相当于num乘以2**

<pre>

</pre>


- **>> : 右移运算符，num >> 1,相当于num除以2**

<pre>
private void grow(int minCapacity) {
    int oldCapacity = elementData.length;
    //此处用到的 >> 表示除以二，此段代码即为ArrayList中扩容的方倍法，每次扩容1.5.
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
</pre>

- **>>> : 无符号右移，忽略符号位，空位都以0补齐**

<pre>

</pre>