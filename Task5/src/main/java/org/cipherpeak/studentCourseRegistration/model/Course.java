package org.cipherpeak.studentCourseRegistration.model;

public class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledCount;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledCount = 0;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getCapacity() { return capacity; }
    public String getSchedule() { return schedule; }
    public int getEnrolledCount() { return enrolledCount; }

    public boolean hasAvailableSlot() {
        return enrolledCount < capacity;
    }

    public void enrollStudent() {
        if (hasAvailableSlot()) enrolledCount++;
    }

    public void dropStudent() {
        if (enrolledCount > 0) enrolledCount--;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + enrolledCount + "/" + capacity + ") | " + schedule;
    }
}
