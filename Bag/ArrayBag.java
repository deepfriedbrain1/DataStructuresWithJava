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
    }// end getSize

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }// end isEmpty

    @Override
    public boolean add(E newEntry) {
        checkInitialization();
        boolean added = true;
        if(isArrayFull()){
            added = false;
        }else{
            bag[numOfEntries] = newEntry;
            numOfEntries++;
        }
        return added;
    }// end add

    @Override
    public E remove() {
        checkInitialization();
        E entry = null;
        if(numOfEntries > 0){
            entry = bag[numOfEntries -1];
            numOfEntries--;
        }
        return entry;
    }// end remove

    @Override
    public boolean remove(E anEntry) {
        return false;
    }// end remove

    @Override
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }// end clear

    @Override
    public int getFrequencyOf(E anEntry) {
        checkInitialization();
        int freq = 0;
        for(int idx = 0; idx < numOfEntries; idx++){
            if(anEntry.equals(bag[idx])){
                freq++;
            }
        }
        return freq;
    }// end getFrequencyOf

    @Override
    public boolean contains(E anEntry) {
        checkInitialization();
        boolean found = false;
        int idx = 0;
        while(!found && (idx < numOfEntries)){
            if(anEntry.equals(bag[idx])){
                found = true;
            }
            idx++;
        }
        return found;
    }// end contains

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
    }// end isArrayFull

    private void checkInitialization(){
        if(!initialized){
            throw new SecurityException("ArrayBag object is not initialized properly.");
        }
    }
}// end ArrayBag
