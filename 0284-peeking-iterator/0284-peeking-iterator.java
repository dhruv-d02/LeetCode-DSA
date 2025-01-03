// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> list;
    int currIndex;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        currIndex = 0;
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(currIndex);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int val = list.get(currIndex);
        currIndex++;
        return val;
    }

    @Override
    public boolean hasNext() {
        return currIndex<list.size();
    }
}