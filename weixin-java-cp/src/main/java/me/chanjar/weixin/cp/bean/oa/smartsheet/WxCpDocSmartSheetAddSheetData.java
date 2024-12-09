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
public class WxCpDocSmartSheetAddSheetData implements Serializable {
  private static final long serialVersionUID = 6361982822454395538L;
  /**
   * 文档的docid
   */
  @SerializedName("docid")
  private String docId;
  /**
   * 智能表属性
   */
  @SerializedName("properties")
  private SmartSheetProperties properties;

  @Getter
  @Setter
  public static class SmartSheetProperties implements Serializable {
    private static final long serialVersionUID = -4860239393895754599L;
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
    /**
     * 智能表id
     */
    @SerializedName("sheet_id")
    private String sheetId;


    public static SmartSheetProperties fromJson(String json) {
      return WxCpGsonBuilder.create().fromJson(json, SmartSheetProperties.class);
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

  public static WxCpDocSmartSheetAddSheetData fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetAddSheetData.class);
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
