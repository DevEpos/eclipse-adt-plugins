package com.devepos.adt.base.util;

/**
 * Utilities for all objects
 *
 * @author stockbal
 */
public class ObjectUtil {

    /**
     * Indicates if {@code obj1} is "equal to" {@code obj2}
     *
     * @param obj1 the first object
     * @param obj2 the second object
     * @return {@code true} if both objects are equal
     */
    public static boolean equals(final Object obj1, final Object obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null && obj2 != null) {
            return false;
        } else if (obj2 == null && obj1 != null) {
            return false;
        } else {
            return obj1.equals(obj2);
        }
    }
}
