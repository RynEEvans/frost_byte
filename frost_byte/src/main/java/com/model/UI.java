package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.player.Player;

public class UI { /*
                   * ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO
                   * FACADE
                   */

    private MusicApplication application;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLACK = "\u001B[30m";

    public UI() {
        this.application = new MusicApplication();
    }

    public void scenario2() {
        System.out.println("What would you like to do?");
        System.out.println("Play song, edit song, take lesson, log out, search for song");
        System.out.println(ANSI_GREEN);
        System.out.println("Search for song");
        System.out.println(ANSI_BLACK);
        System.out.println("Enter artist name:");
        System.out.println(ANSI_GREEN);
        System.out.println("Traditional");
        System.out.println(ANSI_BLACK);
        ArrayList<Song> songs = application.getSongsByArtist("Tradtional");
        for (Song song : songs) {
            System.out.println(song.getTitle());
        }
        System.out.println("Select a song to play");
        System.out.println(ANSI_GREEN);
        System.out.println("Hot Cross Buns");
        System.out.println(ANSI_BLACK);
        Song chosenSong = application.getSongByTitle("Hot Cross Buns");

        Player player = new Player();
        application.playSong(chosenSong);

    }

    public void scenario3() {

        String testUsername1 = "NeonWave";
        String testPassword1 = "AncientTome";

        String testUsername2 = "asmith";
        String testPassword2 = "SurfVibes";

        System.out.println("Login:");
        System.out.print(ANSI_GREEN);
        System.out.println("Username: " + testUsername1);
        System.out.println("Password: " + testPassword1);

        System.out.print(ANSI_BLACK);
        Boolean isLoggedin = application.login(testUsername1, testPassword1);
        if (isLoggedin) {
            application.getUser(testUsername1);
            System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName(testUsername1));
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println("");
            System.out.println(
                    "Select an activity: Play song, edit song, Take lesson, log out, search for song, Make song");
            System.out.print(ANSI_GREEN);
            System.out.println("Make song");
            System.out.print(ANSI_BLACK);
            System.out.println("What would you like to name it?");
            System.out.print(ANSI_GREEN);
            System.out.println("A horses journey");
            System.out.print(ANSI_BLACK);
            System.out.println("Making song named A horses journey.....");

            ArrayList<Measure> measureList = new ArrayList<>();

            // Measure 1
            Measure measure1 = new Measure(4, "treble");
            measure1.addNote(new Note(Pitches.C, "quarter", Accidentals.N, 0, 4, "C4", 4));
            measure1.addNote(new Note(Pitches.D, "quarter", Accidentals.N, 0, 4, "D4", 4));
            measure1.addNote(new Note(Pitches.E, "quarter", Accidentals.N, 0, 4, "E4", 4));
            measure1.addNote(new Note(Pitches.F, "quarter", Accidentals.N, 0, 4, "F4", 4));
            measureList.add(measure1);

            // Measure 2
            Measure measure2 = new Measure(4, "treble");
            measure2.addNote(new Note(Pitches.G, "quarter", Accidentals.N, 0, 4, "G4", 4));
            measure2.addNote(new Note(Pitches.A, "quarter", Accidentals.N, 0, 4, "A4", 4));
            measure2.addNote(new Note(Pitches.B, "quarter", Accidentals.N, 0, 4, "B4", 4));
            measure2.addNote(new Note(Pitches.C, "quarter", Accidentals.N, 0, 5, "C5", 4));
            measureList.add(measure2);

            Keys keySig = Keys.E;
            String defPitchA = "E4";
            String defPitchB = "F#4";
            String defPitchC = "G4";
            String defPitchD = "A4";
            String defPitchE = "B4";
            String defPitchF = "C5";
            String defPitchG = "D5";

            // Create the KeySig object with the necessary parameters
            KeySig keySigObj = new KeySig(keySig, defPitchA, defPitchB, defPitchC, defPitchD, defPitchE, defPitchF,
                    defPitchG);

            Song song = new Song(
                    UUID.randomUUID(),
                    "A Horse's Journey",
                    "NeonWave",
                    application.getUser(testUsername1).getID(),
                    "genre",
                    "10",
                    "120",
                    4, 4,
                    keySigObj,
                    measureList);

            application.makeSong(song);

            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }

