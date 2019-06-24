package local.alfonso.kitchen.services;

import local.alfonso.kitchen.models.Item;

import java.util.List;

public interface ItemService
{
    List<Item> findAll();

    Item findItemById(long id);

    void delete(long id);

    Item save(Item item);

    Item findByName(String name);
}
