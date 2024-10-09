//package com.example.controller;
//
//import com.example.model.Form;
//import com.example.service.FormService;
//import com.example.service.MasterDataService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/forms")
//public class FormController {
//
//    @Autowired
//    private FormService formService;
//
//    @Autowired
//    private MasterDataService masterDataService;
//    
//    @GetMapping
//    public ResponseEntity<?> test() {
//        return ResponseEntity.ok("Form submitted successfully");
//    }
//
//    @PostMapping
//    public ResponseEntity<?> submitForm(@RequestBody Form form) {
//        formService.saveFormWithMembers(form);
//        return ResponseEntity.ok("Form submitted successfully");
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Form> getFormById(@PathVariable("id") Long id) {
//        return formService.getFormById(id)
//                .map(form -> new ResponseEntity<>(form, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    
//    
//}
