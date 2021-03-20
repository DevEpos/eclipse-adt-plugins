package com.devepos.adt.base.util;

/**
 * This listener interface can be used to listen for modifications of any kind
 *
 * @author stockbal
 */
public interface IModificationListener<T> {

    /**
     * The type of a modifcation
     *
     * @author stockbal
     */
    public enum ModificationKind {
        /**
         * All properties were cleared
         */
        CLEARED,
        /**
         * The entry was added
         */
        ADDED,
        /**
         * The entry was removed
         */
        REMOVED,
        /**
         * The entry was updated
         */
        UPDATED
    }

    /**
     * Tells the subscriber of a modification. The <code>kind</code> tells the
     * subscriber of the kind of the modification that occurred
     *
     * @param kind the kind of the modification event
     */
    void modified(ModificationKind kind);

    /**
     * Notfies subscriber of modification.
     * 
     * @param entry            the entry that has been modified
     * @param modificationKind the type of modification that took place
     */
    void modified(T entry, ModificationKind modificationKind);

}
