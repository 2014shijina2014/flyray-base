package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/**
 * @author: bolei
 * @date：2017年8月26日 上午8:50:48
 * @description：兴趣小组
 */

public class InterestGroup extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3822056995269583261L;

	/**
	 * 自增id
	 */
	private String id;

	/**
	 * 小组所属类别
	 */
	private String groupCategoryId;

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

	/**
	 * 状态标识 00：无效；10：推荐；20：置顶
	 */
	private String flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupCategoryId() {
		return groupCategoryId;
	}

	public void setGroupCategoryId(String groupCategoryId) {
		this.groupCategoryId = groupCategoryId;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "InterestGroup [getId()=" + getId() + ", getGroupCategoryId()=" + getGroupCategoryId()
				+ ", getGroupName()=" + getGroupName() + ", getGroupLogo()=" + getGroupLogo() + ", getGroupSlogan()="
				+ getGroupSlogan() + ", getGroupIntro()=" + getGroupIntro() + ", getCreateTime()=" + getCreateTime()
				+ ", getCustmerNo()=" + getCustmerNo() + ", getGroupAddress()=" + getGroupAddress() + ", getFlag()="
				+ getFlag() + ", getMerchantId()=" + getMerchantId() + ", getOrgId()=" + getOrgId() + "]";
	}

}
