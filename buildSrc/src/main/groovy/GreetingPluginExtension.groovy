import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider

class GreetingPluginExtension {
    PropertyState<String> message
    ConfigurableFileCollection outputFiles

    GreetingPluginExtension(Project project) {
        message = project.property(String)
        message.set('Hello from GreetingPlugin')
        outputFiles = project.files()
    }
    String getMessage() {
        message.get()
    }

    Provider<String> getMessageProvider() {
        message
    }

    void setMessage(String message) {
        this.message.set(message)
    }

    FileCollection getOutputFiles() {
        outputFiles
    }

    void setOutputFiles(FileCollection outputFiles) {
        this.outputFiles.setFrom(outputFiles)
    }
}
