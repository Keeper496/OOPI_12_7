//********************************************************************************
//  Group Assignment       Authors: Kara Keck, Kara Uitenbroek , Pamela Kuepper
//  Date: 8/2/2018
// Class: CPS 315 Object-Oriented Programming I 
//  Chapter 12 pp 12.7
//********************************************************************************
package group_project_12_7;

import java.util.Scanner;

public class Group_Project_12_7
{
    // Create a method isBlurb() to check the string length
    public static boolean isBlurb(String s)
    {
        try
        {
            int endOfWhoozit = prefixedByWhoozit(s);
            if (endOfWhoozit >= s.length())
                return false;
            else
                return isWhatszitList(s.substring(endOfWhoozit));
        }
        catch (StringIndexOutOfBoundsException ex)
        {
            return false;
        }
    }
    // Create a method isWhatszitList() to the characters followed by q
    public static boolean isWhatszitList(String s)
    {
        if ((!s.startsWith("qd") && !s.startsWith("qz")) || s.length() < 3)
        {
            return false;
        }
        s = s.substring(2);
        int endOfWhoozit = prefixedByWhoozit(s);
        if (endOfWhoozit == -1)
            return false;
        else if (endOfWhoozit == s.length())
            return true;
        else
            return isWhatszitList(s.substring(endOfWhoozit));
    }
    // Create a prefixedByWhoozit() method to check the string is
    // followed by Whoozit or not
    public static int prefixedByWhoozit(String s)
    {
        int i = 0;
        if (s.charAt(i) == 'x') {
            i++;
            while (i < s.length() && s.charAt(i) == 'y') {
                i++;
            }
            return i;
        }
        else
        {
            return -1;
        }
    }
    // Create a main method
    public static void main(String[] args)
    {
        // Create an object scan for the scanner class
        Scanner scan = new Scanner(System.in);
        String choice = "Y";
        // Accept the input from the user Continuously
        do
        {
            System.out.println("Enter text to check wether the input text is Blurb or not:");
            String data = scan.nextLine();
            // Call the isBlurb() method
            boolean check = isBlurb(data);
            if (check == true)
            {
                System.out.println("It is a Blurb");
            }
            else
            {
                System.out.println("It is not a Blurb");
            }
            System.out.print("Do you want to continue?(y/n): ");
            choice = scan.nextLine();
        } while (choice.equals("y") || choice.equals("Y"));
    }
}
