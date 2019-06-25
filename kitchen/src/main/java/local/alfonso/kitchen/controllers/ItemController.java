package local.alfonso.kitchen.controllers;

import local.alfonso.kitchen.models.Item;
import local.alfonso.kitchen.models.User;
import local.alfonso.kitchen.services.ItemService;
import local.alfonso.kitchen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userid}", produces = {"application/json"})
    public ResponseEntity<?> getAllItemsByUserId(@PathVariable long userid)
    {
        List<Item> items = itemService.findByUserId(userid);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/{userid}/items", produces = {"application/json"})
    public ResponseEntity<?> addNewItem(HttpServletRequest request, @PathVariable long userid, @Valid @RequestBody Item item)
    {
        User u1 = userService.findUserById(userid);
        item.setUser(u1);
        item = itemService.save(item);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newItemURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{itemid}")
                .buildAndExpand(item.getItemid())
                .toUri();
        responseHeaders.setLocation(newItemURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{itemid}")
    public ResponseEntity<?> updateItem(@RequestBody Item updateItem, @PathVariable long itemid)
    {
        itemService.update(updateItem, itemid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
