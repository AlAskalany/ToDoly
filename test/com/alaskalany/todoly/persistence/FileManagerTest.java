package com.alaskalany.todoly.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class FileManagerTest {

    private FileManager fileManager;
    private Logger logger;

    /**
     * Setup
     * <p>
     * Reset the FileManager Test Singleton before all tests
     * <p>
     * Source:
     *
     * @throws NoSuchFieldException   Class file doesn't exist
     * @throws IllegalAccessException Instance access is illegal
     */
    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {

        logger = Logger.getLogger(getClass().getName());
        logger.info("FileManagerTest Setup");

        // Reset the FileManager singleton before each test
        // Source:https: http://stackoverflow.com/questions/8256989/singleton-and-unit-testing
        Field ourInstance = FileManager.class.getDeclaredField("ourInstance");
        ourInstance.setAccessible(true);
        ourInstance.set(null, null);

        // Get a new FileManager instance for each test
        fileManager = FileManager.getInstance();
    }

    @AfterEach
    void tearDown() {

        logger.info("FileManagerTest tearDown");
        fileManager = null;
        assertNull(fileManager);
    }

    @DisplayName("Get FileManager singleton instance")
    @Test
    void getFileManagerSingletonInstance() {

        logger.info("Get FileManager singleton instance");

        //region Arrange
        FileManager otherFileManager;
        //endregion

        //region Act
        otherFileManager = FileManager.getInstance();
        //endregion

        //region Assert
        assertSame(fileManager, otherFileManager);
        //assertNotNull(fileManager);
        //endregion
    }
}