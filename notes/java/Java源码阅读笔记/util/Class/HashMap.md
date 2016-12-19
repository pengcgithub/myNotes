### HashMap ###

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
;....
}
}
</pre>

