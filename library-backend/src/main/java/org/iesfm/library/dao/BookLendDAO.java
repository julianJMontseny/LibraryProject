package org.iesfm.library.dao;

import org.iesfm.library.BookLend;

import java.util.List;

public interface BookLendDAO {
    void insert(BookLend bookLend);

    public List<BookLend> listBookLendByNif(String nif);
}
