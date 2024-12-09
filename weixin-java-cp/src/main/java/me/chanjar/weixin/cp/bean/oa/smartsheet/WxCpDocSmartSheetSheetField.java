package me.chanjar.weixin.cp.bean.oa.smartsheet;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class WxCpDocSmartSheetSheetField implements Serializable {
  private static final long serialVersionUID = -2819036643480825143L;
  /**
   * 字段标题，需要更新为的字段标题
   */
  @SerializedName("field_title")
  private String fieldTitle;
  /**
   * 字段类型，见FieldType ，必须为原属性
   */
  @SerializedName("field_type")
  private String fieldType;

  public static WxCpDocSmartSheetSheetField fromJson(String json) {
    return WxCpGsonBuilder.create().fromJson(json, WxCpDocSmartSheetSheetField.class);
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
