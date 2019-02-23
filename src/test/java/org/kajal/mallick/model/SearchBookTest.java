package org.kajal.mallick.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class SearchBookTest {

    @InjectMocks
    private SearchBook searchBook;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTitle() {
        String title = "title1";
        searchBook.setTitle(title);
        assertEquals(title,searchBook.getTitle());
    }
}