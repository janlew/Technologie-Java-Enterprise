package pl.edu.ug.mvcrest.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.mvcrest.model.Item;
import pl.edu.ug.mvcrest.service.ItemManager;

import javax.validation.Valid;

@Controller("item")
public class ItemController {

    private ItemManager itemManager;

    @Autowired
    public ItemController(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @GetMapping("/item")
    public String home(Model model) {
        model.addAttribute("items", itemManager.getAll());
        return "all-items";
    }

    @GetMapping("/item/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping("/item/added")
    public String afterAdd(@Valid Item item, Model model) {
        itemManager.add(item);
        model.addAttribute("items", itemManager.getAll());
        return "all-items";
    }

    @GetMapping("/item/remove/{id}")
    public String deleteItem(@PathVariable("id") String id, Model model) {
        itemManager.remove(id);
        model.addAttribute("items", itemManager.getAll());
        return "all-items";
    }

    @GetMapping("/item/update/{id}")
    public String updateItem(@PathVariable("id") String id, Model model) {
        model.addAttribute("item", itemManager.getById(id));
        return "update-item";
    }

    @PostMapping("/item/update")
    public String postUpdate(Item item, Model model) {
        itemManager.update(item);
        model.addAttribute("items", itemManager.getAll());
        return "all-items";
    }

    @GetMapping("/item/worth")
    public String getWorth(Model model) {
        model.addAttribute("worth", itemManager.getAllWorth());
        model.addAttribute("items", itemManager.getAll());
        return "all-items";
    }

}
