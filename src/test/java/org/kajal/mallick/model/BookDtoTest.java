package org.kajal.mallick.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BookDtoTest {

    @InjectMocks
    private BookDto bookDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBookDto() {
        long id = 1l;
        LocalDate localDate = LocalDate.now();
        Integer volume = 1;
        double price = 500.00;
        String title = "title1";
        Integer subjectId = 1;

        bookDto.setBookId(id);
        bookDto.setPublishDate(localDate);
        bookDto.setVolume(volume);
        bookDto.setPrice(price);
        bookDto.setTitle(title);
        bookDto.setSubjectId(subjectId);

        assertEquals(id,bookDto.getBookId());
        assertEquals(localDate,bookDto.getPublishDate());
        assertEquals(volume,bookDto.getVolume());
        assertEquals(price,bookDto.getPrice(),0);
        assertEquals(title,bookDto.getTitle());
        assertEquals(subjectId,bookDto.getSubjectId());
    }


}