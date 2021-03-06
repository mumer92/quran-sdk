package com.tazkiyatech.quran.sdk.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HizbQuarterUnitTests {

    @Test
    fun parse_forHizbNumber1andQuarterNumber1() {
        // When.
        val hizbQuarter = HizbQuarter.parse(1, 1)

        // Then.
        assertEquals(HizbQuarter.Hizb_01_Quarter_01, hizbQuarter)
    }

    @Test
    fun parse_forHizbNumber60andQuarterNumber4() {
        // When.
        val hizbQuarter = HizbQuarter.parse(60, 4)

        // Then.
        assertEquals(HizbQuarter.Hizb_60_Quarter_04, hizbQuarter)
    }

    @Test
    fun getHizbNumber_and_getQuarterNumber_forAllHizbQuarters() {
        // Given.
        val hizbQuarters = HizbQuarter.values()

        // When. / Then.
        var expectedHizbNumber = 1
        var expectedQuarterNumber = 1

        for (hizbQuarter in hizbQuarters) {
            assertEquals(expectedHizbNumber, hizbQuarter.hizbNumber)
            assertEquals(expectedQuarterNumber, hizbQuarter.quarterNumber)

            if (expectedQuarterNumber == 4) {
                expectedHizbNumber++
                expectedQuarterNumber = 1
            } else {
                expectedQuarterNumber++
            }
        }
    }

    @Test
    fun getNumVerses_forAllHizbQuarters() {
        // Given.
        val hizbQuarters = HizbQuarter.values()

        // When.
        var verseCount = 0

        for (hizbQuarter in hizbQuarters) {
            val numVerses = hizbQuarter.numVerses
            verseCount += numVerses
        }

        // Then.
        assertEquals(6236, verseCount)
    }
}