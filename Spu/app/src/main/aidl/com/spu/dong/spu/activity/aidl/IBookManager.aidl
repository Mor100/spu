// IBookManager.aidl
package com.spu.dong.spu.activity.aidl;
import com.spu.dong.spu.activity.aidl.Book;
import com.spu.dong.spu.activity.aidl.AddBookListener;
// Declare any non-default types here with import statements

interface IBookManager {

    List<Book> getBookList();
    void addBook(in Book book);

    void registAddBookListener(in AddBookListener addBookListener);
    void unRegistAddBookListener(in AddBookListener addBookListener);


}
