package com.example.demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(length = 1000)
    var description: String? = null,

    @Column(nullable = false)
    var isDone: Boolean = false
)
