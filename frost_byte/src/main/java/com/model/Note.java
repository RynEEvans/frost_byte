package com.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * This class is used to store the note of a piece of music. It contains the
 * pitch, length, accidental, dot, and octave of the note.
 * It also contains a method to get the unicode character of the note.
 * 
 * @author Frost Byte
 */
public class Note {
    private Pitches pitch;
    private String length;
    private Accidentals accidental;
    private int dot;
    private int octave;
    private String noteSymbol;
    private int duration;

    /**
     * Constructor for Note class.
     */
    public Note() {
        this.pitch = null;
        this.length = "";
        this.accidental = null;
        this.dot = 0;
        this.octave = 0;
    }

    public Note(Pitches pitch, int duration) {
        this.pitch = pitch;
        this.duration = duration;
    }

    /**
     * Constructor for Note class.
     * 
     * @param pitch      the pitch of the note.
     * @param length     the length of the note.
     * @param accidental the accidental of the note.
     * @param dot        the dot of the note.
     * @param octave     the octave of the note.
     */
    public Note(Pitches pitch, String length, Accidentals accidental, int dot, int octave, String noteSymbol,
            int duration) {
        this.pitch = pitch;
        this.length = length;
        this.accidental = accidental;
        this.dot = dot;
        this.octave = octave;
        this.noteSymbol = noteSymbol;
        this.duration = duration;
    }

    /**
     * sets a new pitch for the note
     * 
     * @param pitch the pitch of the note.
     */
    public void setPitch(Pitches pitch) {
        this.pitch = pitch;
    }

    /**
     * sets a new length for the note
     * 
     * @param length the length of the note.
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * sets a new accidental for the note
     * 
     * @param accidental the accidental of the note.
     */
    public void setAccidental(Accidentals accidental) {
        this.accidental = accidental;
    }

    /**
     * sets a new dot for the note
     * 
     * @param dot the dot of the note.
     */
    public void setDot(int dot) {
        this.dot = dot;
    }

    /**
     * sets a new octave for the note
     * 
     * @param octave the octave of the note.
     */
    public void setOctave(int octave) {
        this.octave = octave;
    }

    /**
     * sets a new symbol for the note
     * 
     * @param symbol the symbol of the note.
     */
    public void setSymbol(String symbol) {
        this.noteSymbol = symbol;
    }

    /**
     * This getter method returns a String that is the combination of the note's
     * unicode character & the accidental character
     * 
     * @return String
     */
    public String getSymbol() {
        // Unicode handling
        String unicodeSymbol = "";
        if (this.length.equals("w")) {
            unicodeSymbol = "𝅝";
        } else if (this.length.equals("h")) {
            unicodeSymbol = "𝅗𝅥";
        } else if (this.length.equals("q")) {
            unicodeSymbol = "𝅘𝅥";
        } else if (this.length.equals("e")) {
            unicodeSymbol = "𝅘𝅥𝅮";
        } else if (this.length.equals("s")) {
            unicodeSymbol = "𝅘𝅥𝅯";
        } else if (this.length.equals("t")) {
            unicodeSymbol = "𝅘𝅥𝅰";
        } else if (this.length.equals("x")) {
            unicodeSymbol = "𝅘𝅥𝅱";
        } else if (this.length.equals("o")) {
            unicodeSymbol = "𝅘𝅥𝅲";
        } else {
            unicodeSymbol = "𝅘𝅥";
        }

        // Accidental handling
        String accidentalSymbol = "";
        if (this.accidental == Accidentals.SHARP) {
            accidentalSymbol = "#";
        } else if (this.accidental == Accidentals.FLAT) {
            accidentalSymbol = "♭";
        } else if (this.accidental == Accidentals.NATURAL) {
            accidentalSymbol = " ";
        }

        return unicodeSymbol + accidentalSymbol;
    }

    /**
     * get the pitch of the note
     * 
     * @return the pitch of the note.
     */
    public Pitches getPitch() {
        return pitch;
    }

    /**
     * get the length of the note
     * 
     * @return the length of the note.
     */
    public String getLength() {
        return length;
    }

    /**
     * get the accidental of the note
     * 
     * @return the accidental of the note.
     */
    public Accidentals getAccidental() {
        return accidental;
    }

    /**
     * get the dot of the note
     * 
     * @return the dot of the note.
     */
    public int getDot() {
        return dot;
    }

    /**
     * get the octave of the note
     * 
     * @return the octave of the note.
     */
    public int getOctave() {
        return octave;
    }

    /**
     * Constructor for Note class that takes a JSONObject as a parameter.
     * 
     * @param noteJSON the JSONObject that contains the note of the piece of music.
     */
    public Note(JSONObject noteJSON) {
        this.pitch = Pitches.valueOf((String) noteJSON.get("pitch"));
        this.length = (String) noteJSON.get("length");
        this.accidental = Accidentals.valueOf((String) noteJSON.get("accidental"));
        this.dot = ((Long) noteJSON.get("dot")).intValue();
        this.octave = ((Long) noteJSON.get("octave")).intValue();
    }
}
