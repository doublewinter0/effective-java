# Effective Java

## Creating and Destroying Objects

- AutoCloseable 接口
- Some Java library classes, such as FileInputStream, FileOutputStream, ThreadPoolExecutor, and java.sql.Connection,
  have finalizers that serve as safety nets
- 非静态内部类(nonstatic nested classes contain references to their enclosing instances)

## Methods Common to All Objects

- The equals method implements an equivalence relation
- Favor composition over inheritance
- Always override hashCode when you override equals (Item 11)
- HashMap has an optimization that caches the hash code associated with each entry and doesn’t bother checking for
  object equality if the hash codes don’t match
- A nice property of 31 is that the multiplication can be replaced by a shift and a subtraction for better performance
  on some architectures: 31 * i == (i << 5) - i
- Interface-based copy constructors and factories, more properly known as conversion constructors and conversion
  factories, allow the client to choose the implementation type of the copy rather than forcing the client to accept the
  implementation type of the original.
- It is strongly recommended, but not required, that (x.compareTo(y) == 0) == (x.equals(y)).
- Comparator.thenComparing(Comparator<? super T> other) 方法的一些启示

## Classes and Interfaces

- An immutable class is simply a class whose instances cannot be modified. All of the information contained in each
  instance is fixed for the lifetime of the object, so no changes can ever be observed
- 委托的定义
- It is permissible, though relatively rare, for a type parameter to be bounded by some expression involving that type
  parameter itself. This is what’s known as a recursive type bound(Using a recursive type bound to express mutual
  comparability)
- 泛型不支持 covariant, 如果支持会有什么后果?
- For maximum flexibility, use wildcard types on input parameters that represent producers or consumers
- public static <T extends Comparable<? super T>> T max(List<? extends T> list)
- if a type parameter appears only once in a method declaration, replace it with a wildcard
- it is unsafe to store a value in a generic varargs array parameter
- it is unsafe to give another method access to a generic varargs parameter array
- toArray(T... args) 为什么不安全?(P147)
- an annotated element is a typesafe heterogeneous container whose keys are annotation types
- Enum constructors aren’t permitted to access the enum’s static fields, with the exception of constant variables
- Use enums any time you need a set of constants whose members are known at compile time

## Lambdas and Streams

| Interface         | Function Signature  | Example             |
|:------------------|:--------------------|:--------------------|
| UnaryOperator<T>  | T apply(T t)        | String::toLowerCase |
| BinaryOperator<T> | T apply(T t1, T t2) | BigInteger::add     |
| Predicate<T>      | R apply(T t)        | Arrays::asList      |
| Function<T,R>     | T apply(T t1, T t2) | BigInteger::add     |
| Supplier<T>       | T get()             | Instant::now        |
| FConsumer<T>      | void accept(T t)    | System.out::println |

- Even under the best of circumstances, parallelizing a pipeline is unlikely to increase its performance if the source
  is from Stream.iterate, or the intermediate operation limit is used
- As a rule, performance gains from parallelism are best on streams over ArrayList, HashMap, HashSet, and
  ConcurrentHashMap instances; arrays; int ranges; and long ranges
- **selection among overloaded methods is static, while selection among overridden methods is dynamic**
- Container types, including collections, maps, streams, arrays, and optionals should not be wrapped in optionals.
- you should declare a method to return Optional<T> if it might not be able to return a result and clients will have to
  perform special processing if no result is returned

## General Programming

- Math.abs(Integer.MIN_VALUE)
- In nearly every case when you mix primitives and boxed primitives in an operation, the boxed primitive is auto-unboxed
- 