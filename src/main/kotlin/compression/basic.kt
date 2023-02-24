package compression

//fun compress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val data = input.readBytes()
//    val deflater = Deflater()
//    deflater.setInput(data)
//    deflater.finish()
//    val buffer = ByteArray(1024)
//    while (!deflater.finished()) {
//        val count = deflater.deflate(buffer)
//        output.write(buffer, 0, count)
//    }
//    input.close()
//    output.close()
//}
//
//fun decompress(inputFile: File, outputFile: File) {
//    val input: InputStream = FileInputStream(inputFile)
//    val output: OutputStream = FileOutputStream(outputFile)
//    val buffer = ByteArray(1024)
//    val inflater = Inflater()
//    while (!inflater.finished()) {
//        val count = input.read(buffer)
//        inflater.setInput(buffer, 0, count)
//        while (inflater.inflate(buffer).also { output.write(buffer, 0, it) } != 0);
//    }
//    input.close()
//    output.close()
//}
