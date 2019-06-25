package local.alfonso.kitchen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "useritems")
public class UserItems extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userItems")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "itemid")
    @JsonIgnoreProperties("userItems")
    private Item item;

    public UserItems()
    {
    }

    public UserItems(User user, Item item)
    {
        this.user = user;
        this.item = item;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof UserItems)) return false;
        UserItems userItems = (UserItems) o;
        return getUser().equals(userItems.getUser()) &&
                getItem().equals(userItems.getItem());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getItem());
    }
}
