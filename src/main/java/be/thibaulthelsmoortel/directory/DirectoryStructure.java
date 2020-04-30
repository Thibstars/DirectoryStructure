package be.thibaulthelsmoortel.directory;

import java.io.File;
import java.util.Objects;

/**
 * @author Thibault Helsmoortel
 */
public class DirectoryStructure {

    private static final String BRANCH = "|  ";
    private static final String NEWLINE = "\n";
    private static final String SPLIT = "+--";
    private static final String DIR_END = "/";

    private DirectoryStructure() {
        // Prevent instantiation
    }

    /**
     * Constructs the directory tree of a given folder.
     *
     * @param folder the folder of which to print the tree
     * @return the constructed directory tree
     */
    public static String getTree(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Provided file is not a directory.");
        }

        int indent = 0;
        StringBuilder sb = new StringBuilder();
        constructTree(folder, indent, sb);

        return sb.toString();
    }

    private static void constructTree(File folder, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent))
            .append(SPLIT)
            .append(folder.getName())
            .append(DIR_END)
            .append(NEWLINE);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                constructTree(file, indent + 1, sb);
            } else {
                appendFile(file, indent + 1, sb);
            }
        }

    }

    private static void appendFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent))
            .append(SPLIT)
            .append(file.getName())
            .append(NEWLINE);
    }

    private static String getIndentString(int indent) {
        return BRANCH.repeat(Math.max(0, indent));
    }

}
