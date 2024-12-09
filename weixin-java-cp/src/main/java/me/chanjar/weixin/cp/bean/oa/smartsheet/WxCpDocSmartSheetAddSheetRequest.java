package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;

/**
 * 新建智能表格子表.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpDocSmartSheetAddSheetRequest implements Serializable {
  private static final long serialVersionUID = -4960239393895454137L;
  /**
   * 文档的docid
   */
  @SerializedName("docid")
  private String docId;
  /**
   * 智能表属性
   */
  @SerializedName("properties")
  private SmartSheetCreateProperties properties;

  @Getter
  @Setter
  public static class SmartSheetCreateProperties implements Serializable {
    private static final long serialVersionUID = 3493651261034157394L;
    /**
     * 智能表标题
     */
    @SerializedName("title")
    private String title;

    /**
     * 智能表下标
     */
    @SerializedName("index")
    private Long index;

    public static SmartSheetCreateProperties fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, SmartSheetCreateProperties.class);
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

  public static WxCpDocSmartSheetAddSheetRequest fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetAddSheetRequest.class);
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
