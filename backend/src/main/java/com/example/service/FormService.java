//package com.example.service;
//
//import com.example.model.Form;
//import com.example.model.Member;
//import com.example.repository.FormRepository;
//import com.example.service.MasterDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class FormService {
//
//    @Autowired
//    private FormRepository formRepository;
//
//    @Autowired
//    private MasterDataService masterDataService; // Inject MasterDataService
//
////    @Transactional
////    public Form saveFormWithMembers(Form form) {
////        // Validate form data against master data
////        // For example, check if selected state exists
////        if (form.getPresentState() != null && !masterDataService.getStates().contains(form.getPresentState())) {
////            throw new IllegalArgumentException("Invalid state selected");
////        }
//
//        // Ensure bidirectional relationship is set
//        if (form.getMembers() != null) {
//            for (Member member : form.getMembers()) {
//                member.setForm(form); // Set the form reference in each member
//            }
//        }
//
//        // Save and return the form
//        return formRepository.save(form);
//    }
//
//    @Transactional
//    public void deleteFormById(Long id) {
//        formRepository.deleteById(id);
//    }
//
//    public List<Form> getAllForms() {
//        return formRepository.findAll();
//    }
//
//    public Optional<Form> getFormById(Long id) {
//        return formRepository.findById(id);
//    }
//
//   
//}
