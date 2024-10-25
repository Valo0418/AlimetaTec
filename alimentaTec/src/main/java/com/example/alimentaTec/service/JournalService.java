package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Journal;
import com.example.alimentaTec.repository.JournalRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class JournalService {
    @Autowired
    private JournalRepository repo;

    public List<Journal> getAll() {
        return repo.findAll();
    }

    public void save(Journal journal) {
        repo.save(journal);
    }

    public Journal getIdJournal(Integer idJournal) {
        return repo.findById(idJournal).get();
    }

    public void delete(Integer idJournal) {
        repo.deleteById(idJournal);
    }
}