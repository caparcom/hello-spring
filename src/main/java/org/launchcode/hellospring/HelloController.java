package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("form")
    public String createForm(){
        return "<html>" +
                "<body>" +
                "<form action='greeting' method='post'>" +
                "<input type='text' name='passName'></input>" +
                "<select id='passLang' name='passLang'>Please select a language " +
                "<option type='text' name='passLang' value='English'>English</option>" +
                "<option type='text' name='passLang' value='French'>French</option>" +
                "<option type='text' name='passLang' value='Spanish'>Spanish</option>" +
                "<option type='text' name='passLang' value='German'>German</option>" +
                "<option type='text' name='passLang' value='Dothraki'>Dothraki</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("greeting")
    public String difLangGreet(@RequestParam String passName, @RequestParam String passLang){
        if (passName == null) {
            passName = "World";
        }

        return greetingInChosenLang(passName, passLang);
    }


    public String greetingInChosenLang(String n, String l){
        String hello = "";
        if(l.equals("English")){
            hello = "Hello, ";
        }else if(l.equals("French")){
            hello = "Bonjour, ";
        }else if(l.equals("Spanish")){
            hello = "Hola, ";
        }else if(l.equals("German")){
            hello = "Nien, ";
        }else if(l.equals("Dothraki")){
            hello = "M'atchomaroon, ";
        }else{
            hello = "*waves arm*";
            return hello + n + "!";
        }
        return hello + n + "!";
    }
}

