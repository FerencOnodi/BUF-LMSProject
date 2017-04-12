/**
 * Created by vajni on 2017.04.12..
 */
public class Datacontainer {

    private String title;
    private String text;
    private String id;
    private boolean published;
    private int index;

    public Datacontainer(String title, String text, String id, boolean published, int index) {
        this.title = title;
        this.text = text;
        this.id = id;
        this.published = published;
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
