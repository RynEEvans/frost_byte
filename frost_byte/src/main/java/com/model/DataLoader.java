package com.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Data Loader Class. This class extends the DataConstants and reads through
 * each JSON file to return an ArrayList of Users.
 */
public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJson.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJson.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String userName = (String) personJSON.get(USER_USER_NAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String password = (String) personJSON.get(USER_PASSWORD);
                boolean isTeacher = Boolean.parseBoolean(personJSON.get(USER_ACCOUNT_TYPE).toString());

                users.add(new User(id, userName, firstName, lastName, email, password, isTeacher));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();

        try {
            FileReader reader = new FileReader("json\\lessons.json");
            JSONParser parser = new JSONParser();
            JSONArray lessonsJson = (JSONArray) parser.parse(reader);

            for (int i = 0; i < lessonsJson.size(); i++) {
                JSONObject lessonJSON = (JSONObject) lessonsJson.get(i);
                lessons.add(parseLessonJSON(lessonJSON));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader reader = new FileReader("frost_byte\\src\\main\\java\\com\\model\\ztestSongs.json");
            JSONParser parser = new JSONParser();
            JSONArray songJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < songJson.size(); i++) {
                JSONObject songJSON = (JSONObject) songJson.get(i);
                UUID id = UUID.fromString((String) songJSON.get("id"));
                String title = (String) songJSON.get("title");
                UUID author = null;
                if (songJSON.containsKey("author")) {
                    try {
                        author = UUID.fromString((String) songJSON.get("author"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String artist = (String) songJSON.get("artist");
                String genre = (String) songJSON.get("genre");
                String duration = (String) songJSON.get("duration");
                String tempo = (String) songJSON.get("tempo");
                // Handle time signature, Long or Int value
                int defTimeSigNumer = (songJSON.get("defTimeSigNumer") instanceof Long)
                    ? ((Long) songJSON.get("defTimeSigNumer")).intValue()
                    : Integer.parseInt((String) songJSON.get("defTimeSigNumer"));
                int defTimeSigDenom = (songJSON.get("defTimeSigDenom") instanceof Long)
                    ? ((Long) songJSON.get("defTimeSigDenom")).intValue()
                    : Integer.parseInt((String) songJSON.get("defTimeSigDenom"));
                String defKeySigStr = (String) songJSON.get("defKeySig");
                KeySig defKeySig = new KeySig(Keys.valueOf(defKeySigStr), "A", "B", "C", "D", "E", "F", "G");
                JSONArray measuresJSON = (JSONArray) songJSON.get("measureList");
                ArrayList<Measure> measures = new ArrayList<Measure>();
                for (int j = 0; j < measuresJSON.size(); j++) {
                    JSONObject measureJSON = (JSONObject) measuresJSON.get(j);
                    int beatAmount = Integer.parseInt((String)measureJSON.get("beatAmount"));
                    String clef = (String) measureJSON.get("clef");
                    
                    JSONArray notes = (JSONArray) measureJSON.get("notes");

                    ArrayList<Note> noteList = new ArrayList<Note>();
                    for (int r = 0; r < notes.size(); r++) {
                        JSONObject noteJSON = (JSONObject) notes.get(r);
                        Note note = new Note();
                        String tempPitch = (String) noteJSON.get("pitch");
                        Pitches notePitch = Pitches.valueOf(tempPitch);
                        note.setPitch(notePitch);
                        String tempAccidental = (String) noteJSON.get("accidental");
                        tempAccidental = tempAccidental.toUpperCase();
                        Accidentals noteAccidetal = Accidentals.valueOf(tempAccidental);
                        note.setAccidental(noteAccidetal);
                        note.setOctave(Integer.parseInt((String) noteJSON.get("octave")));
                        note.setLength((String) noteJSON.get("length"));
                        noteList.add(note);
                        
                    }
                    Measure measure = new Measure(beatAmount, clef, noteList);
                    measures.add(measure);
                }

                songs.add(new Song(id, title, artist, author, genre, duration, tempo, defTimeSigNumer, defTimeSigDenom, defKeySig, measures));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    private static Lesson parseLessonJSON(JSONObject jsonLesson) {
        UUID id = UUID.fromString((String) jsonLesson.get("id"));
        String title = (String) jsonLesson.get("title");
        String description = (String) jsonLesson.get("description");
        String content = (String) jsonLesson.get("content");

        ArrayList<Flashcard> flashcards = new ArrayList<>();
        JSONArray flashcardsArray = (JSONArray) jsonLesson.get("flashcards");
        for (int i = 0; i < flashcardsArray.size(); i++) {
            JSONObject flashcardJSON = (JSONObject) flashcardsArray.get(i);
            String term = (String) flashcardJSON.get("term");
            String definition = (String) flashcardJSON.get("definition");
            flashcards.add(new Flashcard(term, definition));
        }

        JSONObject quizJSON = (JSONObject) jsonLesson.get("quiz");
        String question = (String) quizJSON.get("question");
        JSONArray optionsArray = (JSONArray) quizJSON.get("options");
        ArrayList<String> options = new ArrayList<>();
        for (Object option : optionsArray) {
            options.add(option.toString());
        }
        String answer = (String) quizJSON.get("answer");
        Quiz quiz = new Quiz(question, options, answer);

        JSONObject songJSON = (JSONObject) jsonLesson.get("song");
        Song song = parseSongJSON(songJSON);

        return new Lesson(id, title, description, content, flashcards, quiz, song);
    }

    private static Song parseSongJSON(JSONObject jsonSong) {
        UUID id = UUID.fromString((String) jsonSong.get("id"));
        String title = (String) jsonSong.get("title");
        String artist = (String) jsonSong.get("artist");
        UUID author = null;
        if (jsonSong.containsKey("author")) {
            try {
                author = UUID.fromString((String) jsonSong.get("author"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String genre = (String) jsonSong.get("genre");
        String duration = (String) jsonSong.get("duration");
        String tempo = (String) jsonSong.get("tempo");

        // Handle time signature, Long or Int value
        int defTimeSigNumer = (jsonSong.get("defTimeSigNumer") instanceof Long)
                ? ((Long) jsonSong.get("defTimeSigNumer")).intValue()
                : Integer.parseInt((String) jsonSong.get("defTimeSigNumer"));
        int defTimeSigDenom = (jsonSong.get("defTimeSigDenom") instanceof Long)
                ? ((Long) jsonSong.get("defTimeSigDenom")).intValue()
                : Integer.parseInt((String) jsonSong.get("defTimeSigDenom"));

        // Parse key signature, accepting JSONObject
        String defKeySigStr = (String) jsonSong.get("defKeySig");
        KeySig defKeySig = new KeySig(Keys.valueOf(defKeySigStr), "A", "B", "C", "D", "E", "F", "G");
        // Parse measures
        JSONArray measuresArray = (JSONArray) jsonSong.get("measureList");
        if (measuresArray == null) {
            measuresArray = new JSONArray();
        }
        ArrayList<Measure> measuresArrayList = new ArrayList<>();
        for (Object measureObj : measuresArray) {
            if (measureObj instanceof JSONObject) {
                JSONObject measureJSON = (JSONObject) measureObj;
                Measure measure = new Measure();

                // Parse measure meta-data
                measure.setBeatAmount(Integer.parseInt((String) measureJSON.get("beatAmount")));
                measure.setClef((String) measureJSON.get("clef"));

                // Parse notes
                JSONArray notesArray = (JSONArray) measureJSON.get("notes");
                ArrayList<Note> notes = new ArrayList<>();
                for (Object noteObj : notesArray) {
                    if (noteObj instanceof JSONObject) {
                        JSONObject noteJSON = (JSONObject) noteObj;
                        Note note = new Note();
                        String tempPitch = (String) noteJSON.get("pitch");
                        tempPitch = tempPitch.toUpperCase();
                        Pitches notePitch;
                        notePitch = Pitches.valueOf(tempPitch);
                        note.setPitch(notePitch);
                        String tempAccidental = (String) noteJSON.get("accidental");
                        tempAccidental = tempAccidental.toUpperCase();
                        Accidentals noteAccidental;
                        noteAccidental = Accidentals.valueOf(tempAccidental);
                        note.setAccidental(noteAccidental);
                        note.setOctave(Integer.parseInt((String) noteJSON.get("octave")));
                        note.setLength((String) noteJSON.get("length"));
                        notes.add(note);
                    }
                }
                measure.setNotes(notes);
                measuresArrayList.add(measure);
            }
        }

        return new Song(id, title, artist, author, genre, duration, tempo,
                defTimeSigNumer, defTimeSigDenom, defKeySig, measuresArrayList);

    }

    // DataLoader Tests
    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("Loading songs >>>");
        ArrayList<Song> songs = DataLoader.getSongs();
        for (Song song : songs) {
            System.out.println(song);
        }

        /*
         * System.out.println("Loading lessons >>>");
         * ArrayList<Lesson> lessons = DataLoader.getLessons();
         * for (Lesson lesson : lessons) {
         * System.out.println(lesson);
         * }
         */

    }

}