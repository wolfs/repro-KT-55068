package org.gradle.build.reproducer

import org.gradle.api.provider.Provider

abstract class VersionBundle(
        val toolVersion: Provider<String>,
        open val buildAgentVersions: List<String> = emptyList()
) {
}