package com.diomede.album.service;

import com.diomede.album.parser.DicomParser;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import java.io.File;
import java.util.*;

public class AlbumService {
    // Map of StudyInstanceUID -> List of Files
    private Map<String, List<File>> albumStore = new HashMap<>();

    public void processDirectory(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".dcm"));

        if (files == null) return;

        for (File f : files) {
            try {
                Attributes attrs = DicomParser.parseMetadata(f);
                // Har DICOM study ki ek unique ID hoti hai: StudyInstanceUID
                String studyId = DicomParser.getTagValue(attrs, Tag.StudyInstanceUID);
                
                albumStore.computeIfAbsent(studyId, k -> new ArrayList<>()).add(f);
            } catch (Exception e) {
                System.err.println("Skipping corrupted file: " + f.getName());
            }
        }
    }

    public void displayAlbums() {
        System.out.println("\n--- Generated Albums ---");
        albumStore.forEach((id, files) -> {
            System.out.println("Album ID: " + id + " | Total Images: " + files.size());
        });
    }
}