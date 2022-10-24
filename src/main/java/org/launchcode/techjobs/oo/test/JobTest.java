package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
         Job jobOne = new Job();
         Job jobTwo = new Job();
         assertNotEquals(jobOne, jobTwo);

    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testAllFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testAllFields.getName() instanceof String);
        assertTrue(testAllFields.getEmployer() instanceof Employer);
        assertTrue(testAllFields.getLocation() instanceof Location);
        assertTrue(testAllFields.getPositionType() instanceof PositionType);
        assertTrue(testAllFields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testAllFields.getName());
        assertEquals("ACME", testAllFields.getEmployer().getValue());
        assertEquals("Desert", testAllFields.getLocation().getValue());
        assertEquals("Quality control", testAllFields.getPositionType().getValue());
        assertEquals("Persistence", testAllFields.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality(){
        Job jobOne = new Job("Job test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Job test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne == jobTwo);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job();
        assertEquals("\nID:  _______\n" +
                "Name: _______\n" +
                "Employer: _______\n" +
                "Location: _______\n" +
                "Position Type: _______\n" +
                "Core Competency: _______\n", testJob.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test = new Job("Job test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertEquals("\nID:  1\n" +
               "Name: Job test\n" +
               "Employer: ACME\n" +
               "Location: Desert\n" +
               "Position Type: Quality control\n" +
               "Core Competency: Persistence\n", test.toString());
    }



}
