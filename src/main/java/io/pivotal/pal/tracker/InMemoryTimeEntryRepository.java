package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> inMemoryMap = new HashMap<>();
    private long lastUsedId = 0L;

    public TimeEntry create(TimeEntry timeEntry){
        long id = generateId();
        timeEntry.setId(id);
        inMemoryMap.put(id, timeEntry);
        return timeEntry;
    }

    private long generateId() {
        return ++lastUsedId;
    }

    public TimeEntry find(long timeEntryId){
        return inMemoryMap.get(timeEntryId);
    }

    public List<TimeEntry> list(){
        return new ArrayList<>(inMemoryMap.values());
    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry){
        timeEntry.setId(timeEntryId);
        inMemoryMap.put(timeEntryId, timeEntry);
        return timeEntry;
    }


    public TimeEntry delete(long timeEntryId){
        return inMemoryMap.remove(timeEntryId);
    }
}
