package mobi.mpk.concentration.presentation.tasks.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.task_item.view.*
import mobi.mpk.concentration.R
import mobi.mpk.concentration.domain.Task

class TasksAdapter(var tasks: List<Task>) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    lateinit var listener: TaskCheckedListener
    lateinit var clickTaskListener: (text: String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(viewHolder: TaskViewHolder, position: Int) {
        viewHolder.textView.text = tasks[position].text
        viewHolder.textView.setOnClickListener { clickTaskListener.invoke(tasks[position].text) }
        viewHolder.radioButton.isChecked = false
        viewHolder.radioButton.setOnClickListener(listener.handle(position))
    }


    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.task_text
        val radioButton = itemView.radioButton_task

        init {
            radioButton.isChecked = false
        }

    }

    interface TaskCheckedListener {
        fun handle(position: Int): (View) -> Unit
    }

}