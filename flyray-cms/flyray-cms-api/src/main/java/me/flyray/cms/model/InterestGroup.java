package me.flyray.cms.model;

/** 
* @author: bolei
* @date：2017年8月26日 上午8:50:48
* @description：兴趣小组
*/

public class InterestGroup {

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 所属机构
	 */
	private Long orgId;
	
	/**
	 * 所属商户
	 */
	private Long merchantId;
	
	/**
	 * 小组名称
	 */
	private String groupName;
	
	/**
	 * 小组logo
	 */
	private String groupLogo;
	
	/**
	 * 小组口号
	 */
	private String groupSlogan;
	
	/**
	 * 小组简介
	 */
	private String groupIntro;
	
	/**
	 * 小组创建时间
	 */
	private String createTime;
	
	/**
	 * 小组创建人
	 */
	private String custmerNo;
	
	/**
	 * 小组地址
	 */
	private String groupAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupLogo() {
		return groupLogo;
	}

	public void setGroupLogo(String groupLogo) {
		this.groupLogo = groupLogo;
	}

	public String getGroupSlogan() {
		return groupSlogan;
	}

	public void setGroupSlogan(String groupSlogan) {
		this.groupSlogan = groupSlogan;
	}

	public String getGroupIntro() {
		return groupIntro;
	}

	public void setGroupIntro(String groupIntro) {
		this.groupIntro = groupIntro;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCustmerNo() {
		return custmerNo;
	}

	public void setCustmerNo(String custmerNo) {
		this.custmerNo = custmerNo;
	}

	public String getGroupAddress() {
		return groupAddress;
	}

	public void setGroupAddress(String groupAddress) {
		this.groupAddress = groupAddress;
	}
	
}
