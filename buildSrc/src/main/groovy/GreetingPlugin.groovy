import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create('greetingGradle', GreetingPluginExtension, project)
        project.tasks.create('hello', GreetingPluginTask) {
            message = extension.message
            outputFiles = extension.outputFiles
        }
    }
}
