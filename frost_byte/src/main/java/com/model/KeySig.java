package com.model;

import org.json.simple.JSONObject;

/**
 * This class is used to store the key signature of a piece of music. It
 * contains
 * the key signature and the default pitches for each note in the key signature.
 * 
 * @author FrostByte
 */
public class KeySig {
    private Keys keySig;
    private String defPitchA;
    private String defPitchB;
    private String defPitchC;
    private String defPitchD;
    private String defPitchE;
    private String defPitchF;
    private String defPitchG;

    /**
     * Constructor for KeySig class.
     * 
     * @param keySig    the key signature of the piece of music.
     * @param defPitchA the default pitch for note A.
     * @param defPitchB the default pitch for note B.
     * @param defPitchC the default pitch for note C.
     * @param defPitchD the default pitch for note D.
     * @param defPitchE the default pitch for note E.
     * @param defPitchF the default pitch for note F.
     * @param defPitchG the default pitch for note G.
     */
    public KeySig(Keys keySig, String defPitchA, String defPitchB, String defPitchC, String defPitchD, String defPitchE,
            String defPitchF, String defPitchG) {
        this.keySig = keySig;
        this.defPitchA = defPitchA;
        this.defPitchB = defPitchB;
        this.defPitchC = defPitchC;
        this.defPitchD = defPitchD;
        this.defPitchE = defPitchE;
        this.defPitchF = defPitchF;
        this.defPitchG = defPitchG;
    }

    /**
     * Constructor for KeySig class that takes a Key as a parameter.
     * 
     * @param keySig the key signature of the piece of music.
     */
    public void setKeySig(Keys keySig) {
        this.keySig = keySig;
    }

    /**
     * sets the default pitch for note A.
     * 
     * @param defPitchA the default pitch for note A.
     */
    public void setDefPitchA(String defPitchA) {
        this.defPitchA = defPitchA;
    }

    /**
     * sets the default pitch for note B.
     * 
     * @param defPitchB the default pitch for note B.
     */
    public void setDefPitchB(String defPitchB) {
        this.defPitchB = defPitchB;
    }

    /**
     * sets the default pitch for note C.
     * 
     * @param defPitchC the default pitch for note C.
     */
    public void setDefPitchC(String defPitchC) {
        this.defPitchC = defPitchC;
    }

    /**
     * sets the default pitch for note D.
     * 
     * @param defPitchD the default pitch for note D.
     */
    public void setDefPitchD(String defPitchD) {
        this.defPitchD = defPitchD;
    }

    /**
     * sets the default pitch for note E.
     * 
     * @param defPitchE the default pitch for note E.
     */
    public void setDefPitchE(String defPitchE) {
        this.defPitchE = defPitchE;
    }

    /**
     * sets the default pitch for note F.
     * 
     * @param defPitchF the default pitch for note F.
     */
    public void setDefPitchF(String defPitchF) {
        this.defPitchF = defPitchF;
    }

    /**
     * sets the default pitch for note G.
     * 
     * @param defPitchG the default pitch for note G.
     */
    public void setDefPitchG(String defPitchG) {
        this.defPitchG = defPitchG;
    }

    /**
     * returns the key signature.
     * 
     * @return the key signature.
     */
    public Keys getKeySig() {
        return keySig;
    }

    /**
     * returns the default pitch for note A.
     * 
     * @return the default pitch for note A.
     */
    public String getDefPitchA() {
        return defPitchA;
    }

    /**
     * returns the default pitch for note B.
     * 
     * @return the default pitch for note B.
     */
    public String getDefPitchB() {
        return this.defPitchB;
    }

    /**
     * returns the default pitch for note C.
     * 
     * @return the default pitch for note C.
     */
    public String getDefPitchC() {
        return defPitchC;
    }

    /**
     * returns the default pitch for note D.
     * 
     * @return the default pitch for note D.
     */
    public String getDefPitchD() {
        return defPitchD;
    }

    /**
     * returns the default pitch for note E.
     * 
     * @return the default pitch for note E.
     */
    public String getDefPitchE() {
        return defPitchE;
    }

    /**
     * returns the default pitch for note F.
     * 
     * @return the default pitch for note F.
     */
    public String getDefPitchF() {
        return defPitchF;
    }

    /**
     * returns the default pitch for note G.
     * 
     * @return the default pitch for note G.
     */
    public String getDefPitchG() {
        return defPitchG;
    }

    /**
     * Constructor for KeySig class that takes a JSONObject as a parameter.
     * 
     * @param jsonKeySig the JSONObject that contains the key signature of the piece
     *                   of music.
     */
    public KeySig(JSONObject jsonKeySig) {
        this.keySig = Keys.valueOf((String) jsonKeySig.get("keySig"));
        this.defPitchA = (String) jsonKeySig.get("defPitchA");
        this.defPitchB = (String) jsonKeySig.get("defPitchB");
        this.defPitchC = (String) jsonKeySig.get("defPitchC");
        this.defPitchD = (String) jsonKeySig.get("defPitchD");
        this.defPitchE = (String) jsonKeySig.get("defPitchE");
        this.defPitchF = (String) jsonKeySig.get("defPitchF");
        this.defPitchG = (String) jsonKeySig.get("defPitchG");
    }
}
