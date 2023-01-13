package objective;

import objective.exception.WrongInputException;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Objective {
    private static int counter;
    private final int id;
    private String name;
    private String description;
    private LocalDateTime time;
    private Repeatable.TaskType tasktype;

    public Objective(String name, String description, Repeatable.TaskType tasktype, LocalDateTime time) throws WrongInputException {
        this.name = IfError.validation(name);
        this.description = IfError.validation(description);
        this.time = time;
        this.tasktype = tasktype;
        id = counter++;
    }

    public static void setCounter(int counter) {
        Objective.counter = counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTasktype(Repeatable.TaskType tasktype) {
        this.tasktype = tasktype;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Repeatable.TaskType getTasktype() {
        return tasktype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objective objective = (Objective) o;
        return id == objective.id && Objects.equals(name, objective.name) && Objects.equals(description, objective.description) && Objects.equals(time, objective.time) && tasktype == objective.tasktype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, time, tasktype);
    }

    @Override
    public String toString() {
        return "Задача " +
                "id: " + id + '\n' +
                "название: " + name + '\n' +
                "описание: " + description + '\n' +
                "начало задачи: " + time + '\n' +
                "тип задачи: " + tasktype;
    }

    public static class DailyO extends Objective implements Repeatable {
        public DailyO(String name, String description, TaskType tasktype, LocalDateTime time) throws WrongInputException {
            super(name, description, tasktype, time);
        }

        @Override
        public boolean checkIfSuitable(LocalDateTime requestedDate) {
            return true;
        }

    }
}
