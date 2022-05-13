package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOneHundred(@PathVariable int number){
        return number + " + 100 = " + (number + 100);
    }

    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public Integer addTwoNumbers(@PathVariable int number1, @PathVariable int number2){
        return number1 + number2;
    }

    @RequestMapping(path = "/subtract/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public Integer subTwoNumbers(@PathVariable int number1, @PathVariable int number2){
        return number1 - number2;
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public Integer multiplyTwoNumbers(@PathVariable int number1, @PathVariable int number2){
        return number1 * number2;
    }

    @RequestMapping(path = "/divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public Integer divTwoNumbers(@PathVariable int number1, @PathVariable int number2){
        return number1 / number2;
    }
}
