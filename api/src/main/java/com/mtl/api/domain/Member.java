package com.mtl.api.domain;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员管理实体类
 *
 * @author lsc
 * @since 2019-05-05
 */
@Data
@Table(name = "mtl_member")
@ApiModel(value = "Member对象", description = "会员管理")

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员编号
     */
    @ApiModelProperty(value = "会员编号")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    /**
     * 代理商编号
     */
    @ApiModelProperty(value = "代理商编号")

    private Integer agentId;
    /**
     * 上级编号
     */
    @ApiModelProperty(value = "上级编号")

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

    private Date regtime;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")

    private String name;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")

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

    private Double advance;
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

    private Double balance;
    /**
     * mmc金额
     */
    @ApiModelProperty(value = "mmc金额")

    private Double mmcMoney;
    /**
     * 充值金额
     */
    @ApiModelProperty(value = "充值金额")

    private Double chargeMoney;
    /**
     * 总收入（红包+积分返利）
     */
    @ApiModelProperty(value = "总收入（红包+积分返利）")

    private Double incomeMoney;
    /**
     * 消费金额
     */
    @ApiModelProperty(value = "消费金额")

    private Double consumeMoney;
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

    private Double pendingProfit;
    /**
     * 剩余返利
     */
    @ApiModelProperty(value = "剩余返利")

    private Double overProfit;
    /**
     * 消费积分mmc
     */
    @ApiModelProperty(value = "消费积分mmc")

    private Double consumeProfit;
    /**
     * 已返利（捡红包）
     */
    @ApiModelProperty(value = "已返利（捡红包）")

    private Double rebate;
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
     * 是否是代理商
     */
    @ApiModelProperty(value = "是否是代理商")

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

    private Integer isCheked;
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
     * 脸
     */
    @ApiModelProperty(value = "脸")

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
     * 区域id
     */
    @ApiModelProperty(value = "区域id")

    private Integer regionsId;


    private String token;

    private Integer favoriteGood;//收藏商品
    private Integer unReceivedNumber;//待收货
    private Integer unSendNumber;//待发货
    private Integer unPayNumber;//待付款
    private Integer coupon;//优惠券
    private Integer refundNumber;//退货数量
    private String openId;

}
