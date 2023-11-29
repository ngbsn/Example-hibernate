package org.mycompany.mysql.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public static int generateRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
