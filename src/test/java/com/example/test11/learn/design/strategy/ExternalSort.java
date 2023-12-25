package com.example.test11.learn.design.strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalSort {


    private static List<File> partition(File inputFile,int chunkSize) throws IOException{

        List<File> chunks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){

            String line;
            List<String> chunkLines = new ArrayList<>();
            int linesRead = 0;
            int chunkNumber = 0;

            //分成多个文件
            while((line = reader.readLine())!=null){
                chunkLines.add(line);
                linesRead++;
                if (linesRead == chunkSize){
                    chunks.add(writeChunk(chunkLines,chunkNumber++));
                    chunkLines.clear();
                    linesRead = 0;
                }
            }

            if (!chunkLines.isEmpty()){
                chunks.add(writeChunk(chunkLines,chunkNumber++));
            }
        }
        return chunks;
    }

    private static File writeChunk(List<String> lines, int chunkNumber) throws IOException {

        File chunkFile = new File("chunk_" + chunkNumber + ".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFile)))
        {
            lines.forEach(line->{
                try{
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return chunkFile;
    }


    private static void merge(List<File> sortedChunks,File outputFile) throws IOException {
        PriorityQueue<ChunkReader> minHeap = new PriorityQueue<>(Comparator.comparingInt(ChunkReader::getValue));

        for (File chunk : sortedChunks) {
            ChunkReader reader = new ChunkReader(chunk);
            if (reader.hasNext()){
                minHeap.add(reader);
            }

        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            while (!minHeap.isEmpty()){
                ChunkReader currentReader = minHeap.poll();
                writer.write(String.valueOf(currentReader.getValue()));
                writer.newLine();

                while (currentReader.hasNext()){
                    writer.write(String.valueOf(currentReader.getValue()));
                    writer.newLine();
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        File file = new File("large_data.txt");
        int chunkSize = 1000000;

        //划分阶段
        List<File> sortedChunks = partition(file, chunkSize);

        //合并阶段
        File outputFile = new File("result.txt");
        merge(sortedChunks,outputFile);
    }
}
