import org.gradle.build.reproducer.VersionBundle

val latestAgentVersion = "15"

data class BuildScansBazelVersionBundle(
        val bazelVersion: Provider<String>,
        override val buildAgentVersions: List<String> = listOf(latestAgentVersion)
) : VersionBundle(
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