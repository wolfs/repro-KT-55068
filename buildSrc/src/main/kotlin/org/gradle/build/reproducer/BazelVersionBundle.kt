package org.gradle.build.reproducer

import org.gradle.api.provider.Provider

open class BazelVersionBundle(
        bazelVersion: Provider<String>,
) : BuildToolVersionBundle(
        bazelVersion
)