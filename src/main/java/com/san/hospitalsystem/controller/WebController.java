package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Department;
import com.san.hospitalsystem.entity.Doctor;
import com.san.hospitalsystem.service.IDepartmentService;
import com.san.hospitalsystem.utils.DSA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class WebController {

  @Autowired
  private IDepartmentService departmentService;

  @RequestMapping(value="/wx-access",method={RequestMethod.GET,RequestMethod.POST})
  public void checkWeixinServe(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.info("开始接入微信公众平台");

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String signature = request.getParameter("signature");//微信加密签名
    String timestamp = request.getParameter("timestamp");//时间戳
    String nonce = request.getParameter("nonce");//随机数
    String echostr = request.getParameter("echostr");//随机字符串

    String token = "yigedachoubi";

    String[] strArray = { token, timestamp, nonce };
    Arrays.sort(strArray);

    StringBuilder sb = new StringBuilder();
    for( String str : strArray) sb.append(str);

    String curSignature = DSA.SHA1(sb.toString());

    if (curSignature != null && curSignature.equals(signature)) {
      log.info("成功接入微信公众平台");
      response.getWriter().println(echostr);
    }
    log.error("接入微信公众平台失败");
  }

  @RequestMapping(value = "/getDepartmentById", method = RequestMethod.GET)
  public ServerResponse<List<Department>> getDepartmentById(@RequestParam(value = "id", defaultValue = "0") int id) {
    List<Department> list = departmentService.getDepartment(id);
    return ServerResponse.success(list);
  }

  @RequestMapping(value = "/getDoctorsByDepartmentId", method = RequestMethod.GET)
  public ServerResponse<List<Doctor>> getDoctorsByDepartmentId(int id) {
    List<Doctor> list = departmentService.getDoctorsByDepartmentId(id);
    return ServerResponse.success(list);
  }

  @RequestMapping(value = "/getDoctorById", method = RequestMethod.GET)
  public ServerResponse<Doctor> getDoctorById(int id, HttpSession session) {
    session.setAttribute("sessionId", "5156111");

    System.out.println("session");
    System.out.println(session.getAttribute("sessionId"));
    Doctor doctor = departmentService.getDoctorById(id);
    return ServerResponse.success(doctor);
  }


}
