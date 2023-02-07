package invadem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import invadem.App;
import invadem.Entity;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

public class AppTest {

    @Before
    PApplet p = new PApplet();
    App ap = new App();
    p.setup();
    p.delay(2000);

    @Test
    public void testAppSetup() {
        assertNotNull(player);
    }
}