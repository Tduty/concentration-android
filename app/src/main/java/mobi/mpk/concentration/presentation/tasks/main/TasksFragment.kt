package mobi.mpk.concentration.presentation.tasks.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_tasks.view.*
import mobi.mpk.concentration.R
import mobi.mpk.concentration.presentation.tasks.main.TasksAdapter.TaskCheckedListener

@SuppressLint("ValidFragment")
class TasksFragment(private val presenter: TasksPresenter) : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_tasks, container, false)
        initRecyclerView(view.task_list)
        view.fab_add_button.setOnClickListener({presenter.addTask()})
        return view
    }

    private fun initRecyclerView(view: RecyclerView) {
        recyclerView = view
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TasksAdapter(presenter.getTasks())
        adapter.listener = object: TaskCheckedListener {
            override fun handle(position: Int): (View) -> Unit = {
                presenter.deleteTask(position)
                adapter.tasks = presenter.getTasks()
                adapter.notifyDataSetChanged()
                Toast.makeText(context, "А ты не промах!", Toast.LENGTH_SHORT).show()
            }

        }
        adapter.clickTaskListener = {text ->  presenter.openEditorTask(text)}
        recyclerView.adapter = adapter
    }

}