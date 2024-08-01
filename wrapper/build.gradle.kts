plugins {
    `cpp-library`
}

library {
}

//tasks.register("generateSwigInterop") {
//    val headerDir = file("../endstone/include")
//    val interfaceFile = file("src/main/swig/endstone.i")
//    interfaceFile.parentFile.mkdirs()
//
//    val headerFiles = headerDir.walkTopDown().filter { it.isFile && it.extension == "h" }.toList()
//    interfaceFile.writeText("%module endstone\n")
//    interfaceFile.appendText("%{\n")
//    interfaceFile.appendText("#include \"${file("src/main/swig/trick.h")}\"\n")
//    headerFiles.forEach { interfaceFile.appendText("#include \"${it}\"\n") }
//    interfaceFile.appendText("%}\n")
//    interfaceFile.appendText("\n")
//    interfaceFile.appendText("%include \"${file("src/main/swig/trick.h")}\"\n")
//    headerFiles.forEach { interfaceFile.appendText("%include \"${it}\"\n") }
//}
