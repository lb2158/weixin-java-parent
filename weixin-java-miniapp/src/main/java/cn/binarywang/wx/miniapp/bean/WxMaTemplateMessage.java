package cn.binarywang.wx.miniapp.bean;

import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 参考 https://mp.weixin.qq.com/debug/wxadoc/dev/api/notice.html#接口说明  模板消息部分
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
@Builder
public class WxMaTemplateMessage implements Serializable {
  private static final long serialVersionUID = 5063374783759519418L;

  /**
   * <pre>
   * 参数：touser
   * 是否必填： 是
   * 描述： 接收者（用户）的 openid
   * </pre>
   */
  private String toUser;

  /**
   * <pre>
   * 参数：template_id
   * 是否必填： 是
   * 描述： 所需下发的模板消息的id
   * </pre>
   */
  private String templateId;

  /**
   * <pre>
   * 参数：page
   * 是否必填： 否
   * 描述： 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
   * </pre>
   */
  private String page;

  /**
   * <pre>
   * 参数：form_id
   * 是否必填： 是
   * 描述： 表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
   * </pre>
   */
  private String formId;

  /**
   * <pre>
   * 参数：data
   * 是否必填： 是
   * 描述： 模板内容，不填则下发空模板
   * </pre>
   */
  @Builder.Default
  private final List<Data> data = new ArrayList<>();

  /**
   * <pre>
   * 参数：color
   * 是否必填： 否
   * 描述： 模板内容字体的颜色，不填默认黑色
   * </pre>
   */
  private String color;

  /**
   * <pre>
   * 参数：emphasis_keyword
   * 是否必填： 否
   * 描述： 模板需要放大的关键词，不填则默认无放大
   * </pre>
   */
  private String emphasisKeyword;

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }

  @lombok.Data
  public static class Data {
    private String name;
    private String value;
    private String color;

    public Data(String name, String value) {
      this.name = name;
      this.value = value;
    }

    public Data(String name, String value, String color) {
      this.name = name;
      this.value = value;
      this.color = color;
    }

  }

}
