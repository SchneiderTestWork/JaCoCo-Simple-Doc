package org.schneider;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StartTest extends TestCase {

    Start start = new Start();

    public void testCheckStart() {
        Assert.assertFalse(start.checkStart(0));
        Assert.assertTrue(start.checkStart(2));
        Assert.assertTrue(start.checkStart(-2));
    }

    public void testTempo() {
        Assert.assertEquals("Tempo", start.tempo());
    }
}
