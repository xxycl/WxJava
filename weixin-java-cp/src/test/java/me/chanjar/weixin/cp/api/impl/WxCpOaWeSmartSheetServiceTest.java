package me.chanjar.weixin.cp.api.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.cp.api.ApiTestModule;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.oa.doc.WxCpDocCreateData;
import me.chanjar.weixin.cp.bean.oa.doc.WxCpDocCreateRequest;
import me.chanjar.weixin.cp.bean.oa.smartsheet.*;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 只能测试类.
 * 官方文档：https://developer.work.weixin.qq.com/document/path/99896
 *
 * @author XY
 */
@Slf4j
@Guice(modules = ApiTestModule.class)
public class WxCpOaWeSmartSheetServiceTest {


  @Inject
  protected WxCpService wxService;

  private static String  docId="dchBvUzqD3BeN15rMv8B1xnTIoiTFEQ7RNgwhFpVqqa_tTwTPxjCsayQ6F3Wl4blObsWAtWFR9oLVq-2lRcRdB4A";

  /**
   * 创建智能表格
   * @throws Exception
   */
  @Test
  public void testAddSmartDoc() throws Exception {
    WxCpDocCreateRequest wxCpDocCreateRequest=new WxCpDocCreateRequest();
    wxCpDocCreateRequest.setDocName("testSmart");
    wxCpDocCreateRequest.setDocType(10);
    wxCpDocCreateRequest.setAdminUsers(Lists.newArrayList("Chenliang"));
    WxCpDocCreateData wxCpDocCreateData = wxService.getWeDocService().docCreate(wxCpDocCreateRequest);
    System.out.println(wxCpDocCreateData.toJson());
  }

    /**
     * 获得智能文档信息
   * @throws Exception
   */
  @Test
  public void testGetSmartDocInfo() throws Exception {
     wxService.getOaWeSmartSheetService().getSheet(docId,null);
//    System.out.println(wxCpDocInfo.toJson());
  }
  /**
   * Test.
   *
   * @throws Exception the exception
   */
  @Test
  public void testAddSheet() throws Exception {
    WxCpDocSmartSheetAddSheetRequest wxCpDocSmartSheetAddSheetRequest = new WxCpDocSmartSheetAddSheetRequest();


    WxCpDocSmartSheetAddSheetRequest.SmartSheetCreateProperties smartSheetCreateProperties=new WxCpDocSmartSheetAddSheetRequest.SmartSheetCreateProperties();
    smartSheetCreateProperties.setTitle("testSmartSheet");
    smartSheetCreateProperties.setIndex(1L) ;
    wxCpDocSmartSheetAddSheetRequest.setDocId(docId);
    wxCpDocSmartSheetAddSheetRequest.setProperties(smartSheetCreateProperties);
    System.out.println(wxCpDocSmartSheetAddSheetRequest.toJson());
    /**
     * 创建智能表格
     */
    WxCpDocSmartSheetAddSheetData wxCpDocSmartSheetAddSheetData = wxService.getOaWeSmartSheetService().addSheet(wxCpDocSmartSheetAddSheetRequest);
    log.info("获取创建的智能表格返回结果为：{}", wxCpDocSmartSheetAddSheetData.toJson());
    System.out.println(wxCpDocSmartSheetAddSheetData.toJson());
  }

  @Test
  public void testAddSheetFiled() throws Exception {
    WxCpDocSmartSheetAddSheetFiledRequest wxCpDocSmartSheetAddSheetFiledRequest = new WxCpDocSmartSheetAddSheetFiledRequest();
    String docId= "xy_1234";
    List<WxCpDocSmartSheetSheetField> fields=new ArrayList<>();
    WxCpDocSmartSheetSheetField wxCpDocSmartSheetSheetField=new WxCpDocSmartSheetSheetField();
    wxCpDocSmartSheetSheetField.setFieldTitle("标题");
    fields.add(wxCpDocSmartSheetSheetField);

    wxCpDocSmartSheetAddSheetFiledRequest.setDocId(docId);
    wxCpDocSmartSheetAddSheetFiledRequest.setFields(fields);
    WxCpDocSmartSheetAddSheetFieldData wxCpDocSmartSheetAddSheetFieldData = wxService.getOaWeSmartSheetService().addSheetFiled(wxCpDocSmartSheetAddSheetFiledRequest);
    log.info("获取创建的添加字段返回结果为：{}", wxCpDocSmartSheetAddSheetFieldData.toJson());
  }
  @Test
  public void testGetSmartField() throws Exception {
    wxService.getOaWeSmartSheetService().getField(docId,"kQFOBY");
//    System.out.println(wxCpDocInfo.toJson());
  }
  @Test
  public void testGetSmartRecord() throws Exception {
    wxService.getOaWeSmartSheetService().getRecord(docId,"kQFOBY");
//   System.out.println(wxCpDocInfo.toJson());
  }
//
//  @Test
//  public void testAddSheetRecord() throws Exception {
//    WxCpDocSmartSheetAddSheetFiledRequest wxCpDocSmartSheetAddSheetFiledRequest = new WxCpDocSmartSheetAddSheetFiledRequest();
//    String docId= "xy_1234";
//    List<WxCpDocSmartSheetSheetField> fields=new ArrayList<>();
//    WxCpDocSmartSheetSheetField wxCpDocSmartSheetSheetField=new WxCpDocSmartSheetSheetField();
//    wxCpDocSmartSheetSheetField.setFieldTitle("标题");
//    fields.add(wxCpDocSmartSheetSheetField);
//
//    wxCpDocSmartSheetAddSheetFiledRequest.setDocId(docId);
//    wxCpDocSmartSheetAddSheetFiledRequest.setFields(fields);
//    /
//    WxCpDocSmartSheetAddSheetFieldData wxCpDocSmartSheetAddSheetFieldData = wxService.getOaWeSmartSheetService().addSheetFiled(wxCpDocSmartSheetAddSheetFiledRequest);
//    log.info("获取创建的添加字段返回结果为：{}", wxCpDocSmartSheetAddSheetFieldData.toJson());
//  }

  @Test
  public void testGetAddRecord() throws Exception {

    WxCpDocSmartSheetAddRecordRequest addRecordRequest =new WxCpDocSmartSheetAddRecordRequest();
    addRecordRequest.setDocId(docId);
    addRecordRequest.setSheetId("kQFOBY");
    addRecordRequest.setKeyType("1");
    ArrayList<WxCpDocSmartSheetAddRecordRequest.AddRecord> records =new ArrayList<>();
    WxCpDocSmartSheetAddRecordRequest.AddRecord addRecord=new WxCpDocSmartSheetAddRecordRequest.AddRecord();
    HashMap<String, WxCpDocSmartSheetFieldValue> fieldValueMap = new HashMap<String, WxCpDocSmartSheetFieldValue>();
    fieldValueMap.put("创建日期",WxCpDocSmartSheetFieldValue.buildTextCell("2021-08-01", "2021-08-01", false));
    fieldValueMap.put("ok",WxCpDocSmartSheetFieldValue.buildNum(5.00));


    addRecord.setValues(fieldValueMap);

    records.add(addRecord);
    addRecordRequest.setRecords(records);
     Gson gson=new Gson();
//    log.info(addRecordRequest.toJson());

    wxService.getOaWeSmartSheetService().addRecord(addRecordRequest);


//    wxService.getOaWeSmartSheetService().getRecord(docId,"kQFOBY");
////    System.out.println(wxCpDocInfo.toJson());
  }

}
