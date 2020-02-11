package com.prisonerprice.importantdays.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    @ColumnInfo(name = "remainder_days")
    private int remainderDays;

    @ColumnInfo(name = "added_at")
    private Date addedAt;

    @Ignore
    public Task(String description, int remainderDays, Date addedAt) {
        this.description = description;
        this.remainderDays = remainderDays;
        this.addedAt = addedAt;
    }

    public Task(int id, String description, int remainderDays, Date addedAt) {
        this.id = id;
        this.description = description;
        this.remainderDays = remainderDays;
        this.addedAt = addedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRemainderDays() {
        return remainderDays;
    }

    public void setRemainderDays(int remainderDays) {
        this.remainderDays = remainderDays;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }
}
