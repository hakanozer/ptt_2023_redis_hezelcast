package com.works.controllers;

import com.works.redismodels.Note;
import com.works.redisservices.NoteRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoteController {

    final NoteRedisService noteRedisService;

    @GetMapping("/note")
    public String note(Model model) {
        List<Note> notes = noteRedisService.all();
        model.addAttribute("notes", notes);
        return "note";
    }

    @PostMapping("/noteAdd")
    public String noteAdd(Note note) {
        noteRedisService.save(note);
        return "redirect:/note";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable String id) {
        noteRedisService.delete(id);
        return "redirect:/note";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        model.addAttribute("notes", noteRedisService.search(q));
        return "search";
    }

}
