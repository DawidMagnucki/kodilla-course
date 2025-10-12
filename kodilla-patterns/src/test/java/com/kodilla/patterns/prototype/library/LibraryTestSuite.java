package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("Library");
        library.getBooks().add(new Book("Book 1", "Author A", LocalDate.of(2000, 1, 1)));
        library.getBooks().add(new Book("Book 2", "Author B", LocalDate.of(2005, 5, 10)));
        library.getBooks().add(new Book("Book 3", "Author C", LocalDate.of(2010, 3, 15)));

        Library shallowLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Library deepLibrary = null;
        try {
            deepLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        //when
        library.getBooks().add(new Book("Book 4", "Author d", LocalDate.of(2015, 6, 20)));

        //then
        System.out.println("Original Library: " + library.getBooks());
        System.out.println("Shallow Library: " + shallowLibrary.getBooks());
        System.out.println("Deep Library: " + deepLibrary.getBooks());

        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowLibrary.getBooks().size());
        assertEquals(3, deepLibrary.getBooks().size());

    }
}
