package com.diomede.album;

import com.diomede.album.service.AlbumService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Diomede-Album PoC initialized.");
        
        AlbumService service = new AlbumService();
        
        // Yahan apne sample data ka path do
        String testDataPath = "./data"; 
        
        service.processDirectory(testDataPath);
        service.displayAlbums();
    }
}