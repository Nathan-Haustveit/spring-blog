package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOneHundred(@PathVariable double number){
        return number + " + 100 = " + (number + 100);
    }

    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public double addTwoNumbers(@PathVariable double number1, @PathVariable double number2){
        return number1 + number2;
    }

    @RequestMapping(path = "/subtract/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public double subTwoNumbers(@PathVariable double number1, @PathVariable double number2){
        return number1 - number2;
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public double multiplyTwoNumbers(@PathVariable double number1, @PathVariable double number2){
        return number1 * number2;
    }

    @RequestMapping(path = "/divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public double divTwoNumbers(@PathVariable double number1, @PathVariable double number2){
        return number1 / number2;
    }

    @GetMapping("/math")
    public String math(){
        return "math/index";
    }

    @PostMapping("/math")
    public String doMath(
            // do the math itself
            @RequestParam(name = "inputA") double inputA,
            @RequestParam(name = "inputB") double inputB,
            @RequestParam(name = "operation") String operation,
            Model model
    ) {

        double total = 0L;

        switch(operation) {
            case "add":
                total = inputA + inputB;
                break;
            case "subtract":
                total = inputA - inputB;
                break;
            case "multiply":
                total = inputA * inputB;
                break;
            case "divide":
                total = inputA / inputB;
                break;
        }

        model.addAttribute("total", total);

        return "math/index";
    }

}
