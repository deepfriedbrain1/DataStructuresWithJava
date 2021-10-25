package DataStructuresWithJava.Bag;

public final class ArrayBag<E> implements BagInterface<E> {

    private final E[] bag;
    private int numOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10_000;

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }// end default constructor

    public ArrayBag(int capacity){
        if(capacity <= MAX_CAPACITY){
            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            E[] tempBag = (E[]) new Object[capacity];
            bag = tempBag;
            numOfEntries = 0;
            initialized = true;
        }else{
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }// end constructor

    @Override
    public int getSize() {
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean add(E newEntry) {
        boolean added = true;
        if(isArrayFull()){
            added = false;
        }else{
            bag[numOfEntries] = newEntry;
            numOfEntries++;
        }
        return added;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public boolean remove(E anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(E anEntry) {
        return 0;
    }

    @Override
    public boolean contains(E anEntry) {
        return false;
    }

    @Override
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[numOfEntries];
        for(int idx = 0; idx < numOfEntries; idx++){
            result[idx] = bag[idx];
        }
        return result;
    }// end toArray

    private boolean isArrayFull(){
        return numOfEntries >= bag.length;
    }
}
