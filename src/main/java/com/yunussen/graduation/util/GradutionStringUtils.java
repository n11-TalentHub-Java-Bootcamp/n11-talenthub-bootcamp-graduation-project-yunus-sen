package com.yunussen.graduation.util;

import java.util.UUID;

public class GradutionStringUtils {

    private static UUID uuid;

    public static String generatePublicId() {
        uuid=UUID.randomUUID();
        return uuid.toString();
    }
}
