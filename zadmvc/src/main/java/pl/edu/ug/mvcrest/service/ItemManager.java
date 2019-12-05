package pl.edu.ug.mvcrest.service;

import pl.edu.ug.mvcrest.model.Item;

import java.util.List;

public interface ItemManager {

    void add(Item item);

    void update(Item item);

    Item getById(String id);

    Item getByName(String name);

    List<Item> getAll();

    void remove(String id);

    Double getAllWorth();
}
