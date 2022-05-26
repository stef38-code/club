package org.stephane.club.share.tools;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CustomTime {
    private CustomTime() {
        throw new UnsupportedOperationException("CustomTime is a utility class and cannot be instantiated");
    }
    public static String findDifferenceWithStringFormat(LocalDateTime from, LocalDateTime to) {
        //
        String strHeure = formatText(ChronoUnit.HOURS.between(from, to), "%d h ");
        String strMinutes = formatText(ChronoUnit.MINUTES.between(from, to), "%d m ");
        String strSecondes = formatText(ChronoUnit.SECONDS.between(from, to), "%d s ");
        String strMillisecondes = formatText(ChronoUnit.MILLIS.between(from, to), "%d ms");

        return "".concat(strHeure).concat(strMinutes).concat(strSecondes).concat(strMillisecondes);
    }

    private static String formatText(long value, String text) {
        if (value <= 0 || StringUtils.isEmpty(text)) {
            return StringUtils.EMPTY;
        }
        return String.format(text, value);
    }
}
