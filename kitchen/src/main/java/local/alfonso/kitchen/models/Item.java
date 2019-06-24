package local.alfonso.kitchen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;

    @Column(nullable = false)
    private String itemname;

    private int itemquantity;

    private String itemcategory;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("item")
    private List<UserItems> userItems = new ArrayList<>();

    public Item()
    {
    }

    public Item(String itemname, int itemquantity, String itemcategory)
    {
        this.itemname = itemname;
        this.itemquantity = itemquantity;
        this.itemcategory = itemcategory;
    }

    public long getItemid()
    {
        return itemid;
    }

    public void setItemid(long itemid)
    {
        this.itemid = itemid;
    }

    public String getItemname()
    {
        return itemname;
    }

    public void setItemname(String itemname)
    {
        this.itemname = itemname;
    }

    public int getItemquantity()
    {
        return itemquantity;
    }

    public void setItemquantity(int itemquantity)
    {
        this.itemquantity = itemquantity;
    }

    public String getItemcategory()
    {
        return itemcategory;
    }

    public void setItemcategory(String itemcategory)
    {
        this.itemcategory = itemcategory;
    }

    public List<UserItems> getUserItems()
    {
        return userItems;
    }

    public void setUserItems(List<UserItems> userItems)
    {
        this.userItems = userItems;
    }
}
