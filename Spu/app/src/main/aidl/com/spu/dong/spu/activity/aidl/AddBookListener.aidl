// AddBookListener.aidl
package com.spu.dong.spu.activity.aidl;
import com.spu.dong.spu.activity.aidl.Book;
// Declare any non-default types here with import statements

interface AddBookListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   void addOneBook(in Book book);
}
