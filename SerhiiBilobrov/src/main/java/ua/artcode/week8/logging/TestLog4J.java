package ua.artcode.week8.logging;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

import java.io.IOException;

/**
 * Created by serhii on 30.08.15.
 */
public class TestLog4J {

    public static void main(String[] args) throws IOException {
        // ua.artcode.week8.logging.TestLog4J
        Logger logger = LogManager.getLogger(TestLog4J.class);

        logger.setLevel(Level.INFO);

        Layout layout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
        Appender appenderConsole = new ConsoleAppender(layout);

        logger.addAppender(appenderConsole);
        logger.addAppender(new FileAppender(layout, "/home/serhii/dev/IdeaProjects/ACP7/temp/log.txt"));

        logger.info("In system");


        // lifecycle - config(loggers, appender, linking) ; using loggers





    }

}
