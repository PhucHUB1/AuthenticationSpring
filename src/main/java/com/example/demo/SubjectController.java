package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService service;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping()
    public List<Subject> getAllSubject(@RequestParam(required = false) String name,@RequestParam(required = false) Integer hours){
        return service.filterSubject(name,hours);
    }

    @PostMapping("/")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject newSubject) {
        return subjectRepository.findById(id)
                .map(subject -> {
                    subject.setName(newSubject.getName());
                    subject.setHours(newSubject.getHours());
                    return subjectRepository.save(subject);
                })
                .orElseGet(() -> {
                    newSubject.setId(id);
                    return subjectRepository.save(newSubject);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }
}
