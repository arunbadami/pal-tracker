package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> inMemoryMap = new HashMap<>();
    private long lastUsedId = 0L;

    @Override
    public TimeEntry create(TimeEntry timeEntry){
        long id = generateId();
        timeEntry.setId(id);
        inMemoryMap.put(id, timeEntry);
        return timeEntry;
    }

    private long generateId() {
        return ++lastUsedId;
    }

    @Override
    public TimeEntry find(Long timeEntryId){
        return inMemoryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list(){
        return new ArrayList<>(inMemoryMap.values());
    }

    @Override
    public TimeEntry update(Long timeEntryId, TimeEntry timeEntry){
        timeEntry.setId(timeEntryId);
        inMemoryMap.put(timeEntryId, timeEntry);
        return timeEntry;
    }


    @Override
    public void delete(Long timeEntryId){
        inMemoryMap.remove(timeEntryId);
    }
}
