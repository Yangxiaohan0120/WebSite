package entity;

/**
 * @author Chris Yang
 * created 2022-06-22 15:33
 **/
public class Painting {
    private Integer id;
    private String pname;
    private Integer category;
    private Integer price;
    private String preview;
    private String description;

    public Painting() {
    }

    public Painting(Integer id, String pname, Integer category, Integer price, String preview, String description) {
        this.id = id;
        this.pname = pname;
        this.category = category;
        this.price = price;
        this.preview = preview;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public Integer getCategory() {
        return category;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPreview() {
        return preview;
    }

    public String getDescription() {
        return description;
    }
}
