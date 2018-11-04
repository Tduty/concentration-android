package mobi.mpk.concentration.presentation.tasks

interface TasksRouter {

    fun openTaskCreator()

    fun openAllTasks()

    fun openTaskEditor(task: String)

}