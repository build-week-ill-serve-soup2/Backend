package local.alfonso.kitchen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User item_user;

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

    public User getItem_user()
    {
        return item_user;
    }

    public void setItem_user(User item_user)
    {
        this.item_user = item_user;
    }

    public void setItemcategory(String itemcategory)
    {
        this.itemcategory = itemcategory;
    }
}
