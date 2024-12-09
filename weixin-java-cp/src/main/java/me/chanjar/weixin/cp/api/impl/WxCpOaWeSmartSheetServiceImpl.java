package me.chanjar.weixin.cp.api.impl;

import com.google.gson.JsonObject;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpOaWeSmartSheetService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.oa.smartsheet.*;
import org.apache.commons.lang3.StringUtils;

import static me.chanjar.weixin.cp.constant.WxCpApiPathConsts.Oa.*;

/**
 * 企业微信智能表格实现类.
 *
 * @author Wang_Wong  created on  2022-04-22
 */
@Slf4j
@RequiredArgsConstructor
public class WxCpOaWeSmartSheetServiceImpl implements WxCpOaWeSmartSheetService {
  private final WxCpService cpService;

  @Override
  public void getSheet(@NonNull String docId, String sheetId) throws WxErrorException {
    String apiUrl= this.cpService.getWxCpConfigStorage().getApiUrl(SMART_SHEET_GET_SHEET);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("docid", docId);
    if(StringUtils.isNotEmpty(sheetId)){
      jsonObject.addProperty("sheet_id", sheetId);
    }
    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
    log.info(responseContent);
  }

  @Override
  public WxCpDocSmartSheetAddSheetData addSheet(@NonNull WxCpDocSmartSheetAddSheetRequest request) throws WxErrorException {
    String apiUrl = this.cpService.getWxCpConfigStorage().getApiUrl(SMART_SHEET_ADD_SHEET);
    String responseContent = this.cpService.post(apiUrl, request.toJson());
    return WxCpDocSmartSheetAddSheetData.fromJson(responseContent);
  }
  @Override
  public WxCpDocSmartSheetAddSheetFieldData addSheetFiled(@NonNull WxCpDocSmartSheetAddSheetFiledRequest request) throws WxErrorException {
    return null;
  }

  @Override
  public void getField(@NonNull String docId, String sheetId) throws WxErrorException {
    String apiUrl= this.cpService.getWxCpConfigStorage().getApiUrl(SMART_SHEET_GET_FIELD);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("docid", docId);
    if(StringUtils.isNotEmpty(sheetId)){
      jsonObject.addProperty("sheet_id", sheetId);
    }
    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
    log.info(responseContent);
  }

  @Override
  public void getRecord(@NonNull String docId, @NonNull String sheetId) throws WxErrorException {
    String apiUrl= this.cpService.getWxCpConfigStorage().getApiUrl(SMART_SHEET_GET_RECORDS);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("docid", docId);
    if(StringUtils.isNotEmpty(sheetId)){
      jsonObject.addProperty("sheet_id", sheetId);
    }
    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
    log.info(responseContent);
  }


  @Override
  public void addRecord(@NonNull WxCpDocSmartSheetAddRecordRequest wxCpDocSmartSheetAddRecordRequest) throws WxErrorException {
    String apiUrl= this.cpService.getWxCpConfigStorage().getApiUrl(SMART_SHEET_ADD_RECORDS);
    String responseContent = this.cpService.post(apiUrl, wxCpDocSmartSheetAddRecordRequest.toJson());
    log.info(responseContent);

  }
//
//  @Override
//  public WxCpBaseResp docRename(@NonNull WxCpDocRenameRequest request) throws WxErrorException {
//    String apiUrl = this.cpService.getWxCpConfigStorage().getApiUrl(WEDOC_RENAME_DOC);
//    String responseContent = this.cpService.post(apiUrl, request.toJson());
//    return WxCpBaseResp.fromJson(responseContent);
//  }
//
//  @Override
//  public WxCpBaseResp docDelete(String docId, String formId) throws WxErrorException {
//    String apiUrl = this.cpService.getWxCpConfigStorage().getApiUrl(WEDOC_DEL_DOC);
//    JsonObject jsonObject = new JsonObject();
//    jsonObject.addProperty("docid", docId);
//    jsonObject.addProperty("formid", formId);
//    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
//    return WxCpBaseResp.fromJson(responseContent);
//  }
//
//  @Override
//  public WxCpDocInfo docInfo(@NonNull String docId) throws WxErrorException {
//    String apiUrl = this.cpService.getWxCpConfigStorage().getApiUrl(WEDOC_GET_DOC_BASE_INFO);
//    JsonObject jsonObject = new JsonObject();
//    jsonObject.addProperty("docid", docId);
//    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
//    return WxCpDocInfo.fromJson(responseContent);
//  }
//
//  @Override
//  public WxCpDocShare docShare(@NonNull String docId) throws WxErrorException {
//    String apiUrl = this.cpService.getWxCpConfigStorage().getApiUrl(WEDOC_DOC_SHARE);
//    JsonObject jsonObject = new JsonObject();
//    jsonObject.addProperty("docid", docId);
//    String responseContent = this.cpService.post(apiUrl, jsonObject.toString());
//    return WxCpDocShare.fromJson(responseContent);
//  }
}
