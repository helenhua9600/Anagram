/* Author: Helen Hua
   Date: May 3, 2022
   Program purpose: This program allows the user to input 2 strings and outputs whether they are anagrams of eachother or not. All non letter characters will be ignored
   Definition: Anagram- words that share the same letters, excluding numbers, spacing and special characters
*/
import java.util.Scanner;

class Anagram
{
    // Funtion that determines whether 2 strings are anagrams of each other
    public static boolean isAnagram(String x, String y)
    {
        y = y.replaceAll ("[^a-zA-Z]", "");
        x = x.replaceAll ("[^a-zA-Z]", "");

        // If the length of the 2 strings are not equal, function exits and returns false
        if (x.length() != y.length())
        {
            return false;
        }
        
        // Traverses string x 
        for(int i=0; i<x.length(); i++)
        {
            char letter_x = x.charAt(i);
            
            // Assume true until proven false
            int state = 1;
            
            // Traverses string y
            for(int j=0; j<y.length(); j++)
            {
                char letter_y = y.charAt(j);

                // If the letter is found, keep state at 1, remove the letter from the string and break out of the for loop
                if ( (int)letter_x == (int)letter_y || (int)letter_x == (int)letter_y + 32 || (int)letter_x + 32 == (int)letter_y ) 
                {
                    state = 1;
                    
                    y = y.substring(0,j) + y.substring(j+1);
                    break;
                }
                
                // If the letter is not found, change state to 0 and continue to iterate through the for loop
                else
                {
                    state = 0;
                }
            }

            // If the letter is never found, return false
            if(state == 0)
            {
                return false;
            }
               
        }

        // If all letters from x are successfully found in y, return true
        return true;
    }
    
    public static void main(String[] args) 
    {
        // Initiates scanner
        Scanner input = new Scanner(System.in);
        
        // Asks user for their first word and saves it as test1
        System.out.println("Welcome to Helen's anagram finder! \n Please enter your first word: ");
        String test1 = input.nextLine();

        // Asks user for their second word and saves it as test2
        System.out.println("Please enter your second word: ");
        String test2 = input.nextLine();

        input.close(); 

        // Calls the isAnagram function. Depending on if it is true or not, different texts will be printed
        boolean anagram = isAnagram(test1, test2);
        if (anagram ==true)
        {
            System.out.println("True, " + test1 + " and " + test2 + " are anagrams!");
        }

        if (anagram == false)
        {
            System.out.println("False, " + test1 + " and " + test2 + " are not anagrams!");
        } 
    }
}