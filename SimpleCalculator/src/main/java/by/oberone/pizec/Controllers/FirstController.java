package by.oberone.pizec.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/input")
    public String input(@RequestParam(name="foperand")String f,@RequestParam(name="soperand")String s, @RequestParam(name="operator")String op,Model model){
        model.addAttribute("first", f);
        model.addAttribute("second",s);
        model.addAttribute("operator",op);
        int a1=Integer.parseInt(f);
        int a2=Integer.parseInt(s);
        switch (op){
            case "+":
                model.addAttribute("ans", a1+a2);
                break;
            case "-":
                model.addAttribute("ans", a1-a2);
                break;
            case "*":
                model.addAttribute("ans", a1*a2);
                break;
            case "/":
                model.addAttribute("ans", 1.0*a1/a2);
                break;
        }
        return "input";
    }
    @GetMapping("/ans")
    public String ans(@RequestParam(name="ans")String ans ,Model model){
        model.addAttribute("ans",ans);
        return "ans";
    }
}
