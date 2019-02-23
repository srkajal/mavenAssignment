package org.kajal.mallick.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kajal.mallick.entities.Book;
import org.kajal.mallick.entities.Subject;
import org.kajal.mallick.model.BookDto;
import org.kajal.mallick.model.SearchBook;
import org.kajal.mallick.model.SearchSubject;
import org.kajal.mallick.service.ReadWriteOperation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class SubjectControllerTest {
    @InjectMocks
    private SubjectController subjectController;

    @Mock
    private ReadWriteOperation readWriteOperation;

    @Mock
    private Model model;

    @Mock
    private Book book;

    @Mock
    private Subject subject;

    @Mock
    private BindingResult bindingResult;

    private List<Book> books;

    private List<Subject> subjects;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        books = Collections.singletonList(book);
        subjects = Collections.singletonList(subject);
    }

    @Test
    public void searchForm() {

        assertEquals("search", subjectController.searchForm());
    }

    @Test
    public void deleteBook() {

        doNothing().when(readWriteOperation).deleteBook(anyString());

        assertEquals("redirect:/", subjectController.deleteBook("id"));
    }

    @Test
    public void deleteSubject() {

        doNothing().when(readWriteOperation).deleteSubject(anyString());

        assertEquals("redirect:/", subjectController.deleteSubject("id"));
    }

    @Test
    public void saveSubjectSuccess() {

        when(bindingResult.hasErrors()).thenReturn(false);
        doNothing().when(readWriteOperation).addSubject(any(Subject.class));

        assertEquals("redirect:/", subjectController.saveSubject(subject, bindingResult, model));
    }

    @Test
    public void saveSubjectError() {

        when(bindingResult.hasErrors()).thenReturn(true);

        assertEquals("subject", subjectController.saveSubject(subject, bindingResult, model));
    }

    @Test
    public void saveBookSuccess() {

        BookDto bookDto = mock(BookDto.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(bookDto.getSubjectId()).thenReturn(1);
        when(bookDto.getVolume()).thenReturn(1);
        when(bookDto.getPublishDate()).thenReturn(LocalDate.now());
        doNothing().when(readWriteOperation).addBook(any(Book.class), anyLong());

        assertEquals("redirect:/", subjectController.saveBook(bookDto, bindingResult, model));
    }
    @Test
    public void saveBookError() {

        when(bindingResult.hasErrors()).thenReturn(true);

        assertEquals("subject", subjectController.saveBook(new BookDto(), bindingResult, model));
    }

    @Test
    public void searchSubject() {
        SearchSubject searchSubject = mock(SearchSubject.class);

        when(bindingResult.hasErrors()).thenReturn(false);
        when(readWriteOperation.searchSubjects(anyString())).thenReturn(new ArrayList<>());
        assertEquals("search", subjectController.searchSubject(searchSubject, bindingResult, model));
    }

    @Test
    public void searchSubjectError() {
        SearchSubject searchSubject = mock(SearchSubject.class);

        when(bindingResult.hasErrors()).thenReturn(true);
        assertEquals("search", subjectController.searchSubject(searchSubject, bindingResult, model));
    }

    @Test
    public void searchBook() {
        SearchBook searchBook = mock(SearchBook.class);

        when(bindingResult.hasErrors()).thenReturn(false);
        when(readWriteOperation.searchBooks(anyString())).thenReturn(new ArrayList<>());
        assertEquals("search", subjectController.searchBook(searchBook, bindingResult, model));
    }

    @Test
    public void searchBookError() {
        SearchBook searchBook = mock(SearchBook.class);

        when(bindingResult.hasErrors()).thenReturn(true);
        assertEquals("search", subjectController.searchBook(searchBook, bindingResult, model));
    }

    @Test
    public void formBackingSubject() {
        assertEquals(0, subjectController.formBackingSubject().getDurationInHours());
    }

    @Test
    public void formBackingSearchSubject() {
        assertEquals(null, subjectController.formBackingSearchSubject().getSubtitle());
    }

    @Test
    public void formBackingBook() {
        assertEquals(null, subjectController.formBackingBook().getVolume());
    }
}