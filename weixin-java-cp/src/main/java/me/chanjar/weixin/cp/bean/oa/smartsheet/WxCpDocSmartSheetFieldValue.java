package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpDocSmartSheetFieldValue implements Serializable {
  private static final long serialVersionUID = 8234723472347234724L;

  @SerializedName("type")
  private String type;

  @SerializedName("text")
  private String text;

  @SerializedName("link")
  private String link;

  @SerializedName("value")
  private Object value; // 可以是多种类型，如double, boolean, List<Option>, etc.

  private Double numberValue;

  @SerializedName("image_url")
  private String imageUrl;

  @SerializedName("width")
  private Integer width;

  @SerializedName("height")
  private Integer height;

  @SerializedName("name")
  private String name;

  @SerializedName("size")
  private Integer size;

  @SerializedName("file_ext")
  private String fileExt;

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("file_url")
  private String fileUrl;

  @SerializedName("file_type")
  private String fileType;

  @SerializedName("doc_type")
  private String docType;

  @SerializedName("user_id")
  private String userId;

  @SerializedName("latitude")
  private String latitude;

  @SerializedName("longitude")
  private String longitude;

  @SerializedName("source_type")
  private Integer sourceType;

  @SerializedName("title")
  private String title;

  @SerializedName("options")
  private List<Option> options;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @Accessors(chain = true)
  public static class Option implements Serializable {
    private static final long serialVersionUID = 8234723472347234725L;

    @SerializedName("id")
    private String id;

    @SerializedName("style")
    private Integer style;

    @SerializedName("text")
    private String text;
  }

  public static WxCpDocSmartSheetFieldValue buildTextCell(String text, String content, boolean safe) {
    final WxCpDocSmartSheetFieldValue fieldValue = new WxCpDocSmartSheetFieldValue();
    fieldValue.setText(text);
    fieldValue.setType("text");
//    message.setMsgType(WxCpConsts.AppChatMsgType.TEXT);
//    message.setContent(content);
//    message.setChatId(chatId);
//    message.setSafe(safe);
    return fieldValue;
  }

  public static WxCpDocSmartSheetFieldValue buildNum(Double num) {
    final WxCpDocSmartSheetFieldValue fieldValue = new WxCpDocSmartSheetFieldValue();
    fieldValue.setNumberValue(num);
    fieldValue.setType("num");
//    message.setMsgType(WxCpConsts.AppChatMsgType.TEXT);
//    message.setContent(content);
//    message.setChatId(chatId);
//    message.setSafe(safe);
    return fieldValue;
  }

  public JsonObject toObj() {
    JsonObject obj = new JsonObject();
    switch (this.getType()) {
      case "text": {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", this.getText());
        jsonObject.addProperty("type", "text");

        obj = jsonObject;


        break;
      }
      default: {
        //do nothing
      }
    }
    return obj;
  }

  public JsonArray toObjArray() {
    JsonArray jsonArray = new JsonArray();
    JsonObject obj = new JsonObject();
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("text", this.getText());
    jsonObject.addProperty("type", "text");
    jsonArray.add(jsonObject);

    return jsonArray;
  }
}
