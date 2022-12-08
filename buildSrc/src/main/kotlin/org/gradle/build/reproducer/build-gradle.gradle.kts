import org.gradle.build.reproducer.BuildToolVersionBundle

val baseVersion = "1.7"
val latestAgentVersion = "$baseVersion-prerelease"

data class BuildScansBazelVersionBundle(
        val bazelVersion: Provider<String>,
        override val buildAgentVersions: List<String> = listOf(latestAgentVersion)
) : BuildToolVersionBundle(
        bazelVersion
) {
    constructor(
            bazelVersion: String,
            buildAgentVersions: List<String> = listOf(latestAgentVersion)
    ) : this(
            provider { bazelVersion },
            buildAgentVersions
    )
}