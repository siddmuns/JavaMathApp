package ca.sheridancollege.siddmuns.quiz1.controller;

import ca.sheridancollege.siddmuns.quiz1.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TableController {
    private final Logger log = LoggerFactory.getLogger(TableController.class);

    private final Table table = new Table();

    @GetMapping("/")
    public ModelAndView index() {
        log.trace("index() is called");
        List<Integer> tableRows = table.getTable();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("tableRows", tableRows);
        return modelAndView;
    }

    @PostMapping("/multiplyTable")
    public ModelAndView multiplyTable(@RequestParam("value") int value) {
        log.trace("multiplyTable() is called with: {}", value);
        table.multiplyRows(value);
        List<Integer> tableRows = table.getTable();
        ModelAndView modelAndView = new ModelAndView("multiply");
        modelAndView.addObject("tableRows",tableRows);
        return modelAndView; // Redirect after post to prevent double submission
    }

    @GetMapping("/multiply")
    public ModelAndView multiply() {
        log.trace("multiply() is called");
        List<Integer> tableRows = table.getTable();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("tableRows", tableRows);
        return modelAndView;
    }

    @GetMapping("/newIndex")
    public ModelAndView newIndex() {
        log.trace("newIndex() is called");
        Table newTable = new Table();
        List<Integer> tableRows = newTable.getTable();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("tableRows", tableRows);
        return modelAndView;
    }


}
