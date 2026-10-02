import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testWithOneArgumentAndPath(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

    @Test
  void testWithOnlyPath(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }


  @Test
  void testThrowsWhenPathNotPresent() throws IllegalArgumentException {
    // Arrange: Prepare the arguments
    
    String[] args = {"-nc", "-h"};

    // Assert: Check that throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      TruffulaOptions options = new TruffulaOptions(args);
    });
  }

  @Test
  void testThrowsWhenArgumentInvalid(@TempDir File tempDir) throws IllegalArgumentException {
     // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();

    String[] args = {"-nc", "sdhfie", directoryPath};

    // Assert: Check that throws IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> {
      TruffulaOptions options = new TruffulaOptions(args);
    });
  }

  @Test
  void testThrowsWhenPathIsFile(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory

    File file = new File(tempDir, "file.txt");

    String directoryPath = file.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};


    // Assert: Check that the root directory is set correctly
    assertThrows(FileNotFoundException.class, () -> {
       TruffulaOptions options = new TruffulaOptions(args);
    });
  }
}
