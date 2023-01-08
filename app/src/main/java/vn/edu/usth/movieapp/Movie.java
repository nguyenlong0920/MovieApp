package vn.edu.usth.movieapp;

import java.io.Serializable;

public class Movie implements Serializable {

    private String Name;
    private String releaseDate;
    private String ratePG;
    private String durationTime;
    private String storyLine;
    private String director;
    private int imgID;

    public Movie(String name, String releaseDate, String ratePG, String durationTime, String storyLine, String director, int imgID) {
        this.Name = name;
        this.releaseDate = releaseDate;
        this.ratePG = ratePG;
        this.durationTime = durationTime;
        this.storyLine = storyLine;
        this.director = director;
        this.imgID = imgID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRatePG() {
        return ratePG;
    }

    public void setRatePG(String ratePG) {
        this.ratePG = ratePG;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
