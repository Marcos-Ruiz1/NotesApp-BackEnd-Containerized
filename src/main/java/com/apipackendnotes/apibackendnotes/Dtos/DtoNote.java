package com.apipackendnotes.apibackendnotes.Dtos;

import com.apipackendnotes.apibackendnotes.Entities.Note;
import lombok.Data;

@Data
public class DtoNote {

    private String id;
    private String title;
    private String content;


    public static Note convertIntoNoteEntity(DtoNote dtoNote){

        Note note = new Note();
        note.setId(dtoNote.id);
        note.setTitle(dtoNote.title);
        note.setContent(dtoNote.content);

        return note;
    }

    public static DtoNote convertIntoDtoNoteEntity(Note note){
        DtoNote dtoNote = new DtoNote();
        dtoNote.id = note.getId();
        dtoNote.setTitle(note.getTitle());
        dtoNote.setContent(note.getContent());

        return dtoNote;
    }

    public boolean verifyFormat(){
        return !(this.getTitle().isEmpty() || this.getContent().isEmpty());
    }


}
