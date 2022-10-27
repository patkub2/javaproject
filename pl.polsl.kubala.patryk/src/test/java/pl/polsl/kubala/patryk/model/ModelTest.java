/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.kubala.patryk.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author patry
 */
public class ModelTest {
    Model model = new Model();
    public ModelTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setchoiceEnum method, of class Model.
     */
    @Test 
    public void testSetchoiceEnum() {
        System.out.println("setchoiceEnum");
       
            model.setchoiceEnum(0);
            assertEquals("ENCODE",String.valueOf(model.getchoiceEnum()), "Payment 100 should give a result equals 200.");
            model.setchoiceEnum(1);
            assertEquals("DECODE",String.valueOf(model.getchoiceEnum()), "Payment 100 should give a result equals 200.");
            
        
    }


    /**
     * Test of setFromCL method, of class Model.
     */
    @Test
    public void testSetFromCL() {
        System.out.println("setFromCL");
        boolean boolArg = false;
        
        model.setFromCL(boolArg);
        
        
    }

    /**
     * Test of setSeed method, of class Model.
     */
    @Test
    @DisplayName("Test Seed")
    public void testSetSeed() {
        System.out.println("setSeed");
        int seedArg = 0;
        
        model.setSeed(seedArg);
        
        
    }

    /**
     * Test of setChoice method, of class Model.
     */
    @Test
    public void testSetChoice() {
        System.out.println("setChoice");
        int choiceArg = 0;
        
        model.setChoice(choiceArg);
        
        
    }

    /**
     * Test of setText method, of class Model.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String textArg = "";
        
        model.setText(textArg);
        
        
    }

    /**
     * Test of getchoiceEnum method, of class Model.
     */
    @Test
    public void testGetchoiceEnum() {
        System.out.println("getchoiceEnum");
        
        Model.EnumChoice expResult = null;
        Model.EnumChoice result = model.getchoiceEnum();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getSeed method, of class Model.
     */
    @Test
    public void testGetSeed() {
        System.out.println("getSeed");
        
        int expResult = 0;
        int result = model.getSeed();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getChoice method, of class Model.
     */
    @Test
    public void testGetChoice() {
        System.out.println("getChoice");
        
        int expResult = 0;
        int result = model.getChoice();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getText method, of class Model.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        
        String expResult = "";
        String result = model.getText();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getNoError method, of class Model.
     */
    @Test
    public void testGetNoError() {
        System.out.println("getNoError");
        
        boolean expResult = false;
        boolean result = model.getNoError();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getFromCL method, of class Model.
     */
    @Test
    public void testGetFromCL() {
        System.out.println("getFromCL");
        
        boolean expResult = false;
        boolean result = model.getFromCL();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getKey method, of class Model.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        
        List<List<Integer>> expResult = null;
        List<List<Integer>> result = model.getKey();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of takeFromCommandLine method, of class Model.
     */
    @Test
    public void testTakeFromCommandLine() throws Exception {
        System.out.println("takeFromCommandLine");
        String[] commandLineArgs = null;
        
        model.takeFromCommandLine(commandLineArgs);
        
        
        
    }

    /**
     * Test of setKey method, of class Model.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        
        model.setKey();
        
        
    }

    /**
     * Test of decodeText method, of class Model.
     */
    @Test
    public void testDecodeText() throws Exception {
        System.out.println("decodeText");
        
        String expResult = "591 180 949 730 847 411";
        String result = model.decodeText();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of encodeText method, of class Model.
     */
    @Test
    public void testEncodeText() throws Exception {
        System.out.println("encodeText");
        
        String expResult = "";
        String result = model.encodeText();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of destroyKey method, of class Model.
     */
    @Test
    public void testDestroyKey() {
        System.out.println("destroyKey");
        
        model.destroyKey();
        
        
    }
    
}
