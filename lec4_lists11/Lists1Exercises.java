package lec4_lists11;

public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList_a(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return  null;
        }
        IntList new_list = new IntList(x + L.first, null);
        IntList ptr = new_list;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(x + L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return new_list;
    }

    /**  解法2*/
    public static IntList incrList_b(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return  null;
        }
        IntList new_list = new IntList(x + L.first, null);
        new_list.rest =  incrList_b(L.rest, x);
        return new_list;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList ptr = L;
        while (ptr != null){
            ptr.first += x;
            ptr = ptr.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        System.out.println(incrList_a(L, 3));
        System.out.println(dincrList(L, 3));
    }
}