package DataStructuresWithJava.Bag;

/**
 * An interface that specifies the operations of a bag.
 * @param <E>
 */
public interface BagInterface<E> {
    /**
     * Get the current number of entries in the bag.
     * @return an integer that specifies the current number of entries in the bag.
     */
    public int getSize();

    /**
     * Checks if bag is empty.
     * @return true if bag is empty otherwise returns false.
     */
    public boolean isEmpty();

    /**
     * Add a new entry to this bag.
     * @param newEntry the object to add to the bag.
     * @return true if the object was added to the bag otherwise false.
     */
    public boolean add(E newEntry);

    /**
     * If possible, removes an unspecified object from the bag.
     * @return the entry that was removed or null.
     */
    public E remove();

    /**
     * Removes the specified object if found in the bag.
     * @param anEntry the specified object to be removed.
     * @return true if the speficied object was removed otherwise false.
     */
    public boolean remove(E anEntry);

    /**
     * Removes all entries contained in the bag.
     */
    public void clear();

    /**
     * Count the number of times a specified entry occurs within the bag.
     * @param anEntry to be counted.
     * @return an integer specifying the count of an entry.
     */
    public int getFrequencyOf(E anEntry);

    /**
     * Checks to see if an entry is contained in the bag.
     * @param anEntry the specific entry to check the bag for.
     * @return true if the entry was found otherwise false.
     */
    public boolean contains(E anEntry);

    /**
     * Obtains all entries contained in the bag.
     * @return an array of all entries.
     */
    public E[] toArray();

}// end of BagInterface