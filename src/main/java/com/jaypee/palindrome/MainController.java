package com.jaypee.palindrome;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private Model model;
    
    @GetMapping("/ispalindrome")
    public boolean isPalindrome(@RequestParam String string){
        
        String reversedString;
        int i;

        reversedString = "";

        for (i = string.length() - 1; i > -1; i--){
            reversedString += string.charAt(i);
        }

        if(string.equals(reversedString)){
            model.saveToDatabase(string, true);
            return true;
        }
        else{
            model.saveToDatabase(string, false);
            return false;
        }

    }

}
