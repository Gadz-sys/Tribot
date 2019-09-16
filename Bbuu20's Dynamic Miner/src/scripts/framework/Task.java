package scripts.framework;

public abstract class Task {

    public abstract String taskInfo();

    public abstract boolean shouldDo();

    public abstract void doTask();

}
