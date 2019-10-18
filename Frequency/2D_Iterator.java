//• boolean hasNext() return true if there is another element in the set
//• int next() return the value of the next element in the array
//• void remove() o remove the last element returned by the iterator. That is, remove the element that the previous next() returned.
//  This method can be called only once per call to next(), otherwise an exception will be thrown.

//举个例子： 如果函数被 call 的顺序是这样的：hasnext() getnext() hasnext() getnext() remove()
// 假设 data 是 ［［1，2］［3］］ 那么返回 true, 1, true, 2, data 变为 [[1], [3]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);

        list.add(list1);
        list.add(new ArrayList<Integer>());
        list.add(list2);

        Vector2D vector = new Vector2D(list);

        System.out.println(vector.hasNext());
        System.out.println(vector.next());
        System.out.println(vector.next());
        System.out.println(vector.next());
        vector.remove();
        System.out.println(vector.next());
        System.out.println(vector.next());
        vector.remove();
        System.out.println(vector.hasNext());
        printList(list);
    }

    private static void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    static class Vector2D {

        private Iterator<List<Integer>> row;
        private Iterator<Integer> col;

        public Vector2D(List<List<Integer>> vec2d) {
            row = vec2d.iterator();
        }

        private int next() {
            hasNext();
            return col.next();
        }

        private boolean hasNext() {
            while ((col == null || !col.hasNext()) && row.hasNext())
                col = row.next().iterator();
            return col != null && col.hasNext();
        }

        private void remove() {
            col.remove();
        }
    }
}
