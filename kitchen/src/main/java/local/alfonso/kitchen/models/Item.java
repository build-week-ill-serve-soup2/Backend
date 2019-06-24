package local.alfonso.kitchen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;

    @Column(nullable = false)
    private String itemname;

    @Column(nullable = true)
    private int itemquantity;

    private String itemcategory;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("items")
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

    public void setItemcategory(String itemcategory)
    {
        this.itemcategory = itemcategory;
    }
}
