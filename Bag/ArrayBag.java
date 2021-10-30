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
        E entry = removeEntry(numOfEntries - 1);
        return entry;
    }// end remove

    @Override
    public boolean remove(E anEntry) {
        checkInitialization();
        int idx = getIndexOf(anEntry);
        E entry = removeEntry(idx);
        return entry.equals(anEntry);
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

    private E removeEntry(int index){
        E entry = null;
        if(!isEmpty() && (index >= 0)){
            entry = bag[index];
            bag[index] = bag[numOfEntries - 1];
            bag[numOfEntries - 1] = null;
            numOfEntries--;
        }
        return entry;
    }

    private int getIndexOf(E anEntry){
        int location = -1;
        boolean found = false;
        int index = 0;
        while(!found && (index < numOfEntries)){
            if(anEntry.equals(bag[index])){
                found = true;
                location = index;
            }
            index++;
        }
        return location;
    }
}// end ArrayBag
