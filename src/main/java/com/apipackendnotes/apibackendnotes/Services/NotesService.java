package com.apipackendnotes.apibackendnotes.Services;
import com.apipackendnotes.apibackendnotes.Cores.Exceptions.HttpException;
import com.apipackendnotes.apibackendnotes.Dao.NotesDao;
import com.apipackendnotes.apibackendnotes.Dtos.DtoNote;
import com.apipackendnotes.apibackendnotes.Entities.Note;
import com.apipackendnotes.apibackendnotes.Services.Interfaces.IServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService implements IServiceBase<DtoNote> {

    private final NotesDao notesDao;

    @Autowired
    public NotesService(NotesDao notesDao){
        this.notesDao = notesDao;
    }


    @Override
    public DtoNote add(DtoNote object) {

        if(object == null){
            throw HttpException.badRequest("Empty note");
        }
        if(!object.verifyFormat()){
            throw HttpException.badRequest("invalid title or content");
        }
        Note newNote = DtoNote.convertIntoNoteEntity(object);

        Note savedNote =  this.notesDao.save(newNote);

        return DtoNote.convertIntoDtoNoteEntity(savedNote);

    }

    @Override
    public DtoNote update(DtoNote object) {

        if(!this.notesDao.existsById(object.getId())){
            throw HttpException.notFound("Note not found");
        }
        var note = this.notesDao.getById(object.getId());

        //Updating fields
        note.setTitle(object.getTitle());
        note.setContent(object.getContent());

        var noteupdated = this.notesDao.save(note);

        return DtoNote.convertIntoDtoNoteEntity(noteupdated);
    }

    @Override
    public void delete(DtoNote object) {

        this.notesDao.deleteById(object.getId());
    }

    @Override
    public DtoNote find(DtoNote object) {
        return null;
    }

    @Override
    public DtoNote findById(DtoNote object) {
        return null;
    }

    @Override
    public List<DtoNote> findAll() {
        var notesDTOList = new ArrayList<DtoNote>();
        var notes = this.notesDao.findAll();
        
        for(Note note: notes){
            notesDTOList.add(DtoNote.convertIntoDtoNoteEntity(note));
        }

        return notesDTOList;
    }


}
