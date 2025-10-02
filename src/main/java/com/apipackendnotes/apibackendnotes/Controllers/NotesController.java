package com.apipackendnotes.apibackendnotes.Controllers;

import com.apipackendnotes.apibackendnotes.Cores.EntityResponse.ApiResponse;
import com.apipackendnotes.apibackendnotes.Cores.Exceptions.HttpException;
import com.apipackendnotes.apibackendnotes.Dtos.DtoNote;
import com.apipackendnotes.apibackendnotes.Services.Interfaces.IServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:61200")
public class NotesController {


    private final IServiceBase<DtoNote> service;

    @Autowired
    public NotesController(IServiceBase<DtoNote> service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Object>> addNote(@RequestBody DtoNote dtoNote){
        var dto  = this.service.add(dtoNote);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("successful note added", dto));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<Object>> getAllNotes(){
        var dto  = this.service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("find all notes successful", dto));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Object>> updateNote(@RequestBody DtoNote dtoNote){
        var dto  = this.service.update(dtoNote);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("find all notes successful", dto));
    }

    @PutMapping("/deletenote")
    public ResponseEntity<ApiResponse<Object>> deleteNote(@RequestBody DtoNote dtoNote){

        this.service.delete(dtoNote);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("deleted successful", null));
    }
}
