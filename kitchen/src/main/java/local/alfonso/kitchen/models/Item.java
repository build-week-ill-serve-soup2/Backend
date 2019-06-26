package local.alfonso.kitchen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private int itemthreshold;

    private String itemunit;

    private String itemcategory;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private User user;

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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;

    }

    public void setUserItems(List<UserItems> userItems)
    {
        this.userItems = userItems;
    }

    public int getItemthreshold()
    {
        return itemthreshold;
    }

    public void setItemthreshold(int itemthreshold)
    {
        this.itemthreshold = itemthreshold;
    }

    public String getItemunit()
    {
        return itemunit;
    }

    public void setItemunit(String itemunit)
    {
        this.itemunit = itemunit;
    }
}
