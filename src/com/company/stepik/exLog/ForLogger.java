package com.company.stepik.exLog;

import java.util.logging.*;

import static java.util.logging.Level.ALL;
import static java.util.logging.Level.WARNING;

class ForLogger {

    private static final Logger logger = Logger.getLogger(ForLogger.class.getName());

    public static void main(String[] args) throws Exception {
        logger.log(Level.FINER, "finer");
        logger.log(Level.INFO, "info");
        logger.log(Level.WARNING, "warning", new Throwable());

        Handler consoleHandler = new ConsoleHandler();
//        Handler fileHandler = new FileHandler("/Users/andmat/downloads/LogFiles/MyLOG", true);
        Handler fileHandler = new FileHandler("/Users/andmat/documents/javacode/log_files/mylog", true);

        consoleHandler.setFilter(new MyFilter());
//        fileHandler.setFilter(new MyFilter());

        consoleHandler.setFormatter(new MyFormatter());

        logger.setUseParentHandlers(false);     //off console output
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
        logger.info("Hi");
        logger.info("Hi Andrew");
//        new StreamHandler();
//        new SocketHandler();

        configureLogging();
    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("drew");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage();
        }
    }


    private static void configureLogging() {
//        Logger logger = Logger.getLogger("org.stepic.java");
        System.out.println();
        Logger logger = Logger.getLogger(ForLogger.class.getName());
        logger.setLevel(Level.ALL);
        XMLFormatter f = new XMLFormatter();
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(ALL);
        ch.setFormatter(f);
        logger.addHandler(ch);
        logger.setUseParentHandlers(false);
        logger.warning("adsfa");

        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(WARNING);
    }
}