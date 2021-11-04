package org.iesfm.library;

import java.util.Date;
import java.util.Objects;

public class BookLend {
    private String nif;
    private String isbn;
    private Date lendDate;
    private Date returnDate;
    private String statusName;

    public BookLend(String nif, String isbn, Date lendDate, Date returnDate, String statusName) {
        this.nif = nif;
        this.isbn = isbn;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.statusName = statusName;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return Objects.equals(nif, bookLend.nif) && Objects.equals(isbn, bookLend.isbn) && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(returnDate, bookLend.returnDate) && Objects.equals(statusName, bookLend.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, isbn, lendDate, returnDate, statusName);
    }

    @Override
    public String toString() {
        return "BookLend{" +
                "nif='" + nif + '\'' +
                ", isbn='" + isbn + '\'' +
                ", lendDate=" + lendDate +
                ", returnDate=" + returnDate +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
