package bai5;

import java.io.Serializable;

public class FileInfo implements Serializable {
    private String filename;
    private int numOfParts;
    private int lastPartSize;

    public FileInfo(String filename, int numOfParts, int lastPartSize) {
        this.filename = filename;
        this.numOfParts = numOfParts;
        this.lastPartSize = lastPartSize;
    }

    public String getFilename() {
        return filename;
    }

    public int getNumOfParts() {
        return numOfParts;
    }

    public int getLastPartSize() {
        return lastPartSize;
    }
}