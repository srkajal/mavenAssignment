package org.kajal.mallick.dao;

import org.kajal.mallick.entities.Book;
import org.kajal.mallick.entities.Subject;

import java.util.List;

public interface ReadWriteDao {

    List<Book> findAllBooks();

    List<Subject> findAllSubjects();

    List<Book> findBooksByTitle(String bookTitle);

    List<Subject> findSubjectsByTitle(String subjectTitle);

    Subject findSubjectById(Long subjectId);

    Book findBookById(Long bookId);

    void saveSubject(Subject subject);

    void saveBook(Book book, Subject subject);

    void removeBook(Long bookId);

    void removeSubject(Long subjectID);
}
