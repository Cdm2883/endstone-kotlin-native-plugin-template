plugins {
    kotlin("multiplatform") version "2.0.0"
    id("com.monkopedia.kplusplus.plugin") version "0.1.0"
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        compilations.getByName("main") {
//            val endstone by cinterops.creating {
//                packageName("dev.endstone")
//            }
        }
        binaries {
            sharedLib {
                baseName = if (isMingwX64) "libnative" else "native"
            }
        }
    }
    
    sourceSets {
        val nativeMain by getting
        nativeMain.dependencies {
//            implementation(project(":wrapper"))
        }
    }
}

//tasks.register("generateDefFile") {
//    doLast {
//        val headerDir = file("../endstone/include")
//        val defFile = file("../plugin/src/nativeInterop/cinterop/endstone.def")
//        defFile.parentFile.mkdirs()
//        val headerFiles = headerDir.walkTopDown().filter { it.isFile && it.extension == "h" }.toList()
//
//        fun String.recoverWinPath() = replace("\\", "/")
//        defFile.writeText("headers = ${headerFiles.first().absolutePath.recoverWinPath()}")
//        headerFiles.drop(1).forEach {
//            defFile.appendText(" ${it.absolutePath.recoverWinPath()}")
//        }
//
//        defFile.appendText("\ncompilerOpts = -I${headerDir.absolutePath.recoverWinPath()}\n")
////        defFile.appendText("linkerOpts = -L/path/to/libs -lexample\n")
//    }
//}
//tasks.named("cinteropEndstoneNative") {
//    dependsOn("generateDefFile")
//}
