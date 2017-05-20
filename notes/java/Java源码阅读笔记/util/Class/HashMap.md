# HashMap #

HashMap底层由散列表组成，可以完成高效的插入和查询功能，但是不适合遍历操作。

HashMap是非线性安全的，只是用于单线程环境下，多线程环境下可以采用concurrent并发包下的concurrentHashMap。

### 变量 ###

<pre>
//初始容量，大小必须为2的幂次方
static final int DEFAULT_INITIAL_CAPACITY = 16;

/**
 * The maximum capacity, used if a higher value is implicitly specified
 * by either of the constructors with arguments.
 * MUST be a power of two <= 1<<30.
 */
static final int MAXIMUM_CAPACITY = 1 << 30;

//默认加载因子为0.75
//
static final float DEFAULT_LOAD_FACTOR = 0.75f;

/**
 * The table, resized as necessary. Length MUST Always be a power of two.
 */
transient Entry[] table;

/**
 * The number of key-value mappings contained in this map.
 */
transient int size;

/**
 * The next size value at which to resize (capacity * load factor).
 * @serial
 */
int threshold;

/**
 * The load factor for the hash table.
 *
 * @serial
 */
final float loadFactor;

/**
 * The number of times this HashMap has been structurally modified
 * Structural modifications are those that change the number of mappings in
 * the HashMap or otherwise modify its internal structure (e.g.,
 * rehash).  This field is used to make iterators on Collection-views of
 * the HashMap fail-fast.  (See ConcurrentModificationException).
 */
transient int modCount;
</pre>

### Map.Entry ###

Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue()等方法。

Map类提供了一个称为entrySet()的方法，这个方法返回一个Map.Entry实例化后的对象集，然后就可以如下方法遍历map集合

<pre>
Set entries = map.entrySet( );
if(entries != null) {
    Iterator iterator = entries.iterator( );
    while(iterator.hasNext( )) {
    Map.Entry entry =iterator.next( );
    Object key = entry.getKey( );
    Object value = entry.getValue();
  }
}
</pre>

## 参考资料 ##
[1、HashMap源码剖析](http://www.importnew.com/20321.html)

[2、Java运算符](http://www.runoob.com/java/java-operators.html)

