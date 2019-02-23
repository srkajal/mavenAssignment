package org.kajal.mallick.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kajal.mallick.dao.ReadWriteDao;
import org.kajal.mallick.entities.Book;
import org.kajal.mallick.entities.Subject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ReadWriteOperationImplTest {

    @InjectMocks
    private ReadWriteOperationImpl readWriteOperation;

    @Mock
    private Subject subject;

    @Mock
    private Book book;

    @Mock
    private ReadWriteDao readWriteDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addSubject() {
        doNothing().when(readWriteDao).saveSubject(any(Subject.class));
        readWriteOperation.addSubject(subject);
    }

    @Test
    public void addBook() {
        doNothing().when(readWriteDao).saveBook(any(Book.class), any(Subject.class));
        readWriteOperation.addBook(book, 1);
    }

    @Test
    public void deleteSubject() {
        doNothing().when(readWriteDao).removeSubject(anyLong());
        readWriteOperation.deleteSubject("1");
    }

    @Test
    public void deleteBook() {
        doNothing().when(readWriteDao).removeBook(anyLong());
        readWriteOperation.deleteBook("1");
    }

    @Test
    public void searchBooks() {
        Book book = new Book("title1", 500.00, 5, LocalDate.now());
        when(readWriteDao.findBooksByTitle(anyString())).thenReturn(Collections.singletonList(book));

        List<Book> books = readWriteOperation.searchBooks("title");

        assertNotNull(books);
        assertTrue(!books.isEmpty());
        assertEquals(500.00, books.get(0).getPrice(),0);
        assertEquals("title1", books.get(0).getTitle());
        assertEquals(5, books.get(0).getVolume().intValue());

    }

    @Test
    public void searchSubjects() {
        Subject subject = new Subject();
        subject.setSubtitle("title1");
        subject.setDurationInHours(10);

        when(readWriteDao.findSubjectsByTitle(anyString())).thenReturn(Collections.singletonList(subject));

        List<Subject> subjects = readWriteOperation.searchSubjects("title");

        assertNotNull(subjects);
        assertTrue(!subjects.isEmpty());
        assertEquals("title1", subjects.get(0).getSubtitle());
        assertEquals(10, subjects.get(0).getDurationInHours());
    }

    @Test
    public void findAllBooks() {
        Book book = new Book("title1", 500.00, 5, LocalDate.now());
        when(readWriteDao.findAllBooks()).thenReturn(Collections.singletonList(book));

        List<Book> books = readWriteOperation.findAllBooks();

        assertNotNull(books);
        assertTrue(!books.isEmpty());
        assertEquals(500.00, books.get(0).getPrice(),0);
        assertEquals("title1", books.get(0).getTitle());
        assertEquals(5, books.get(0).getVolume().intValue());
    }

    @Test
    public void findAllSubjects() {
        Subject subject = new Subject();
        subject.setSubtitle("title1");
        subject.setDurationInHours(10);


        when(readWriteDao.findAllSubjects()).thenReturn(Collections.singletonList(subject));
        List<Subject> subjects = readWriteOperation.findAllSubjects();

        assertNotNull(subjects);
        assertTrue(!subjects.isEmpty());
        assertEquals("title1", subjects.get(0).getSubtitle());
        assertEquals(10, subjects.get(0).getDurationInHours());

    }
}