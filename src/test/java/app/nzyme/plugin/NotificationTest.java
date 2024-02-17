package app.nzyme.plugin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NotificationTest {

  private Notification notification;

  @BeforeMethod
  public void setup() {
    notification = new Notification("Test Message", 1);
  }

  @Test
  public void addField_AddsFieldToNotification() {
    notification.addField("key", "value");
    Map<String, Object> fields = notification.getAdditionalFields();
    Assert.assertEquals("value", fields.get("key"));
  }

  @Test
  public void addField_IgnoresNullValue() {
    notification.addField("key", null);
    Map<String, Object> fields = notification.getAdditionalFields();
    Assert.assertEquals(1, fields.size());
  }

  @Test
  public void addFields_AddsMultipleFieldsToNotification() {
    Map<String, Object> newFields = new HashMap<>();
    newFields.put("key1", "value1");
    newFields.put("key2", "value2");
    notification.addFields(newFields);
    Map<String, Object> fields = notification.getAdditionalFields();
    Assert.assertEquals("value1", fields.get("key1"));
    Assert.assertEquals("value2", fields.get("key2"));
  }

  @Test
  public void addFields_IgnoresNullValue() {
    notification.addFields(null);
    Map<String, Object> fields = notification.getAdditionalFields();
    Assert.assertEquals(1, fields.size());
  }

  @Test
  public void getMessage_ReturnsMessage() {
    Assert.assertEquals("Test Message", notification.getMessage());
  }

  @Test
  public void toString_ReturnsExpectedString() {
    String expectedString = "802.11 frame: Test Message - Details: channel=1";
    Assert.assertEquals(expectedString, notification.toString());
  }
}
