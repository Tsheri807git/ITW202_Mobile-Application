package gcit.edu.todo_18;

public class Sport {
    private String title;
    private String info;
    private final int imageResources;

    Sport(String title, String info, int imageResources) {
        this.title = title;
        this.info = info;
        this.imageResources = imageResources;
    }
    String getTitle() {
        return title;
    }
    String getInfo() {
        return info;
    }
    public int getImageResources(){
        return imageResources;
    }
}
