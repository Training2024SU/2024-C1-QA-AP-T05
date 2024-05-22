package co.com.sofka.models;

public class Fecha {
    private String date;
    private String month;
    private String year;
    private String hour;

    public Fecha(String date, String month, String year, String hour) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
