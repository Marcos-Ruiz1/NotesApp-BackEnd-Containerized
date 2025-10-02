package com.apipackendnotes.apibackendnotes.Dao;

import com.apipackendnotes.apibackendnotes.Entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface NotesDao extends MongoRepository<Note, String> {
    public Note getAllBy();
    public Note getById(String id);

}