            System.out.print("Main Menu");
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println("");
            System.out.print(ANSI_BLACK);
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.print(ANSI_GREEN);
            System.out.println("search for song");
            System.out.print(ANSI_BLACK);
            System.out.println("Which song do you want to play?");
            System.out.print(ANSI_GREEN);
            System.out.println("A horses journey");
            System.out.print(ANSI_BLACK);

            Song chosenSong = application.getSongByTitle("A horses journey");
            Player player = new Player();
            application.playSong(chosenSong);

            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");

            System.out.print(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                isLoggedin = false;
                System.out.println("GoodBye!");
            }

        }

        System.out.println("Login:");
        System.out.print(ANSI_GREEN);
        System.out.println("Username: " + testUsername2);
        System.out.println("Password: " + testPassword2);

        System.out.print(ANSI_BLACK);
        Boolean isLoggedin2 = application.login(testUsername2, testPassword2);
        if (isLoggedin2) {
            application.getUser(testUsername1);
            System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName(testUsername2));
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }

            System.out.print("Main Menu");
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println("");
            System.out.println(
                    "Select an activity: Play song, edit song, Take lesson, log out, search for song, Make song");
            System.out.print(ANSI_GREEN);
            System.out.println("search for song");
            System.out.print(ANSI_BLACK);
            System.out.println("Which song do you want to play?");
            System.out.print(ANSI_GREEN);
            System.out.println("A horses journey");
            System.out.print(ANSI_BLACK);

            Song chosenSong = application.getSongByTitle("A horses journey");
            Player player = new Player();
            application.playSong(chosenSong);

            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.print(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                isLoggedin = false;
                System.out.println("GoodBye!");
            }

        }
    }

    public void scenario1() {
        boolean loggedin = false;
        System.out.println("Would you like to register or log in?");
        System.out.println(ANSI_GREEN);
        System.out.println("Register");
        System.out.println(ANSI_BLACK);
        System.out.println("Give a username");
        System.out.println(ANSI_GREEN);
        System.out.println("Username: NeonWave");
        System.out.println(ANSI_BLACK);
        if (!application.availableUsername("NeonWave")) {
            System.out.println("This username already exists");
        }
        System.out.println(ANSI_GREEN);
        System.out.println("Username: ShadowWave");
        System.out.println(ANSI_BLACK);
        if (application.availableUsername("ShadowWave")) {
            // should be safe to regiser
            System.out.println("Username is available");
            System.out.println("Please enter the required information");
            System.out.println(ANSI_GREEN);
            System.out.println("Username: ShadowWave");
            System.out.println("First name: Shawn");
            System.out.println("Last name: Black");
            System.out.println("email: blackshadow@example.com");
            System.out.println("password: ridingwaves");
            System.out.println(ANSI_BLACK);
            System.out.println("Would you like to be a teacher?");
            System.out.println(ANSI_GREEN);
            System.out.println("No");
            System.out.println(ANSI_BLACK);

            application.register("ShadowWave", "Shawn", "Black", "blackshadow@example.com", "ridingwaves", false);
            loggedin = true;
        } else {
            System.out.println("This username already exists");
        }
        if (loggedin) {
            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.println(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                loggedin = false;
                System.out.println("GoodBye!");
            }

        }
        // login
        String testUsername = "ShadowWave";
        String testPassword = "ridingwaves";
        System.out.println("Login:");
        System.out.println("Username: " + testUsername);
        System.out.println("PasswordS: " + testPassword);
        Boolean isLogin = application.login(testUsername, testPassword);
        if (isLogin) {
            System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName(testUsername));
        }

    }

    public void run() {
        scenario2(); // login and play a song
        // scenario3();
        // scenario1();

    }

    private void displayMainMenu() {

    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();

    }

}