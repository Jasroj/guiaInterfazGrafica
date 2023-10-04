/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JRS
 */
public class Data {
    private static List<String> valueList = new ArrayList<>();
    
    private static int clickCounter = 0;
    private static int ticketNumber = 1;


    private String age;
    private String urgency;

    public Data(String age, String urgency, int issues) {
        this.age = age;
        this.urgency = urgency;
    }

    /**
     * @return the valueList
     */
    public static List<String> getValueList() {
        return valueList;
    }

    /**
     * @param aValueList the valueList to set
     */
    public static void setValueList(List<String> aValueList) {
        valueList = aValueList;
    }


    /**
     * @return the clickCounter
     */
    public static int getClickCounter() {
        return clickCounter;
    }

    /**
     * @param aClickCounter the clickCounter to set
     */
    public static void setClickCounter(int aClickCounter) {
        clickCounter = aClickCounter;
    }

    /**
     * @return the ticketNumber
     */
    public static int getTicketNumber() {
        return ticketNumber;
    }

    /**
     * @param aTicketNumber the ticketNumber to set
     */
    public static void setTicketNumber(int aTicketNumber) {
        ticketNumber = aTicketNumber;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the urgency
     */
    public String getUrgency() {
        return urgency;
    }

    /**
     * @param urgency the urgency to set
     */
    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }
}