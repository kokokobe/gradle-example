import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class GreetingPluginTask extends DefaultTask {
    final PropertyState<String> message = project.property(String)
    final ConfigurableFileCollection outputFiles = project.files()

    @Input
    String getMessage() {
        message.get()
    }

    void setMessage(String message) {
        this.message.set(message)
    }

    void setMessage(Provider<String> message) {
        this.message.set(message)
    }

    FileCollection getOutputFiles() {
        outputFiles
    }

    void setOutputFiles(FileCollection outputFiles) {
        this.outputFiles.setFrom(outputFiles)
    }

    @TaskAction
    void printMessage() {
        getOutputFiles().each {
            logger.quiet "Writing message 'Hi from Gradle' to file"
            it.text = getMessage()
        }
    }
}
