public class Task {

    final private String name;
    final private String description;
    final private StatusTask status;
    static private int id = 0;

    public Task(String name, String description, StatusTask status, int id) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.id = id;
    }


    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public StatusTask getStatus() {
        return status;
    }





}



