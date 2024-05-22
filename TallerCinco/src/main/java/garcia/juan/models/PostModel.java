package garcia.juan.models;


public class PostModel {
    private String title;
    private String body;

    public PostModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "body='" + body + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}