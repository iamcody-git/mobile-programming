package prashant.com;

public class EmailItem {
    private String titleInitial;
    private String title;
    private String content;

    public EmailItem(String titleInitial, String title , String content){
        this.titleInitial = titleInitial;
        this.title=title;
        this.content= content;

    }

    public String getTitleInitial() {
        return titleInitial;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
