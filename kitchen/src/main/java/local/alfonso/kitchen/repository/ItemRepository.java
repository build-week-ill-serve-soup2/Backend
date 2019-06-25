package local.alfonso.kitchen.repository;

import local.alfonso.kitchen.models.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from UserItems where userid = :userid")
    void deleteUserItemsByUserId(long userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserItems(userid, itemid) values (:userid, :itemid)", nativeQuery = true)
    void insertUserItems(long userid, long itemid);

    List<Item> findByItemcategory(String category);


    List<Item> findByUserUserid(Long id);
}
