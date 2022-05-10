package com.example.todoapp.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R
import com.example.todoapp.animal.SecondActivity
import com.example.todoapp.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val todos = mutableListOf<Todo>()
        val savedTodos = gson.fromJson(sharedPreferences.getString("todos", null), Todos::class.java)
        if (savedTodos != null) {
            todos.addAll(savedTodos.items)
        }

        todoAdapter = TodoAdapter(todos)
        binding.rvTodos.adapter = todoAdapter



        binding.btnAdd.setOnClickListener {
            val todoTitle = binding.etNewtodo.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                editor.apply {
                    putString("todos", gson.toJson(Todos(todos)))
                    apply()
                }
                binding.etNewtodo.text.clear()
            }
        }
        binding.btnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

        binding.btnSecond.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}