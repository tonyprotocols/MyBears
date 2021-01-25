package karimovic.toni.mybeers;

import android.graphics.drawable.Drawable;

public class Beer {
    private String name;
    private String country;
    private String description;
    private String percentage;
    private String since;
    private int image;

    public Beer(String name, String country, String description, String percentage, String since, int image) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.percentage = percentage;
        this.since = since;
        this.image = image;
    }

    public Beer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", percentage='" + percentage + '\'' +
                ", since='" + since + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
