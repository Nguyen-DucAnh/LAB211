/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author Nguyen Duc Anh
 */
public class TaskManager {
    
    List<Task> listTask;

    public TaskManager() {
        listTask = new ArrayList<>();
    }
    
    public int getID() {
        return listTask.size() + 1;
    }
    
    public void addTask(Task task) {
        listTask.add(task);
    }
    
    public void deleteTask(int id) {
        listTask.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task x : listTask) {
            sb.append("ID   Name      Task Type     Date       Time       Assign       Reviewer\n");
            sb.append(x.getId() + "   ");
            sb.append(x.getName() + "     ");
            sb.append(x.getTaskType() + "     ");
            sb.append(x.getDate() + "     ");
            sb.append(x.getTo() - x.getFrom() + "      ");
            sb.append(x.getAssign() + "     ");
            sb.append(x.getReviewer() + "     ");
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
}
