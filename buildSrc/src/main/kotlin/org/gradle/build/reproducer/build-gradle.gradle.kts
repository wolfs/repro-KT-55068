import org.gradle.build.reproducer.BazelVersionBundle

val baseVersion = "1.7"
val latestAgentVersion = "$baseVersion-prerelease"

data class BuildScansBazelVersionBundle(
        val bazelVersion: Provider<String>,
        override val buildAgentVersions: List<String> = listOf(latestAgentVersion)
) : BazelVersionBundle(
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