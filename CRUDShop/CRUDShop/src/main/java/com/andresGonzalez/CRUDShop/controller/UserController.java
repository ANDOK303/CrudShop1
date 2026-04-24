package com.andresGonzalez.CRUDShop.controller;

import com.andresGonzalez.CRUDShop.entity.User;
import com.andresGonzalez.CRUDShop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // Inyección del servicio por constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --- LEER (Muestra la tabla user.html) ---
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.list());
        return "user";
    }

    // --- CREAR (Muestra el formulario vacío user-form.html) ---
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    // --- GUARDAR (Procesa el botón "Guardar" del formulario) ---
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        // Como separamos la lógica en el Service, aquí validamos:
        if (user.getUserId() == null) {
            userService.create(user); // Si no tiene ID, es un usuario nuevo
        } else {
            userService.update(user.getUserId(), user); // Si tiene ID, lo actualizamos
        }
        return "redirect:/user";
    }

    // --- ACTUALIZAR (Muestra el formulario lleno para editar) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user-form";
    }

    // --- ELIMINAR ---
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/user";
    }
}