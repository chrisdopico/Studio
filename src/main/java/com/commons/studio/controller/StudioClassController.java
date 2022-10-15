package com.commons.studio.controller;

import com.commons.studio.model.StudioClass;
import com.commons.studio.service.studioclass.IStudioClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudioClassController {

    @Autowired
    IStudioClassService studioClassService;

    @GetMapping("/classes")
    public List<StudioClass> getAlLStudioClasses(){
        return studioClassService.getAlLStudioClasses();
    }

    @PostMapping("/classes")
    public ResponseEntity<String> createStudioClass(@Valid @RequestBody StudioClass studioClass){
        studioClassService.createStudioClass(studioClass);
        return ResponseEntity.status(HttpStatus.CREATED).body("New class created");
    }


}
