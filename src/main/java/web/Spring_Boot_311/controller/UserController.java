package web.Spring_Boot_311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.Spring_Boot_311.model.User;
import web.Spring_Boot_311.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //	Все Юзеры
    @GetMapping(value = "/")
    public String getAllUser(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    // Выбрать юзера по ID
    @GetMapping("/{id}")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "show";
    }

    //	Добавить Юзера
    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    //  Изменить Юзера
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    //   Удалить Юзера
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
