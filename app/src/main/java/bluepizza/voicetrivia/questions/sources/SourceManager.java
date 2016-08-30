/*
Author  : Jin
Owner   : Jin
Date    : 22-Aug-2016
 */

package bluepizza.voicetrivia.questions.sources;

import java.io.*;
import java.util.*;

/**
 * Created by jin on 22/08/16.
 */
public final class SourceManager {

    //region Variables

    /**
     * The directory where sources are located.
     */
    private static String _sourcesFolder;

    /**
     * The list of locally available sources.
     */
    private static ArrayList<String> _localSources;

    //endregion

    //region Initialization

    // Prevents user from instantiating this type
    private SourceManager() {}

    /**
     * Type initializer for SourceManager. This block is executed upon
     * referencing this class.
     */
    static {
        _sourcesFolder = null;
        _localSources = new ArrayList<String>();
    }

    //endregion

    //region Getters & Setters

    /**
     * Gets the directory where sources are located.
     * @return The directory where sources are located.
     */
    public static String getSourcesFolder(){
        return _sourcesFolder;
    }

    /**
     * Sets the directory where sources are located.
     * @param value The directory where sources are located.
     */
    public static void setSourcesFolder(String value) {
        _sourcesFolder = value;
    }

    /**
     * Gets the list of locally available sources.
     * @return The list of locally available sources.
     */
    public static ArrayList<String> getLocalSources() {
        return _localSources;
    }

//endregion

    //region Methods

    /**
     * Refreshes the local sources by scanning the local sources folder for CSV files.
     */
    public static void refreshSources() {

        File folder = new File(getSourcesFolder());
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.getName().endsWith(".csv"))
            fileEntry.getName();
        }
    }

    //endregion

}
