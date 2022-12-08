import org.gradle.build.reproducer.VersionBundle.ToolVersionType
import org.gradle.build.reproducer.VersionBundle.CiMode
import org.gradle.build.reproducer.BazelVersionBundle

val baseVersion = "1.7"
val latestAgentVersion = "$baseVersion-prerelease"

data class BuildScansBazelVersionBundle(
        val bazelVersion: Provider<String>,
        override val toolVersionType: ToolVersionType = ToolVersionType.RELEASE,
        override val ciMode: CiMode = CiMode.EACH_COMMIT,
        override val buildAgentVersions: List<String> = listOf(latestAgentVersion)
) : BazelVersionBundle(
        bazelVersion
) {

    constructor(
            bazelVersion: String,
            toolVersionType: ToolVersionType = ToolVersionType.RELEASE,
            ciMode: CiMode = CiMode.EACH_COMMIT,
            buildAgentVersions: List<String> = listOf(latestAgentVersion)
    ) : this(
            provider { bazelVersion },
            toolVersionType,
            ciMode,
            buildAgentVersions
    )
}