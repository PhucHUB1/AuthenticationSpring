package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    public static Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping()
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
}
