# Effective Java

## Creating and Destroying Objects

- AutoCloseable 接口
- Some Java library classes, such as FileInputStream, FileOutputStream, ThreadPoolEx-ecutor, and java.sql.Connection,
  have finalizers that serve as safety nets
- 非静态内部类(nonstatic nested classes contain references to their enclosing instances)

## Methods Common to All Objects

- The equals method implements an equivalence relation
- Favor composition over inheritance
- Always override hashCode when you override equals (Item 11).
- HashMap has an optimization that caches the hash code associated with each entry and doesn’t bother checking for
  object equality if the hash codes don’t match
- A nice property of 31 is that the multiplication can be replaced by a shift and a subtraction for better performance
  on some architectures: 31 * i == (i << 5) - i.
- Interface-based copy constructors and factories, more properly known as conversion constructors and conversion
  factories, allow the client to choose the implementation type of the copy rather than forcing the client to accept the
  implementation type of the original.
- It is strongly recommended, but not required, that (x.compareTo(y) == 0) == (x.equals(y)).
- Comparator.thenComparing(Comparator<? super T> other) 方法的一些启示

## Classes and Interfaces

- An immutable class is simply a class whose instances cannot be modified. All of the information contained in each
  instance is fixed for the lifetime of the object, so no changes can ever be observed. 
- 委托的定义
