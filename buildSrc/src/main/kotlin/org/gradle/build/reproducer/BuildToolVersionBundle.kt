package org.gradle.build.reproducer

import org.gradle.api.provider.Provider

open class BuildToolVersionBundle(
        override val toolVersion: Provider<String>,
        override val buildAgentVersions: List<String> = emptyList(),
) : VersionBundle()