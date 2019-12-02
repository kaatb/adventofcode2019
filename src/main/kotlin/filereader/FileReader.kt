package filereader

class FileReader {

    fun readLines(fileName: String): List<String> = object{}.javaClass.classLoader.getResourceAsStream(fileName)
        .bufferedReader()
        .readLines()
        .filterNot { it.isBlank() }
}