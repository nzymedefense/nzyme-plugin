package app.nzyme.plugin.dot11;

public interface Dot11Frame {

    byte frameType();
    Dot11MetaInformation meta();
    byte[] payload();
    byte[] header();

}
