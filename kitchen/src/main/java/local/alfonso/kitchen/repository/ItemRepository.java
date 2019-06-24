package local.alfonso.kitchen.repository;

import local.alfonso.kitchen.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>
{
    Item findByItemcategory(String category);
}
