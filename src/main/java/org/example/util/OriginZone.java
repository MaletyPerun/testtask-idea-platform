package org.example.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class OriginZone {
    public static final Map<String, String> ORIGIN_ZONE = Map.of("VVO", "+10", "TLV", "+02");
}
