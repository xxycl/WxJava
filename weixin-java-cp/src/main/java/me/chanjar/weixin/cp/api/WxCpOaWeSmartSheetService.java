package me.chanjar.weixin.cp.api;

import lombok.NonNull;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.bean.WxCpBaseResp;
import me.chanjar.weixin.cp.bean.oa.doc.*;
import me.chanjar.weixin.cp.bean.oa.smartsheet.*;

/**
 * 企业微信智能表格相关接口.
 * <a href="https://developer.work.weixin.qq.com/document/path/99896">文档</a>
 *
 * @author Hugo
 */
public interface WxCpOaWeSmartSheetService {
  /**
   * 该接口用于获取文档数据
   * 请求方式：POST（HTTPS）
   * 请求地址: https://qyapi.weixin.qq.com/cgi-bin/wedoc/document/get?access_token=ACCESS_TOKEN
   * @param docId
   * @throws WxErrorException
   */
  void getSheet(@NonNull String docId,String sheetId) throws WxErrorException;

  /**
   * 添加子表
   * 本接口用于在表格的某个位置添加一个智能表，该智能表不存在视图、记录和字段，可以使用 API 在该智能表中添加视图、记录和字段
   * <p>
   * 请求方式：POST（HTTPS）
   * 请求地址: https://qyapi.weixin.qq.com/cgi-bin/wedoc/smartsheet/add_sheet?access_token=ACCESS_TOKEN
   *
   * @param request 新建文档对应请求参数
   * @return url：新建文档的访问链接，docid：新建文档的docid
   * @throws WxErrorException the wx error exception
   */
  WxCpDocSmartSheetAddSheetData addSheet(@NonNull WxCpDocSmartSheetAddSheetRequest request) throws WxErrorException;


//  /**
//   *  本接口用于删除在线表格中的某个智能表。
//   * 请求方式：POST(HTTPS)
//   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/wedoc/smartsheet/delete_sheet?access_token=ACCESS_TOKEN
//   * @param docId 文档的docid
//   * @param sheetId 子表ID
//   * @return
//   * @throws WxErrorException
//   */
//  WxCpBaseResp sheetDelete(String docId, String sheetId) throws WxErrorException;
//
//  /**
//   * 本接口用于修改表格中某个子表的标题。
//   * 请求方式：POST(HTTPS)
//   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/wedoc/smartsheet/update_sheet?access_token=ACCESS_TOKEN
//   * @param title
//   * @param sheetId 子表ID
//   * @return
//   * @throws WxErrorException
//   */
//  WxCpBaseResp sheetUpdate(String title, String sheetId) throws WxErrorException;

  /**
   * 本接口用于在智能表中的某个子表里添加一列或多列新字段。单表最多允许有150个字段。
   * 请求方式：POST(HTTPS)
   * 请求地址：https://qyapi.weixin.qq.com/cgi-bin/wedoc/smartsheet/add_fields?access_token=ACCESS_TOKEN
   * @param request
   * @return
   * @throws WxErrorException
   */
  WxCpDocSmartSheetAddSheetFieldData addSheetFiled(@NonNull WxCpDocSmartSheetAddSheetFiledRequest request) throws WxErrorException;

  void getField(@NonNull String docId,@NonNull String sheetId) throws WxErrorException;


  void getRecord(@NonNull String docId,@NonNull  String sheetId) throws WxErrorException;

  void addRecord(@NonNull WxCpDocSmartSheetAddRecordRequest wxCpDocSmartSheetAddRecordRequest) throws WxErrorException;

}
