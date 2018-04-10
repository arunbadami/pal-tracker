package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {   }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public  long getId() {
        return id;
    }

    public void setId(long id) {this.id = id; }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getProjectId() {
        return projectId;
    }

    public int getHours() {
        return hours;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        // null check
        if (o == null) {
            return false;
        } else {
            // optimization
            if (this == o) {
                return true;
            } else if (o instanceof TimeEntry) {
                TimeEntry other = (TimeEntry) o;
                if ((this.id == other.id) &&
                        (this.userId == other.userId) &&
                        (this.hours == other.hours) &&
                        (this.projectId == other.projectId) &&
                        (this.date != null && this.date.equals(other.date))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }
}
