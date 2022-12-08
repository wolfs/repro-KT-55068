package org.gradle.build.reproducer

import org.gradle.api.provider.Provider

abstract class VersionBundle {
    enum class CiMode(val literal: String?) {
        /**
         * The tests for this version bundle are executed on each commit.
         */
        EACH_COMMIT(null),

        /**
         * The tests for this version bundle are only executed once a day.
         */
        DAILY("daily"),

        /**
         * The tests for this version bundle are only executed once a day.
         * They are based on a snapshot version of the respective build tool.
         */
        NIGHTLY("nightly")
    }

    enum class Tool(val literal: String) {
        GRADLE("Gradle"),
        MAVEN("Maven"),
        BAZEL("Bazel"),
        JUNIT("JUnit"),
        GRADLE_ENTERPRISE("Gradle Enterprise")
    }

    /**
     * The name of the tool that is tested.
     *
     * This is only used for generating task names and descriptions.
     */
    abstract val tool: Tool

    /**
     * The tool version.
     */
    abstract val toolVersion: Provider<String>

    enum class ToolVersionType(val literal: String) {
        RELEASE(""),
        RELEASE_NIGHTLY("ReleaseNightly"),
        NIGHTLY("Nightly")
    }

    /**
     * The tool version type.
     */
    abstract val toolVersionType: ToolVersionType

    open val ciMode: CiMode
        get() = CiMode.EACH_COMMIT

    open val buildAgentVersions: List<String>
        get() = emptyList()

    open val taskNameRelevantVersions: Map<String, String>
        get() = emptyMap()
}