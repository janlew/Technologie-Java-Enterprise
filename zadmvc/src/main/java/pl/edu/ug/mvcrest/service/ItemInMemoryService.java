package pl.edu.ug.mvcrest.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.mvcrest.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemInMemoryService implements ItemManager {

    private static List<Item> items = new ArrayList<>();

    public ItemInMemoryService() {
        Item test = new Item("cookie", 1.0, 100);
        Item test1 = new Item("mango", 7.20, 45);
        Item test2 = new Item("water", 1.65, 230);
        add(test);
        add(test1);
        add(test2);
    }

    @Override
    public void add(Item item) {
        item.setId(UUID.randomUUID().toString());
        items.add(item);
    }

    @Override
    public void update(Item item) {
        String id = item.getId();
        Item itemToUpdate = null;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                itemToUpdate = i;
            }
        }
        if (itemToUpdate != null) {
            itemToUpdate.setName(item.getName());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setQuantity(item.getQuantity());
        }
    }

    @Override
    public Item getById(String id) {
        for (Item i : items) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Item getByName(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void remove(String id) {
        Item itemToRemove = null;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                itemToRemove = i;
            }
        }
        if (itemToRemove != null) {
            items.remove(itemToRemove);
        }
    }

    @Override
    public Double getAllWorth() {
        double worth = 0.0;
        for (Item i : items) {
            worth += i.getQuantity() * i.getPrice();
        }
        return worth;
    }
}
