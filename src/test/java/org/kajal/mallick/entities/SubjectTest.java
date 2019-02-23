package org.kajal.mallick.entities;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class SubjectTest {

    @InjectMocks
    private Subject subject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSubject() {
        long subjectId = 1l;
        String subtitle = "title1";
        int durationInHours = 15;


        subject.setDurationInHours(durationInHours);
        subject.setSubtitle(subtitle);
        subject.setSubjectId(subjectId);

        assertEquals(subjectId, subject.getSubjectId());
        assertEquals(subtitle, subject.getSubtitle());
        assertNull(subject.getReferences());
        assertEquals(durationInHours, subject.getDurationInHours());

    }

    @Test
    public void equals() {
        Subject subject1 = new Subject();
        subject1.setSubjectId(1);
        Subject subject2 = new Subject();
        subject2.setSubjectId(1);

        assertTrue(subject1.equals(subject2));
    }

    @Test
    public void testHashCode() {
        Subject subject1 = new Subject();
        subject1.setSubjectId(1);
        assertTrue(subject1.hashCode()>0);
    }

    @Test
    public void testToString() {
        assertNotNull(new Subject().toString());
    }
}