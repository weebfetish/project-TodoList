import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos)

        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}

data class Todo(
    val title: String,
    var isChecked: Boolean = false
)

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    // Implement the necessary methods for your RecyclerView.Adapter
    // addTodo, deleteDoneTodos, etc.
}
