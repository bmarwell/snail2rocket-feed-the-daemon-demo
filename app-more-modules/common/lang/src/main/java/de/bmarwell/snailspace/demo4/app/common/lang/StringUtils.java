package de.bmarwell.snailspace.demo4.app.common.lang;

public class StringUtils {

    public static boolean isNullOrEmpty(final String str) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return str == null || str.trim().isEmpty();
    }

}
