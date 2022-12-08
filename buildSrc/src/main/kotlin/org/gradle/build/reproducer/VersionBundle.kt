package org.gradle.build.reproducer

import org.gradle.api.provider.Provider

abstract class VersionBundle {

    abstract val toolVersion: Provider<String>

    open val buildAgentVersions: List<String>
        get() = emptyList()
}