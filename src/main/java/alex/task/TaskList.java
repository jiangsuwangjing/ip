package alex.task;

import java.io.IOException;
import java.util.ArrayList;

import alex.exceptions.ListOutOfBoundException;
import alex.Storage;
import alex.Ui;

/**
 * Keeps track of the list of the tasks
 */
public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * Add a task into the task list and saves it into storage
     * @param task task to be added
     * @param ui current ui
     * @param storage the storage to save the task
     */
    public void addItem(Task task, Ui ui, Storage storage) {
        list.add(task);
        int itemCount = list.size();
        ui.addItemResponse(task.toString(), itemCount);
        storage.saveData(task.getSavedDataFormat());
    }

    /**
     * Display all the tasks in the list
     */
    public void displayList() {
        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, list.get(i).toString());
        }
    }

    public void displayList(Ui ui) {
        StringBuilder resultMessage = new StringBuilder("Here are the tasks in your list:\n");
        int count = 1;
        for (Task task : list) {
            resultMessage.append(count).append(". ").append(task).append("\n");
            count++;
        }
        ui.printMsg(resultMessage.toString());
    }

    /**
     * Set the status of a task of a given index
     * @param index index of the task counting from 1
     * @param isDone the target status
     * @param ui system ui
     * @param storage storage to save data
     */
    public void mark(int index, boolean isDone, Ui ui, Storage storage) {
        try {
            String responseMsg = list.get(index - 1).setStatus(isDone);
            storage.updateLineInFile(index, list.get(index - 1).getSavedDataFormat().stripTrailing());
            ui.printMsg(responseMsg);
        } catch (IOException e) {
            ui.showErrorMsg(e);
        }
    }

    /**
     * Deletes a task from the list
     * @param index index of the task to delete counting form 1
     * @param ui
     * @param storage
     */
    public void delete(int index, Ui ui, Storage storage) {
        try {
            String task = list.remove(index - 1).toString();
            ui.deleteTaskResponse(task, list.size());
            storage.deleteLineFromFile(index);
        } catch (IOException e) {
            ui.showErrorMsg(e);
        }
    }

    /**
     * Checks if the index is within the bound
     * @param index counting from 1
     * @return
     * @throws ListOutOfBoundException
     */
    public boolean checkInBound(int index) throws ListOutOfBoundException {
        if (index > list.size() || index < 0) {
            throw new ListOutOfBoundException();
        }
        return true;
    }

    /**
     * Get task of a given index
     * @param index counting from 1
     * @return task of the index
     */
    public Task getTask(int index) {
        assert index > 0 && index <= list.size();

        return list.get(index - 1);
    }

    /**
     * Get all the tasks in the list
     * @return list of tasks
     */
    public ArrayList<Task> getTasks() {
        return list;
    }

    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : list) {
            if (task.getContent().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer i = 1; i <= list.size(); i++) {
            str.append(i + ". " + list.get(i - 1).toString());
            str.append("\n");
        }
        return str.toString();
    }
}
