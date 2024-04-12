package hu.progmasters.sovietville;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SovietvilleTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Sovietville init(){
        Sovietville sovietville = new Sovietville();

        sovietville.villeRunner("YoungCouple(25, 30)");
        sovietville.villeRunner("OldCouple(20, 25)");
        sovietville.villeRunner("YoungSingle(35)");
        sovietville.villeRunner("OldSingle(25)");

        return sovietville;
    }
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testVilleRunner_Status() {
        Sovietville sovietville = init();

        sovietville.villeRunner("status");
        assertEquals("The total consumption in SovietVille: 119.5", outputStreamCaptor.toString().trim());
    }
    @Test
    void testVilleRunner_Quit(){
        Sovietville sovietville = init();

        sovietville.villeRunner("quit");
        assertEquals("The population is: 6", outputStreamCaptor.toString().trim());
    }

    @Test
    void testVilleRunner_Bills(){
        Sovietville sovietville = init();

        assertEquals(4, sovietville.getHomes().size());

        sovietville.villeRunner("bills");
        assertEquals(0, sovietville.getHomes().size());
    }

    @Test
    void testPayDay_And_Bills() {
        Sovietville sovietville = init();

        sovietville.payDay();
        sovietville.payDay();

        sovietville.villeRunner("bills");

        assertEquals(4, sovietville.getHomes().size());
    }
    @Test
    public void testFooThrowsIndexOutOfBoundsException() {
        Sovietville sovietville = new Sovietville();
        sovietville.villeRunner("YoungCouple(2k5, 30)");

        assertEquals("Not good number format!!: 2k5 30", outputStreamCaptor.toString().trim());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}