package app.nzyme.plugin;

import app.nzyme.plugin.dot11.Dot11Frame;
import app.nzyme.plugin.dot11.Dot11MetaInformation;

public interface RemoteConnector {

    void notifyUplinks(Notification notification, Dot11MetaInformation meta);
    void notifyUplinksOfAlert(Alert alert);

    void forwardFrame(Dot11Frame frame);

}

