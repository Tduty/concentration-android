package mobi.mpk.concentration.presentation.tasks.main

import mobi.mpk.concentration.domain.Task
import mobi.mpk.concentration.domain.TasksInteractor
import mobi.mpk.concentration.presentation.tasks.TasksRouter

class TasksPresenter(private val interactor: TasksInteractor, private val router: TasksRouter) {

    fun addTask() {
        router.openTaskCreator()
    }

    fun getTasks(): List<Task> {
        return interactor.getAllTasks()
    }

    fun openEditorTask(task: String) {
        router.openTaskEditor(task)
    }

    fun deleteTask(position: Int) {
        interactor.deleteTask(position)
    }

}