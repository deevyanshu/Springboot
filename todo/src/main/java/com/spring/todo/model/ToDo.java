package com.spring.todo.model;

public class ToDo {

    private int id;
    private String task;
    private int priority;

    public ToDo()
    {

    }

    public ToDo(int id, String task, int priority)
    {
        this.id=id;
        this.task=task;
        this.priority=priority;
    }
    
    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public String getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTask(String task) {
        this.task = task;
    }
    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
