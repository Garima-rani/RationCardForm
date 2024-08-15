package com.example.service;

import com.example.model.Form;
import com.example.model.Member;
import com.example.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;
    
    @Transactional
    public Form saveFormWithMembers(Form form) {
        // Ensure bidirectional relationship is set
        if (form.getMembers() != null) {
            for (Member member : form.getMembers()) {
                member.setForm(form); // Set the form reference in each member
            }
        }
        return formRepository.save(form);
    }
    
    @Transactional
    public Form saveForm(Form form) {
        return formRepository.save(form);
    }
    
    public String test(){
        return "Working Fine" ;
    }

    public Optional<Form> getFormById(Long id) {
        return formRepository.findById(id);
    }
}
