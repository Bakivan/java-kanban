import java.util.ArrayList;
import java.util.HashMap;
public class TaskManager{
    HashMap<Integer, Task> taskMap= new HashMap<>();
    HashMap<Integer, Epic> epicMap = new HashMap<>();
    HashMap<Integer, Subtask> subtaskMap = new HashMap<>();



    public void createTask (String name, String description, StatusTask status, int id) {
        id++;
        Task task = new Task(name, description, status, id);
        taskMap.put(id,task);

    }
    public void createEpic (String name, String description, StatusTask status, int id) {
        id++;
        Epic epic = new Epic(name, description, status, id);
        epicMap.put(id, epic);

    }
    public void createSubtask (String name, String description, StatusTask status, int id) {
        id++;
        Subtask subtask = new Subtask(name, description, status, id);
        subtaskMap.put(id, subtask);
    }
    public void updateTask (Task task) {
        taskMap.put(task.getId(), task);

    }
    public void updateEpic (Epic epic) {
        epicMap.put(epic.getId(), epic);

    }
    public void updateSubtask (Subtask subtask) {
        subtaskMap.put(subtask.getId(), subtask);


    }





}
