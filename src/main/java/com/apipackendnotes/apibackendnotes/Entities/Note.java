package com.apipackendnotes.apibackendnotes.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Note {

    @Id
    private String id;

    private String title;
    private String content;

    public Note(){

    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
