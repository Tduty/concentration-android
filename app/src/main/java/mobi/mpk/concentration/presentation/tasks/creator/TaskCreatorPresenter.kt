package mobi.mpk.concentration.presentation.tasks.creator

import mobi.mpk.concentration.domain.TasksInteractor
import mobi.mpk.concentration.presentation.tasks.TasksRouter

class TaskCreatorPresenter(private val interactor: TasksInteractor, private val router: TasksRouter) {

    fun addTask(task: String) {
        interactor.addTask(task)
        router.openAllTasks()
    }

    fun editTask(oldTask: String?, task: String) {
        interactor.editTask(oldTask, task)
        router.openAllTasks()
    }

}