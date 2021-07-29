tasks {
  jar {
    manifest {
      attributes("Automatic-Module-Name" to "mockwebserver3.junit5")
    }
  }
  test {
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
  }
}

dependencies {
  api(project(":mockwebserver"))
  api(Dependencies.junit5Api)
  compileOnly(Dependencies.animalSniffer)

  testRuntimeOnly(Dependencies.junit5JupiterEngine)
  testImplementation(Dependencies.assertj)
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.4.10")
}

afterEvaluate {
  tasks.dokka {
    outputDirectory = "$rootDir/docs/4.x"
    outputFormat = "gfm"
  }
}
