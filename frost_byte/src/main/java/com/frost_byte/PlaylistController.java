package com.frost_byte;

<<<<<<< HEAD
public class PlaylistController {
    
    private PrimaryController primary;

    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;
    }
    
=======
import com.model.DataLoader;
import com.model.Song;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class PlaylistController {

    @FXML
    private ListView<Song> songList;
    @FXML
    private TextField songSearch;

    private ArrayList<Song> songs = new ArrayList<>();

    public void loadSongs() {

        ArrayList<Song> songArrayList = DataLoader.getSongs();
        for (Song song : songArrayList) {
            songList.getItems().add(song);
        }

    }

    public void initialize() {
        songs = DataLoader.getSongs();
    }

    @FXML
    private void searchButtonClick() {
        ObservableList<Song> songListObservableList = songList.getItems();
        String selectedSong = songSearch.getText();

        if (songList != null && !songListObservableList.isEmpty()) {
            // Iterate through the ObservableList using an enhanced for-loop
            for (Song song : songListObservableList) {
                if (song.getTitle().contains(selectedSong)) {
                    System.out.println("Song Title: " + song.getTitle() + ", Artist: " + song.getArtist());
                }
            }

        }
    }
>>>>>>> 09191232ec5d572a114d130e307894926e65d79b
}
