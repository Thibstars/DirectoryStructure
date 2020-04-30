package be.thibaulthelsmoortel.directory;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author Thibault Helsmoortel
 */
class DirectoryStructureTest {

    @Test
    void shouldGetTree() {
        File folder = new File(System.getProperty("user.dir"));
        final String tree = DirectoryStructure.getTree(folder);

        Assertions.assertFalse(StringUtils.isBlank(tree), "Result must not be blank.");
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DirectoryStructure.getTree(new File("test")),
            "Method call should result in exception.");
    }
}