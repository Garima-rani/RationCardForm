package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.NewUserName;
import com.example.repository.NewUserNameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewUserNameService {

    @Autowired
    private NewUserNameRepository repository;

    public List<NewUserName> getAllUserNames() {
        return repository.findAll();
    }

    public Optional<NewUserName> getUserNameById(Long id) {
        return repository.findById(id);
    }

    public NewUserName saveUserName(NewUserName userName) {
        return repository.save(userName);
    }

    public void deleteUserName(Long id) {
        repository.deleteById(id);
    }
}
