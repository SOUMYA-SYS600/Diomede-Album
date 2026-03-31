package com.diomede.album.parser;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import java.io.File;
import java.io.IOException;

public class DicomParser {
    public static Attributes parseMetadata(File file) throws IOException {
        try (DicomInputStream dis = new DicomInputStream(file)) {
            // Hum sirf metadata read kar rahe hain, pixels (images) nahi
            // Isse code fast chalega
            return dis.readDataset(-1, Tag.PixelData);
        }
    }
    
    public static String getTagValue(Attributes attrs, int tag) {
        return attrs.getString(tag, "Unknown");
    }
}