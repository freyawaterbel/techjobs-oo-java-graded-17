package org.launchcode.techjobs.oo;

import org.junit.Test;

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
}
