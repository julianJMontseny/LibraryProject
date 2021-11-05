package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Book;

import org.iesfm.library.dao.BookDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBookDAO implements BookDAO {

    private NamedParameterJdbcTemplate jdbc;

    private static final String SELECT_BOOK_BY_YEAR = "SELECT * FROM BOOK WHERE year = :year ";
    private static final String SELECT_BOOK_AUTHOR = "SELECT * FROM book WHERE author = :author";
    private final static String SELECT_BOOKS = "SELECT * FROM book";
    private final static String MODIFY_BOOK = "UPDATE book SET title = :title, author = :author, year = :year WHERE isbn = :isbn";
    private final static String INSERT_BOOK = "INSERT INTO Book(" +
            " isbn, " +
            " title, " +
            " author, " +
            " year" +
            ") " +
            "VALUES(" +
            " :isbn, " +
            " :title, " +
            " :author, " +
            " :year" +
            ")";


    public JDBCBookDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void bookModify(Book book) {
        Map<String, Object> params = new HashMap<>();

        params.put("title", book.getTitle());
        params.put("author", book.getAuthor());
        params.put("year", book.getYear());
        params.put("isbn", book.getIsbn());

        jdbc.update(MODIFY_BOOK, params);

    }

    @Override
    public List<Book> bookListByYear(int year) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);

        return jdbc.query(SELECT_BOOK_BY_YEAR, params, ((rs, rowNum) -> new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year")
        )));
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("isbn", book.getIsbn());
        params.put("title", book.getTitle());
        params.put("author", book.getAuthor());
        params.put("year", book.getYear());
        jdbc.update(INSERT_BOOK, params);
    }


    public List<Book> lookForBookWithAuthor(String author) {
        Map<String, Object> params = new HashMap<>();
        params.put("author", author);
        return jdbc.query(SELECT_BOOK_AUTHOR, params, (rs, n) -> new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year")

        ));
    }


    @Override
    public List<Book> listAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_BOOKS,
                (rs, rowNum) ->
                        new Book(
                                rs.getString("isbn"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getInt("year")
                        )
        );
    }
}


