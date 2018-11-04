package mobi.mpk.concentration.domain

import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList

class TasksInteractor {

    private val list = ArrayList<Task>()

    fun getAllTasks(): List<Task> {
        return list
    }

    fun addTask(task: String) {
        list.add(Task(task, Date()))
    }

    fun editTask(oldTask: String?, task: String) {
        list.filter { s -> s.text.equals(oldTask) }[0].text = task
    }

    fun deleteTask(position: Int) {
        list.removeAt(position)
    }

}