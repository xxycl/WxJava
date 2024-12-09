package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 新建智能表格子表.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpDocSmartSheetAddRecordRequest implements Serializable {
  private static final long serialVersionUID = 6361982822454395538L;

  /**
   * 文档的docid
   */
  @SerializedName("docid")
  private String docId;

  /**
   * 文档的docid
   */
  @SerializedName("sheet_id")
  private String sheetId;
  @SerializedName("key_type")
  private String keyType;
  /**
   * 智能表属性
   */
  @SerializedName("records")
  private List<AddRecord> records;

  @Getter
  @Setter
  public static class AddRecord implements Serializable {
    private static final long serialVersionUID = -4860239393895754599L;
    @SerializedName("values")
    private Map<String, WxCpDocSmartSheetFieldValue> values;


    public static AddRecord fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, AddRecord.class);
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public JsonObject toJsonObj() {
      JsonObject jsonObject=new JsonObject();
      values.forEach((k,v)->{
        switch (v.getType()){
          case "num": {
            jsonObject.addProperty(k, v.getNumberValue());
            break;
          }
          case "text": {
            jsonObject.add(k, v.toObjArray());
            break;
          }
          default: {
            jsonObject.add(k, v.toObj());
          }
        }

      });


      return jsonObject;
    }
  }

  public static WxCpDocSmartSheetAddRecordRequest fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetAddRecordRequest.class);
  }

  /**
   * To json string.
   *
   * @return the string
   */
  public JsonObject toJson() {
    JsonObject messageJson = new JsonObject();
    if (this.getDocId() != null) {
      messageJson.addProperty("docid", this.getDocId());
    }
    if (this.getSheetId() != null) {
      messageJson.addProperty("sheet_id", this.getSheetId());
    }
//    if (this.getKeyType() != null) {
//      messageJson.addProperty("key_type", this.getKeyType());
//    }
    if (this.getRecords() != null) {
      JsonArray recordsJson = new JsonArray();
      for (AddRecord record : this.getRecords()) {
        JsonObject valueJson=new JsonObject();
        valueJson.add("values",record.toJsonObj());
        recordsJson.add(valueJson);
      }
      messageJson.add("records", recordsJson);
    }
    JsonElement array = new Gson().toJsonTree(messageJson);

    return  array.getAsJsonObject();
  }
  private void handleFileType(AddRecord addRecord){

  }

}
