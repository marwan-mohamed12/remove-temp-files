import java.io.File;

public class TempFileCleaner {

    public static void main(String[] args) {
        // Get system temp directory
        String tempDir = System.getProperty("java.io.tmpdir");

        // Windows-specific temp directories
        String userTemp = System.getenv("TEMP");
        String systemTemp = System.getenv("TMP");
        String prefetchDir = System.getenv("SystemRoot") + "\\Prefetch";

        // Clean each directory
        System.out.println("Cleaning Temp Directory: " + tempDir);
        deleteFilesInDirectory(tempDir);

        System.out.println("Cleaning User Temp Directory: " + userTemp);
        deleteFilesInDirectory(userTemp);

        System.out.println("Cleaning System Temp Directory: " + systemTemp);
        deleteFilesInDirectory(systemTemp);

        System.out.println("Cleaning Prefetch Directory: " + prefetchDir);
        deleteFilesInDirectory(prefetchDir);
    }

    private static void deleteFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.delete()) {
                            System.out.println("Deleted: " + file.getAbsolutePath());
                        } else {
                            System.out.println("Failed to delete: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        // Recursive deletion for subdirectories
                        deleteFilesInDirectory(file.getAbsolutePath());
                        // Attempt to delete the empty directory
                        if (file.delete()) {
                            System.out.println("Deleted Directory: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}
