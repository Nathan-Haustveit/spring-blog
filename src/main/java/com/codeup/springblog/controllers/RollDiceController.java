package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String diceStart() {
        return "/roll-dice/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceNumber(@PathVariable int n, Model model) {

        int dice = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        String answer = "";

        if (dice == n) {
            answer = "That's Correct!";
        } else {
            answer = "You guessed the wrong number";
        }
        model.addAttribute("number", n);
        model.addAttribute("answer", answer);
        model.addAttribute("dice", dice);
        return "/roll-dice/roll-dice";
    }
}

