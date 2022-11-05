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
        Job testJob = new Job("Job test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n',testJob.toString().charAt(0));
        assertEquals('\n',testJob.toString().charAt(testJob.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test = new Job("Job test", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //int testId = 1;
       assertEquals("\nID: " + test.getId() + "\n" +
               "Name: " + test.getName() + "\n" +
               "Employer: " + test.getEmployer() + "\n" +
               "Location: " + test.getLocation() + "\n" +
               "Position Type: " + test.getPositionType() + "\n" +
               "Core Competency: " + test.getCoreCompetency() + "\n", test.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job emptyTest = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + emptyTest.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n", emptyTest.toString());;
    }


}
