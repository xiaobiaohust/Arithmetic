package ThinkInJava;

import java.util.*;

/**
 * 容器类
 */
public class containers {
    /**
     * Collection 是描述所有序列容器的共性的根接口
     * List：包括ArrayList、LinkedList，按照插入顺序保存元素，LinkedList支持的操作更多
     * ArrayList：长于随机访问元素，在list中插入和删除元素时比较慢
     * LinkedList：在list中插入和删除进行了优化，但是随机访问相对较慢
     * 方法：
     * 1：contains、containsAll
     * 2：add、get、remove、isEmpty、clear
     * 3：sublist、shuffle、toArray、indexOf
     */
    /**
     * LinkedList
     * 1：LinkedList像ArrayList一样实现了基本的List接口，执行某些操作时更高效，但是在随机访问方面差一点
     * 2：LinkedList添加了可以使其用作栈、队列、双端队列的方法，可以使用LinkedList实现栈等
     * getFirst、element、peek
     * removeFirst、remove、poll、removeLast
     * addFirst、add、addLast
     *
     */
    public static void f1() {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        //collection.addAll只能接受一个collection对象，无法接受数组等，所以需要转一下
        collection.addAll(Arrays.asList(moreInts));
        // Collections.addAll可接受可变参数，还可接受数组，更加灵活.首选该方式
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        //Arrays.asList 的输出是一个List，但是底层依然是一个数组，无法add和delete
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 10);
        System.out.println(list);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("sad", "asdas", "sdasdvds", "hrtsdf"));
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        Iterator<String>iter = arrayList.iterator();
        while (iter.hasNext()){
            String item = iter.next();
            System.out.println(item);
        }

        LinkedList<String>linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList("sad", "asdas", "sdasdvds", "hrtsdf"));
        System.out.println(linkedList.poll());

    }

    /**
     * Stack:可以用LinkedList实现栈的所有功能
     */
    public static class StatckTest<T>{
        private LinkedList<T>storage = new LinkedList<>();
        public void push(T v){
            storage.addFirst(v);
        }
        public T peek(){
            return storage.getFirst();
        }
        public T pop(){
            return storage.removeFirst();
        }
        public boolean isEmpty(){
            return storage.isEmpty();
        }

    }




    /**
     * Set
     * HashSet：获取元素最快，无序；
     * TreeSet：按照比较结果升序存储；
     * LinkedHashSet：按照元素添加的顺序存储
     * 1：查找是set中最重要的操作，因此通常选择HashSet
     * 2：set和collection具有完全一样的接口
     * remove、removeAll、add、contains
     */
    public static void f2() {
        Set<Integer> set0 = new HashSet<>();
        set0.add(1);
        set0.add(12);
        set0.add(10);
        System.out.println(set0);


        SortedSet<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(10);
        set1.add(3);
        System.out.println(set1);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(212);
        set2.add(12);
        set2.add(3242);
        System.out.println(set2);
    }


    /**
     * Map：HashMap、TreeMap、LinkedHashMap
     * HashMap：获取元素最快，无序
     * TreeMap：按照比较结果的升序存储
     * LinkedHashMap：按照插入顺序存储
     * put、containsKey、containsValue
     * keySet、
     */
    public static void f3() {
        Map<String, String> map = new HashMap<>();
        map.put("11", "111");
        map.put("22", "222");
        map.put("33", "333");
        System.out.println(map.containsKey("11"));
        System.out.println(map.containsKey("44"));

        System.out.println(map.containsValue("222"));
        System.out.println(map.containsValue("444"));
    }

    /**
     * Queue
     * LinkedList实现了Queue接口，因此LinkedList可以用作Queue的一种实现，通过将LinkedList向上转型为Queue
     */
    public static void f4(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
    }

    public static void main(String[] args) {
        f1();
     /*   f2();
        f3();*/
    }
}
