/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonpractice;

import java.lang.reflect.Type;

import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tom
 */
public class JsonPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TaskList taskList = new TaskList();
        taskList = getTaskList();
        
        ArrayList<Task> allTasks = taskList.tasks;
        System.out.println(allTasks);
    }
    
    
    public static TaskList getTaskList(){
        Gson gson = new Gson();
        TaskList taskList = new TaskList();
        
        try {
            String currentDir = System.getProperty("user.dir");
            currentDir += "/src/jsonpractice/tasks_simpler.json";

            BufferedReader br = new BufferedReader(new FileReader(currentDir));
            
            // convert the json string back to an object
            taskList = gson.fromJson(br, TaskList.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskList;
    }
}
