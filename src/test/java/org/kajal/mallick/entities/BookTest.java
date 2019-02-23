package org.kajal.mallick.entities;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BookTest {

    @InjectMocks
    private Book book;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBook() {
        long bookId = 1l;
        String title = "title1";
        double price = 500.00;
        Integer volume = 5;
        LocalDate publishDate = LocalDate.now();
        Subject subject = new Subject();
        subject.setSubjectId(2l);


        book.setBookId(bookId);
        book.setTitle(title);
        book.setPrice(price);
        book.setVolume(volume);
        book.setPublishDate(publishDate);
        book.setSubject(subject);

        assertEquals(bookId, book.getBookId());
        assertEquals(title, book.getTitle());

        assertEquals(price, book.getPrice(), 0);

        assertEquals(volume, book.getVolume());
        assertEquals(publishDate, book.getPublishDate());

        assertEquals(subject.getSubjectId(), book.getSubject().getSubjectId());

    }

    @Test
    public void equals() {
        Book book1 = new Book();
        book1.setBookId(3l);
        Book book2 = new Book();
        book2.setBookId(3l);

        assertTrue(book1.equals(book2));
    }

    @Test
    public void testHashCode() {
        Book book1 = new Book();
        book1.setBookId(3l);
        assertTrue(book1.hashCode()>0);
    }

    @Test
    public void testToString() {
        assertNotNull(new Book().toString());
    }
}