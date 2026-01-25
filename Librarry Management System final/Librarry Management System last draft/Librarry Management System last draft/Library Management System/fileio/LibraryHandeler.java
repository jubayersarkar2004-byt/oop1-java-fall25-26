package fileio;

import entity.Library;
import java.io.*;

public class LibraryHandeler {
    private static final String FILE_PATH = "fileio/books.txt";
    private static final int MAX = 1000;

    // Create
    public static void addLibrary(Library library) throws IOException {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdir(); // Creates directory if dosen't exists

        FileWriter fw = new FileWriter(file, true);// Append means old data stays and new data added
        fw.write(library.toFileString() + "\n");
        fw.close();

    }

    // Read
    public static Library[] getAllLibraries() throws IOException {
        Library[] libraries = new Library[MAX];
        int index = 0;
        String line;

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return libraries;// if file dosen't exist returns empty array
        }

        BufferedReader br = new BufferedReader(new FileReader(file));// Bufferreader reads line by line while Filereader
                                                                     // reads character by character
        while ((line = br.readLine()) != null && index < MAX) {
            libraries[index] = Library.fromFileString(line);
            index++;
        }
        br.close();
        return libraries;   // return array of libraries
    }

    // Update
    public static void updateLibrary(Library updatedLibrary) throws IOException {
        Library[] libraries = getAllLibraries();
        FileWriter fw = new FileWriter(FILE_PATH);

        for (Library lib : libraries) {
            if (lib != null) {
                if (lib.getBookName().equals(updatedLibrary.getBookName())) {
                    fw.write(updatedLibrary.toFileString() + "\n");
                } else {
                    fw.write(lib.toFileString() + "\n");
                }
            }
        }
        fw.close();
    }

    // Search book name
    public static Library searchLibrary(String bookName) throws IOException {

        Library[] libraries = getAllLibraries();// get all books

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && libraries[i].getBookName().equals(bookName)) {
                return libraries[i];// return all books
            }

        }

        return null;// not found
    }

    // search author

    public static Library searchAuthorLibrary(String author) throws IOException {

        Library[] libraries = getAllLibraries();// get all books

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && libraries[i].getAuthor().equals(author)) {
                return libraries[i];// return all books
            }

        }

        return null;// not found
    }

    // search volume

    public static Library searchVolumeLibrary(String volume) throws IOException {

        Library[] libraries = getAllLibraries();// get all books

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && libraries[i].getVolume().equals(volume)) {
                return libraries[i];// return all books
            }

        }

        return null;// not found
    }

    // Delete
    public static void deleteLibrary(String bookName) throws IOException {

        Library[] libraries = getAllLibraries();
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && !libraries[i].getBookName().equals(bookName)) {
                fw.write(libraries[i].toFileString() + "\n");// write existing library
            }
        }
        fw.close();

    }

    // delete author
    public static void deleteAuthorLibrary(String author) throws IOException {

        Library[] libraries = getAllLibraries();
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && !libraries[i].getAuthor().equals(author)) {
                fw.write(libraries[i].toFileString() + "\n");// write existing library
            }
        }
        fw.close();

    }

    // delete volume
    public static void deleteVolumeLibrary(String volume) throws IOException {

        Library[] libraries = getAllLibraries();
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < libraries.length; i++) {
            if (libraries[i] != null && !libraries[i].getVolume().equals(volume)) {
                fw.write(libraries[i].toFileString() + "\n");// write existing library
            }
        }
        fw.close();

    }

}
