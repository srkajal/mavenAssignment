package org.kajal.mallick.dao;

import org.junit.Before;
import org.junit.Test;
import org.kajal.mallick.entities.Book;
import org.kajal.mallick.entities.Subject;
import org.kajal.mallick.repositories.BookRepository;
import org.kajal.mallick.repositories.SubjectRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ReadWriteDaoImplTest {

    @InjectMocks
    private ReadWriteDaoImpl readWriteDao;

    @Mock
    private SubjectRepository subjectRepositories;

    @Mock
    private BookRepository bookRepositories;

    private Book book;

    private Subject subject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        book = new Book();
        book.setBookId(1);
        subject = new Subject();
        subject.setSubjectId(2);
    }

    @Test
    public void findAllBooks() {
        when(bookRepositories.findAll()).thenReturn(Collections.singletonList(book));
        assertEquals(book.getBookId(), readWriteDao.findAllBooks().get(0).getBookId());
    }

    @Test
    public void findAllSubjects() {
        when(subjectRepositories.findAll()).thenReturn(Collections.singletonList(subject));
        assertEquals(subject.getSubjectId(), readWriteDao.findAllSubjects().get(0).getSubjectId());
    }

    @Test
    public void findBooksByTitle() {
        when(bookRepositories.findByTitleIgnoreCaseContaining(anyString())).thenReturn(Collections.singletonList(book));

        assertEquals(book.getBookId(), readWriteDao.findBooksByTitle("title").get(0).getBookId());
    }

    @Test
    public void findSubjectsByTitle() {
        when(subjectRepositories.findBySubtitleIgnoreCaseContaining(anyString())).thenReturn(Collections.singletonList(subject));
        assertEquals(subject.getSubjectId(), readWriteDao.findSubjectsByTitle("title").get(0).getSubjectId());
    }

    @Test
    public void findSubjectById() {
        when(subjectRepositories.findById(anyLong())).thenReturn(subject);
        assertEquals(subject.getSubjectId(), readWriteDao.findSubjectById(1l).getSubjectId());
    }

    @Test
    public void findBookById() {
        when(bookRepositories.findById(anyLong())).thenReturn(book);

        assertEquals(book.getBookId(), readWriteDao.findBookById(1l).getBookId());
    }

    @Test
    public void saveSubject() {
        when(subjectRepositories.save(any(Subject.class))).thenReturn(subject);
        readWriteDao.saveSubject(new Subject());
    }

    @Test
    public void saveBook() {
        when(bookRepositories.save(any(Book.class))).thenReturn(book);
        readWriteDao.saveBook(new Book(), new Subject());
    }

    @Test
    public void removeBook() {
        doNothing().when(bookRepositories).deleteByBookId(anyLong());
        readWriteDao.removeBook(1l);
    }

    @Test
    public void removeSubject() {
        doNothing().when(subjectRepositories).deleteBySubjectId(anyLong());
        readWriteDao.removeSubject(1l);
    }
}