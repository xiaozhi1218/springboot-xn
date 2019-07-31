package com.mtl.member.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * 会员管理实体类
 *
 * @author lsc
 * @since 2019-07-31
 */
@Data
@Table(name="mtl_member")
@ApiModel(value = "Member对象", description = "会员管理")

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员编号
     */
    @ApiModelProperty(value = "会员编号")
    @Id

  private Integer memberId;
    /**
     * 代理商编号
     */
    @ApiModelProperty(value = "代理商编号")
  
  private Integer agentId;
    /**
     * 上级编号（店铺id或者是医院id）
     */
    @ApiModelProperty(value = "上级编号（店铺id或者是医院id）")
  
  private Integer parentId;
    /**
     * 等级编号
     */
    @ApiModelProperty(value = "等级编号")
  
  private Integer lvId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
  
  private String userName;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
  
  private String email;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
  
  private String password;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
  
  private LocalDateTime regtime;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
  
  private String name;
    /**
     * 性别（0男，1女）
     */
    @ApiModelProperty(value = "性别（0男，1女）")
  
  private Integer sex;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
  
  private Long birthday;
    /**
     * 预付款
     */
    @ApiModelProperty(value = "预付款")
  
  private BigDecimal advance;
    /**
     * 省份编号
     */
    @ApiModelProperty(value = "省份编号")
  
  private Integer provinceId;
    /**
     * 城市编号
     */
    @ApiModelProperty(value = "城市编号")
  
  private Integer cityId;
    /**
     * 地区编号
     */
    @ApiModelProperty(value = "地区编号")
  
  private Integer regionId;
    /**
     * 城镇编号
     */
    @ApiModelProperty(value = "城镇编号")
  
  private Integer townId;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
  
  private String province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
  
  private String city;
    /**
     * 地区
     */
    @ApiModelProperty(value = "地区")
  
  private String region;
    /**
     * 城镇
     */
    @ApiModelProperty(value = "城镇")
  
  private String town;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
  
  private String address;
    /**
     * 邮政编号
     */
    @ApiModelProperty(value = "邮政编号")
  
  private String zip;
    /**
     * 移动电话
     */
    @ApiModelProperty(value = "移动电话")
  
  private String mobile;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
  
  private String tel;
    /**
     * 余额
     */
    @ApiModelProperty(value = "余额")
  
  private BigDecimal balance;
    /**
     * mmc金额
     */
    @ApiModelProperty(value = "mmc金额")
  
  private BigDecimal mmcMoney;
    /**
     * 充值金额
     */
    @ApiModelProperty(value = "充值金额")
  
  private BigDecimal chargeMoney;
    /**
     * 总收入（红包+积分返利）
     */
    @ApiModelProperty(value = "总收入（红包+积分返利）")
  
  private BigDecimal incomeMoney;
    /**
     * 消费金额
     */
    @ApiModelProperty(value = "消费金额")
  
  private BigDecimal consumeMoney;
    /**
     * 积分
     */
    @ApiModelProperty(value = "积分")
  
  private Integer point;
    /**
     * 消费积分
     */
    @ApiModelProperty(value = "消费积分")
  
  private Integer consumePoint;
    /**
     * 剩余积分
     */
    @ApiModelProperty(value = "剩余积分")
  
  private Integer overPoints;
    /**
     * 积分返利
     */
    @ApiModelProperty(value = "积分返利")
     @Column(name = "Pending_profit")

  private BigDecimal pendingProfit;
    /**
     * 剩余mmc返利
     */
    @ApiModelProperty(value = "剩余mmc返利")
  
  private BigDecimal overProfit;
    /**
     * 消费积分mmc
     */
    @ApiModelProperty(value = "消费积分mmc")
  
  private BigDecimal consumeProfit;
    /**
     * 已返利（捡红包）
     */
    @ApiModelProperty(value = "已返利（捡红包）")
  
  private BigDecimal rebate;
    /**
     * 会员积分
     */
    @ApiModelProperty(value = "会员积分")
  
  private Integer mp;
    /**
     * QQ账号
     */
    @ApiModelProperty(value = "QQ账号")
     @Column(name = "QQ")

  private String qq;
    /**
     * msn账号
     */
    @ApiModelProperty(value = "msn账号")
  
  private String msn;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
  
  private String remark;
    /**
     * 最后一次登录
     */
    @ApiModelProperty(value = "最后一次登录")
  
  private Long lastlogin;
    /**
     * 是否是代理商(0、没有 1、有）
     */
    @ApiModelProperty(value = "是否是代理商(0、没有 1、有）")
  
  private Integer isAgent;
    /**
     * 登录次数
     */
    @ApiModelProperty(value = "登录次数")
  
  private Integer logincount;
    /**
     * 是否审核
     */
    @ApiModelProperty(value = "是否审核")
  
  private Integer isChecked;
    /**
     * 注册ip地址
     */
    @ApiModelProperty(value = "注册ip地址")
  
  private String registerip;
    /**
     * 推荐积分声明
     */
    @ApiModelProperty(value = "推荐积分声明")
  
  private Integer recommendPointState;
    /**
     * 最后一次寄出的邮件
     */
    @ApiModelProperty(value = "最后一次寄出的邮件")
  
  private Integer lastSendEmail;
    /**
     * 完整信息
     */
    @ApiModelProperty(value = "完整信息")
  
  private Integer infoFull;
    /**
     * 发现编码
     */
    @ApiModelProperty(value = "发现编码")
  
  private String findCode;
    /**
     * 脸(头像)
     */
    @ApiModelProperty(value = "脸(头像)")
  
  private String face;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
  
  private String nickname;
    /**
     * 中间实体
     */
    @ApiModelProperty(value = "中间实体")
  
  private Integer midentity;
    /**
     * 过期的
     */
    @ApiModelProperty(value = "过期的")
  
  private Integer disabled;
    /**
     * 身份证图
     */
    @ApiModelProperty(value = "身份证图")
  
  private String avatar;
    /**
     * 未审核原因
     */
    @ApiModelProperty(value = "未审核原因")
  
  private String reason;
    /**
     * 会费
     */
    @ApiModelProperty(value = "会费")
  
  private Integer memberFee;
    /**
     * 实名
     */
    @ApiModelProperty(value = "实名")
  
  private String realName;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
  
  private LocalDateTime updateTime;
    /**
     * 身份证
     */
    @ApiModelProperty(value = "身份证")
  
  private String idCard;
    /**
     * 0-启用（待审核）1-（审核通过）2-禁用 3-审核中4-审核不通过
     */
    @ApiModelProperty(value = "0-启用（待审核）1-（审核通过）2-禁用 3-审核中4-审核不通过")
  
  private Integer state;
    /**
     * 0-注册会员、1-医院院长、2-医院操作员、3-医生、4-商家
     */
    @ApiModelProperty(value = "0-注册会员、1-医院院长、2-医院操作员、3-医生、4-商家")
  
  private Integer type;
    /**
     * 微信openId
     */
    @ApiModelProperty(value = "微信openId")
  
  private String openId;
    /**
     * 剩余金额
     */
    @ApiModelProperty(value = "剩余金额")
  
  private BigDecimal overMoney;
    /**
     * 有效期
     */
    @ApiModelProperty(value = "有效期")
  
  private LocalDateTime validTime;
    /**
     * 推荐人类型（0-商家店铺，1-医院）
     */
    @ApiModelProperty(value = "推荐人类型（0-商家店铺，1-医院）")
  
  private Integer parentType;


}
