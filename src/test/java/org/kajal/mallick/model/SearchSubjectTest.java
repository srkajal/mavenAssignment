package org.kajal.mallick.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class SearchSubjectTest {
    @InjectMocks
    private SearchSubject searchSubject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSubtitle() {
        String subTitle = "title1";
        searchSubject.setSubtitle(subTitle);
        assertEquals(subTitle,searchSubject.getSubtitle());
    }

}