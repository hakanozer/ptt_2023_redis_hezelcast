package com.works.redisservices;

import com.works.redismodels.Note;
import com.works.redisrepositories.NoteRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteRedisService {

    final NoteRedisRepository noteRedisRepository;

    public Note save( Note note ) {
        return noteRedisRepository.save(note);
    }

    public List<Note> all() {
        return noteRedisRepository.findAll();
    }

    public void delete(String id) {
        noteRedisRepository.deleteById(id);
    }

    public List<Note> search(String q) {
        List<Note> notes = noteRedisRepository.findAll();
        return notes
                .stream()
                .filter(
                        item -> item.getTitle().toUpperCase(Locale.ROOT).contains(q.toUpperCase()) ||
                                item.getDetail().toUpperCase(Locale.ROOT).contains(q.toUpperCase())
                ).collect(Collectors.toList());
    }

}
