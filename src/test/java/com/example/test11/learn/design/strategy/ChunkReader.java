package com.example.test11.learn.design.strategy;

import java.io.*;

public class ChunkReader {

    private BufferedReader reader;

    private String currentLine;

    public ChunkReader(File file) throws IOException {

      this.reader = new BufferedReader(new FileReader(file));
      this.currentLine = reader.readLine();
    }

    public int getValue(){
        return Integer.parseInt(currentLine);
    }

    public boolean hasNext() throws IOException {
        currentLine = reader.readLine();
        return currentLine != null;
    }
}
