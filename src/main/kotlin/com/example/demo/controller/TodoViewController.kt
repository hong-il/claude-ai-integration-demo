package com.example.demo.controller

import com.example.demo.dto.TodoCreateRequest
import com.example.demo.service.TodoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/todos")
class TodoViewController(
    private val todoService: TodoService
) {

    @GetMapping
    fun listTodos(model: Model): String {
        val todos = todoService.getAllTodos()
        model.addAttribute("todos", todos)
        return "list"
    }

    @GetMapping("/create")
    fun createForm(): String {
        return "create"
    }

    @PostMapping("/create")
    fun createTodo(
        @RequestParam title: String,
        @RequestParam(required = false) description: String?
    ): String {
        val request = TodoCreateRequest(title, description)
        todoService.createTodo(request)
        return "redirect:/todos"
    }

    @PostMapping("/{id}/toggle")
    fun toggleTodo(@PathVariable id: Long): String {
        val todo = todoService.getTodoById(id)
        val updateRequest = com.example.demo.dto.TodoUpdateRequest(
            title = null,
            description = null,
            isDone = !todo.isDone
        )
        todoService.updateTodo(id, updateRequest)
        return "redirect:/todos"
    }

    @PostMapping("/{id}/delete")
    fun deleteTodo(@PathVariable id: Long): String {
        todoService.deleteTodo(id)
        return "redirect:/todos"
    }
}
