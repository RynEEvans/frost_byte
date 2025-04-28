package com.frost_byte;

<<<<<<< HEAD
<<<<<<< HEAD
public class PlaylistController {
    
    private PrimaryController primary;

    public void setPrimaryController(PrimaryController controller) {
        this.primary = controller;
    }
    
=======
=======
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

>>>>>>> 4412a1bef7e07b4d4ca403282b594ee326d9af6b
import com.model.DataLoader;
import com.model.Song;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class PlaylistController implements Initializable {

    //@FXML
    //private ListView<String> songList;

    // @FXML
    // private TextField songSearch;

    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> songTitleArrList = new ArrayList<String>();

    // public void loadSongs() {
        
    //     ArrayList<Song> songArrayList = DataLoader.getSongs();
    //     for (Song song : songArrayList) {
    //         songTitleArrList.add(song.getTitle());
    //     }

    //     ObservableList<String> observeSongList = FXCollections.observableArrayList(songTitleArrList);
    //     songList = new ListView<String>(observeSongList);
    //     System.out.println(songList.getItems());
    // }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    //     System.out.println("pre-load Songs");
    //     loadSongs();

    // }

    @FXML
    private ListView<String> myListView;

   // ArrayList<Song> songs = new ArrayList<>();
    // ArrayList<Song> songObjects = DataLoader.getSongs();
    // ArrayList<String> songTitles = new ArrayList<String>();

    // for (int i = 0; i < songObjects.size(); i++) {
    //     songTitles.add(song.getTitle());  // Assuming the Song class has a getTitle() method
    // }
    


   
    String currentSong; 
   // private ListView<Song> songList;
    @FXML
    private TextField songSearch;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        
        // songTitles.add("currentSong");
        // myListView.getItems().addAll(songTitles);

        ArrayList<Song> songArrayList = DataLoader.getSongs();
        for (Song song : songArrayList) {
            songTitleArrList.add(song.getTitle());
        }

        myListView.getItems().addAll(songTitleArrList);
        //System.out.println(songList.getItems());

    }
    // private ArrayList<Song> songs = new ArrayList<>();

    // public void loadSongs() {

    //     ArrayList<Song> songArrayList = DataLoader.getSongs();
    //     for (Song song : songArrayList) {
    //         songList.getItems().add(song);
    //     }

    // }

<<<<<<< HEAD
        }
    }
>>>>>>> 09191232ec5d572a114d130e307894926e65d79b
}
=======
    // public void initialize() {
    //     songs = DataLoader.getSongs();
    // }

    // @FXML
    // private void searchButtonClick() {
    //     ObservableList<Song> songListObservableList = songList.getItems();
    //     String selectedSong = songSearch.getText();

    //     if (songList != null && !songListObservableList.isEmpty()) {
    //         // Iterate through the ObservableList using an enhanced for-loop
    //         for (Song song : songListObservableList) {
    //             if (song.getTitle().contains(selectedSong)) {
    //                 System.out.println("Song Title: " + song.getTitle() + ", Artist: " + song.getArtist());
    //             }
    //         }

    //     }
    // }
}
>>>>>>> 4412a1bef7e07b4d4ca403282b594ee326d9af6b
