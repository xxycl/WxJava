package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 新建智能表格字段.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WxCpDocSmartSheetAddSheetFiledRequest implements Serializable {
  private static final long serialVersionUID = -7778555572523212250L;
  /**
   * 文档的docid
   */
  @SerializedName("docid")
  private String docId;
  /**
   * 表格ID
   */
  @SerializedName("sheet_id")
  private String sheetId;
  /**
   * 智能表字段
   */
  @SerializedName("fields")
  private List<WxCpDocSmartSheetSheetField> fields;

  public static WxCpDocSmartSheetAddSheetFiledRequest fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetAddSheetFiledRequest.class);
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
