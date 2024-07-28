package hcoe.com;

import java.util.Date;
import java.util.UUID;

public class CrimeModel {
    private UUID id;
    private String title;
    private Date crimeDate;

    private Boolean isSolved;
    public CrimeModel(){
        this.id = UUID.randomUUID();
        this.crimeDate = new Date();

    }

    public void setTitle(String title) {
        this.title = title;

    }
    public String getTitle() {
        return title;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }

    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }
}
