package org.gradle.build.reproducer

import org.gradle.api.provider.Provider
import org.gradle.build.reproducer.VersionBundle.CiMode.EACH_COMMIT
import org.gradle.build.reproducer.VersionBundle.ToolVersionType.RELEASE

open class BuildToolVersionBundle(
        override val tool: Tool,
        override val toolVersion: Provider<String>,
        override val toolVersionType: ToolVersionType = RELEASE,
        override val ciMode: CiMode = EACH_COMMIT,
        override val buildAgentVersions: List<String> = emptyList(),
        override val taskNameRelevantVersions: Map<String, String> = emptyMap()
) : VersionBundle()