package mobi.mpk.concentration.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mobi.mpk.concentration.R
import mobi.mpk.concentration.domain.AuthInteractor
import mobi.mpk.concentration.domain.TasksInteractor
import mobi.mpk.concentration.presentation.auth.AuthPresenter
import mobi.mpk.concentration.presentation.auth.AuthRouter
import mobi.mpk.concentration.presentation.auth.LoginFragment
import mobi.mpk.concentration.presentation.auth.SignUpFragment
import mobi.mpk.concentration.presentation.tasks.*
import mobi.mpk.concentration.presentation.tasks.creator.TaskCreatorFragment
import mobi.mpk.concentration.presentation.tasks.creator.TaskCreatorPresenter
import mobi.mpk.concentration.presentation.tasks.main.TasksFragment
import mobi.mpk.concentration.presentation.tasks.main.TasksPresenter

class MainActivity : AppCompatActivity(), TasksRouter, AuthRouter {

    private val tasksInteractor = TasksInteractor()
    private val tasksPresenter = TasksPresenter(tasksInteractor, this)
    private val authPresenter = AuthPresenter(AuthInteractor(), this)
    private val taskCreatorPresenter = TaskCreatorPresenter(tasksInteractor, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragment = supportFragmentManager.findFragmentById(R.id.tasks_container)
        if (fragment == null)
            supportFragmentManager.beginTransaction()
                    .add(R.id.tasks_container, LoginFragment(authPresenter))
                    .commit()
    }

    override fun openAllTasks() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.tasks_container, TasksFragment(tasksPresenter))
                .commit()
    }

    override fun openTaskEditor(task: String) {
        val fragment = TaskCreatorFragment(taskCreatorPresenter)
        val bundle = Bundle()
        bundle.putString("TASK_TEXT", task)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
                .replace(R.id.tasks_container, fragment)
                .commit()
    }

    override fun openTaskCreator() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.tasks_container, TaskCreatorFragment(taskCreatorPresenter))
                .commit()
    }

    override fun openLogin() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.tasks_container, LoginFragment(authPresenter))
                .commit()
    }

    override fun openSignUp() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.tasks_container, SignUpFragment(authPresenter))
                .commit()
    }

    override fun openMain() {
        openAllTasks()
    }

}
