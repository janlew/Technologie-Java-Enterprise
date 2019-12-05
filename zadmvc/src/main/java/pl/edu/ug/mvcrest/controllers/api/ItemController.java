package pl.edu.ug.mvcrest.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.mvcrest.model.Item;
import pl.edu.ug.mvcrest.service.ItemManager;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemManager itemManager;

    @GetMapping("/api/item")
    public List<Item> getItems() {
        return itemManager.getAll();
    }

    @GetMapping("/api/item/byid/{id}")
    public Item getItemById(@PathVariable String id) {
        return itemManager.getById(id);
    }

    @GetMapping("/api/item/byname/{name}")
    public Item getItemByName(@Valid @PathVariable String name) {
        return itemManager.getByName(name);
    }

    @DeleteMapping("/api/item/{id}")
    public void deleteItem(@PathVariable String id) {
        itemManager.remove(id);
    }

    @PutMapping("/api/item/")
    public Item updateItem(@Valid @RequestBody Item item) {
        itemManager.update(item);
        return item;
    }

    @GetMapping("/api/allWorth")
    public Double allWorth() {
        return itemManager.getAllWorth();
    }

}
