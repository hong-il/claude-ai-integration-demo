package com.example.demo.service

import com.example.demo.domain.Todo
import com.example.demo.dto.TodoCreateRequest
import com.example.demo.dto.TodoResponse
import com.example.demo.dto.TodoUpdateRequest
import com.example.demo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TodoService(
    private val todoRepository: TodoRepository
) {

    @Transactional
    fun createTodo(request: TodoCreateRequest): TodoResponse {
        val todo = Todo(
            title = request.title,
            description = request.description
        )
        val savedTodo = todoRepository.save(todo)
        return savedTodo.toResponse()
    }

    fun getAllTodos(): List<TodoResponse> {
        return todoRepository.findAll().map { it.toResponse() }
    }

    fun getTodoById(id: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Todo not found with id: $id")
        return todo.toResponse()
    }

    @Transactional
    fun updateTodo(id: Long, request: TodoUpdateRequest): TodoResponse {
        val todo = todoRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Todo not found with id: $id")

        request.title?.let { todo.title = it }
        request.description?.let { todo.description = it }
        request.isDone?.let { todo.isDone = it }

        return todo.toResponse()
    }

    @Transactional
    fun deleteTodo(id: Long) {
        if (!todoRepository.existsById(id)) {
            throw NoSuchElementException("Todo not found with id: $id")
        }
        todoRepository.deleteById(id)
    }

    private fun Todo.toResponse(): TodoResponse {
        return TodoResponse(
            id = this.id!!,
            title = this.title,
            description = this.description,
            isDone = this.isDone
        )
    }
}
