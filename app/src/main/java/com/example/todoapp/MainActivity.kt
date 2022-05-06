package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todos = mutableListOf<Todo>(
            Todo("call my mom"),
            Todo("Go to school"),
            Todo("Listen mucis", true)
        )

        todoAdapter = TodoAdapter(todos)
        rv_todos.adapter = todoAdapter

        btn_add.setOnClickListener {
            val todoTitle = et_newtodo.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                et_newtodo.text.clear()
            }
        }
        btn_delete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}