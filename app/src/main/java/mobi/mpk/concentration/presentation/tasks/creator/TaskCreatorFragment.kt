package mobi.mpk.concentration.presentation.tasks.creator

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_creator_task.view.*
import mobi.mpk.concentration.R

@SuppressLint("ValidFragment")
class TaskCreatorFragment(private val presenter: TaskCreatorPresenter) : Fragment() {

    private var taskText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskText = arguments?.getString("TASK_TEXT", "")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_creator_task, container, false)
        if (taskText == null) {
            view.button_add_task.setOnClickListener { presenter.addTask(view.editText_task.text.toString()) }
        } else {
            view.button_add_task.setOnClickListener { presenter.editTask(taskText, view.editText_task.text.toString()) }
            view.editText_task.text = Editable.Factory.getInstance().newEditable(taskText)
        }
        return view
    }

}