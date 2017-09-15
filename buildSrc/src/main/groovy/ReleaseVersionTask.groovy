import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class ReleaseVersionTask extends DefaultTask {
    @Input
    Boolean release = false
    @OutputFile
    File destFile

    ReleaseVersionTask() {
        group = 'versioning'
        description = 'Make project a release version.'
    }

    @TaskAction
    void start() {
        println("before version is :" + project.version)
        project.version = project.version - "-SNAPSHOT"
        println("after released:" + project.version)
        //project.version.release = true
        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: 'true')
        }
    }
}