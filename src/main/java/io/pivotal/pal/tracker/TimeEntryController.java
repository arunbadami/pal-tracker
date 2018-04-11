package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry created = repository.create(timeEntry);
        if (created!=null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        return null;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name = "id") long id) {
        TimeEntry te = repository.find(id);
        if (te!=null) {
            return new ResponseEntity<TimeEntry>(te, HttpStatus.OK);
        } else{
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> tes = repository.list();
        if (tes!=null) {
            return new ResponseEntity<>(tes, HttpStatus.OK);
        }
        return null;
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable(name = "id") long timeEntryId, @RequestBody TimeEntry timeEntry) {
        TimeEntry te = repository.update(timeEntryId, timeEntry);
        if (te!=null) {
            return new ResponseEntity<TimeEntry>(te, HttpStatus.OK);
        } else{
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable(name = "id") long id) {
        repository.delete(id);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
