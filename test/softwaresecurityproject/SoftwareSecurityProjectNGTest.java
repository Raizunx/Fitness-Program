/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaresecurityproject;

import java.util.Scanner;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author rasaz
 */
public class SoftwareSecurityProjectNGTest {

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
  
    /*
    //Menues Choses
    //T001
    @Test
    public void testGetUserInput_NumberInRangeValueMenu() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "2";
        String regex = "[1-3]";
        boolean actualResult = object.getUserInput(regex,input);
        assertEquals(true, actualResult);}
    
    //T002
    @Test
    public void testGetUserInput_NumberOutRangeValueMenu() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "4";
        String regex = "[1-3]";
        boolean actualResult = object.getUserInput(regex,input);
        assertEquals(false, actualResult);}
    
    //T003
    @Test
    public void testGetUserInput_InvalidDataTypeValueMenu() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "4";
        String regex = "[1-3]";
        boolean actualResult = object.getUserInput(regex,input);
        assertEquals(false, actualResult);}
    
    //T004
    @Test
    public void testGetUserInput_EmptyValueMenu() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "";
        String regex = "[1-3]";
        boolean actualResult = object.getUserInput(regex,input);
        assertEquals(false, actualResult);}
    
    //T005
    @Test
    public void testGetUserInput_NullValueMenu() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "";
        String regex = "[1-3]";
        boolean actualResult = object.getUserInput(regex,input);
        assertEquals(false, actualResult);}
    
  
    
    //Age 
    //T006
    @Test
    public void testGetUserInput_InRangeAge() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "22";
        String regex = "\\d+";
        int minAge = 5;
        int maxAge= 85;
        boolean actualResult = object.getUserInput(regex,minAge, maxAge, input);
        assertEquals(true, actualResult);}
    
    //T007
    @Test
    public void testGetUserInput_OutRangeAge() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "0";
        String regex = "\\d+";
        int minAge = 5;
        int maxAge= 85;
        boolean actualResult = object.getUserInput(regex,minAge, maxAge, input);
        assertEquals(false, actualResult);}
    
    //T008
    @Test
    public void testGetUserInput_InvalidDataTypeAge() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = "abs";
        String regex = "\\d+";
        int minAge = 5;
        int maxAge= 85;
        boolean actualResult = object.getUserInput(regex,minAge, maxAge, input);
        assertEquals(false, actualResult);}
    
    //T009
    @Test
    public void testGetUserInput_INullAge() {
        SoftwareSecurityProject object = new SoftwareSecurityProject();
        String input = null;
        String regex = "\\d+";
        int minAge = 5;
        int maxAge= 85;
        boolean actualResult = object.getUserInput(regex,minAge, maxAge, input);
        assertEquals(false, actualResult);}

    //Account Regestraition
    //T010
    @Test
    public void testRegisterUser_ValidNewAccount() {
        String username = "Arwa";
        String password = "112233445566";
        boolean actualResult = SoftwareSecurityProject.registerUser(username, password);
        assertEquals(true, actualResult);
    }
    
    //T011
    @Test
    public void testRegisterUser_ExistingUserName() {
        String username = "Razan";
        String password = "112233445566";
        boolean actualResult = SoftwareSecurityProject.registerUser(username, password);
        assertEquals(false, actualResult);
    }
    
    //T012
    @Test
    public void testRegisterUser_ShortEntry() {
        String username = "aa";
        String password = "";
        boolean actualResult = SoftwareSecurityProject.registerUser(username, password);
        assertEquals(false, actualResult);
    }
    
    //T013
    @Test
    public void testRegisterUser_ImvalidDataType() {
        String username = "12345";
        String password = "aqwert";
        boolean actualResult = SoftwareSecurityProject.registerUser(username, password);
        assertEquals(false, actualResult);
    }
    
    
    //Login
    //T014
    @Test
    public void testLoginUser_ExistAccount() {
        String username = "Razan";
        String password = "123123123";
        boolean result = SoftwareSecurityProject.loginUser(username, password);
        assertEquals(true, result);
    }
    
    //T015
    @Test
    public void testLoginUser_UnExistAccount() {
        String username = "Jhon";
        String password = "123456";
        boolean result = SoftwareSecurityProject.loginUser(username, password);
        assertEquals(false, result);
    }
    
    */
}
