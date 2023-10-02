package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(), .001);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String aName = job1.getName();
        String anEmployer = job1.getEmployer().getValue();
        String aLocation = job1.getLocation().getValue();
        String aPositionType = job1.getPositionType().getValue();
        String aCoreCompetency = job1.getCoreCompetency().getValue();

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", aName);
        assertEquals("ACME", anEmployer);
        assertEquals("Desert", aLocation);
        assertEquals("Quality control", aPositionType);
        assertEquals("Persistence", aCoreCompetency);
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Banana counter", new Employer("Chiquita"), new Location("Zimbabwe"), new PositionType("Quality control"), new CoreCompetency("Counting"));
        Job job2 = new Job("Banana counter", new Employer("Chiquita"), new Location("Zimbabwe"), new PositionType("Quality control"), new CoreCompetency("Counting"));
        assertNotEquals(job1.getId(), job2.getId());
//        int id1 = job1.getId();
//        int id2 = job2.getId();
//        assertTrue(id1 != id2);
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job1 = new Job("Banana counter", new Employer("Chiquita"), new Location("Zimbabwe"), new PositionType("Quality control"), new CoreCompetency("Counting"));
        String testToString = job1.toString();
        String lineBreak = System.lineSeparator();
        List<String> jobList = Arrays.asList(testToString.split(lineBreak));
        assertEquals(jobList.get(0), " ");
        assertEquals(jobList.get(jobList.size() -1), " ");
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Banana counter", new Employer("Chiquita"), new Location("Zimbabwe"), new PositionType("Quality control"), new CoreCompetency("Counting"));
        String testToString = job1.toString();
        String lineBreak = System.lineSeparator();
        List<String> jobList = Arrays.asList(testToString.split(lineBreak));
        String jobID = "ID: " + job1.getId();
        String jobName = "Name: " + job1.getName();
        String jobEmployer = "Employer: " + job1.getEmployer();
        String jobLocation = "Location: " + job1.getLocation();
        String jobPositionType = "Position Type: " + job1.getPositionType();
        String jobCoreComp = "Core Competency: " + job1.getCoreCompetency();
        assertEquals(jobList.get(1), jobID);
        assertEquals(jobList.get(2), jobName);
        assertEquals(jobList.get(3), jobEmployer);
        assertEquals(jobList.get(4), jobLocation);
        assertEquals(jobList.get(5), jobPositionType);
        assertEquals(jobList.get(6), jobCoreComp);
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job();
        String testToString = job1.toString();
        assertEquals("OOPS! This job does not seem to exist.", testToString);
    }
}
