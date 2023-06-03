package org.velus;

import java.io.*;

enum ReadMode { console, file }

/**
 * Класс, отвечающий за работу с вводом-выводом.
 */
public class IOManager {
    private InputStreamReader inputStreamReader;
    private BufferedWriter bufferedWriter;
    private ReadMode readMode = ReadMode.console;

    public IOManager() {
        inputStreamReader = new InputStreamReader(System.in);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /**
     * Переключает IOManager на чтение из файла вместо консоли.
     */
    public void setInputFile(String path) throws IOException {
        inputStreamReader = new InputStreamReader(new FileInputStream(path));
        readMode = ReadMode.file;
    }

    /**
     * Переключает IOManager на вывод в файл вместо консоли.
     */
    public void setOutputFile(String path) throws IOException  {
        bufferedWriter = new BufferedWriter(new FileWriter(path));
    }

    public boolean hasNext() {
        try {
            return inputStreamReader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Метод, читающий следующее слово.
     */
    public String readNext() {
        StringBuilder builder = new StringBuilder();
        while (true) {
            try {
                if (readMode == ReadMode.file && !hasNext()) break;
                char c = (char) inputStreamReader.read();
                if ((c == '\n' || c == '\r') && builder.length() == 0) return "";
                if (Character.isWhitespace(c) || c == '\n' || c == '\r') {
                    if (builder.length() == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
                builder.append(c);
            } catch (IOException ignored) { }
        }
        return builder.toString();
    }

    /**
     * Вывод строки.
     * @param s Выводимая строка.
     */
    public void write(String s) {
        try {
            bufferedWriter.write(s);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Вывод строки c добавлением переноса строки в конце.
     * @param s Выводимая строка.
     */
    public void writeLine(String s) {
        write(s + "\n");
    }
}
