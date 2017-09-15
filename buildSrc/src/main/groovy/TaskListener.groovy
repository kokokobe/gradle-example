import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.execution.TaskExecutionGraphListener

class TaskListener implements TaskExecutionGraphListener{
    @Override
    void graphPopulated(TaskExecutionGraph taskExecutionGraph) {
        println taskExecutionGraph.allTasks
        if (taskExecutionGraph.hasTask(":tasks")) {
            println "listener task configuration insert"
        }
    }
}
