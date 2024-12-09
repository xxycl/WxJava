package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 新建智能表格子表.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpDocSmartSheetAddSheetFieldData implements Serializable {
  private static final long serialVersionUID = 5257746210879914028L;
  /**
   * 智能表属性
   */
  @SerializedName("fields")
  private List<SmartSheetFiledProperties> fields;

  @Getter
  @Setter
  public static class SmartSheetFiledProperties implements Serializable {
    private static final long serialVersionUID = -4860239393895754599L;
    /**
     * 字段 ID
     */
    @SerializedName("field_id")
    private String field_id;
    /**
     * 字段标题
     */
    @SerializedName("field_title")
    private String fieldTitle;
    /**
     * 字段类型
     */
    @SerializedName("field_type")
    private String fieldType;



    public static SmartSheetFiledProperties fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, SmartSheetFiledProperties.class);
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
      return WxCpGsonBuilder.create().toJson(this);
    }
  }

  public static WxCpDocSmartSheetAddSheetFieldData fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetAddSheetFieldData.class);
  }

  /**
   * To json string.
   *
   * @return the string
   */
  public String toJson() {
    return WxCpGsonBuilder.create().toJson(this);
  }

}
