package app.nzyme.plugin.dot11;

import com.google.common.collect.ImmutableMap;
import org.pcap4j.packet.*;

import java.util.ArrayList;

public class Dot11MetaInformation {

    private static final ImmutableMap<Integer, Integer> map = new ImmutableMap.Builder<Integer, Integer>()
            // 2.4 GHz (802.11b/g/n)
            .put(2412, 1)
            .put(2417, 2)
            .put(2422, 3)
            .put(2427, 4)
            .put(2432, 5)
            .put(2437, 6)
            .put(2442, 7)
            .put(2447, 8)
            .put(2452, 9)
            .put(2457, 10)
            .put(2462, 11)
            .put(2467, 12)
            .put(2472, 13)
            .put(2484, 14)

            // 5 GHz (802.11a/h/j/n/ac)
            .put(5180, 36)
            .put(5200, 40)
            .put(5220, 44)
            .put(5240, 48)
            .put(5260, 52)
            .put(5280, 56)
            .put(5300, 60)
            .put(5320, 64)
            .put(5500, 100)
            .put(5520, 104)
            .put(5540, 108)
            .put(5560, 112)
            .put(5580, 116)
            .put(5600, 120)
            .put(5620, 124)
            .put(5640, 128)
            .put(5660, 132)
            .put(5680, 136)
            .put(5700, 140)
            .put(5745, 149)
            .put(5765, 153)
            .put(5785, 157)
            .put(5805, 161)
            .put(5825, 165)

            .build();

    private final boolean malformed;
    private final int antennaSignal;
    private final int signalQuality;
    private final int frequency;
    private final int channel;
    private final long macTimestamp;
    private final boolean isWep;

    public Dot11MetaInformation(boolean malformed, int antennaSignal, int frequency, int channel, long macTimestamp, boolean isWep) {
        this.malformed = malformed;
        this.antennaSignal = antennaSignal;
        this.signalQuality = calculateSignalQuality(antennaSignal);
        this.channel = channel;
        this.frequency = frequency;
        this.macTimestamp = macTimestamp;
        this.isWep = isWep;
    }

    public boolean isMalformed() {
        return malformed;
    }

    public int getAntennaSignal() {
        return antennaSignal;
    }

    public int getSignalQuality() {
        return signalQuality;
    }

    public int getFrequency() {
        return frequency;
    }

    public long getMacTimestamp() {
        return macTimestamp;
    }

    public int getChannel() {
        return channel;
    }

    public boolean isWep() {
        return isWep;
    }

    public static Dot11MetaInformation parse(ArrayList<RadiotapPacket.RadiotapData> dataFields) {
        int antennaSignal = 0;
        int frequency = 0;
        int channel = -1;

        boolean delimiterCrcError = false;
        boolean badPlcpCrc = false;
        boolean badFcs = false;
        boolean isWep = false;
        long macTimestamp = -1;

        boolean antennaRead = false;
        for (RadiotapPacket.RadiotapData f : dataFields) {
            if(f instanceof RadiotapDataAntennaSignal) {
                if (antennaRead) {
                    /*
                     * In some circumstances, RadioTap might report multiple antenna signal fields, with one of them being wildly
                     * off. Only read the first one.
                     *
                     * I assume this might be related to adapters with multiple antennas or simply a faulty driver.
                     *
                     * Thanks to @mathieubrun for reporting this: https://github.com/lennartkoopmann/nzyme/issues/459
                     */

                    continue;
                }

                antennaSignal = ((RadiotapDataAntennaSignal) f).getAntennaSignalAsInt();
                antennaRead = true;
            } else if (f instanceof RadiotapDataChannel) {
                frequency = ((RadiotapDataChannel) f).getFrequencyAsInt();
                channel = frequencyToChannel(frequency);
            } else if (f instanceof RadiotapDataAMpduStatus) {
                delimiterCrcError = ((RadiotapDataAMpduStatus) f).isDelimiterCrcError();
            } else if (f instanceof RadiotapDataRxFlags) {
                badPlcpCrc = ((RadiotapDataRxFlags) f).isBadPlcpCrc();
            } else if (f instanceof RadiotapDataFlags) {
                badFcs = ((RadiotapDataFlags) f).isBadFcs();
                isWep = ((RadiotapDataFlags) f).isWepEncrypted();
            } else if (f instanceof RadiotapDataTsft) {
                macTimestamp = ((RadiotapDataTsft) f).getMacTimestamp().longValue();
            }
        }

        return new Dot11MetaInformation( delimiterCrcError || badPlcpCrc || badFcs, antennaSignal, frequency, channel, macTimestamp, isWep);
    }

    private int calculateSignalQuality(int antennaSignal) {
        if(antennaSignal >= -50) {
            return 100;
        }

        if(antennaSignal <= -100) {
            return 0;
        }

        return 2*(antennaSignal+100);
    }

    private static int frequencyToChannel(int frequency) {
        if (map.containsKey(frequency)) {
            return map.get(frequency);
        } else {
            return 0;
        }
    }

}
