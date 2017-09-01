package cn.bdqn.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址
 */
public class UserAddress implements Serializable {

	private Integer id;
	private String address; // 地址
	private Integer userId; // 用户编号
	private Integer isDefault; // 是否是默认地址（1:是 0否）
	private Date createTime;// 创建时间
	private String remark; // 备注

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public UserAddress(Integer id, String address, Integer userId,
			Integer isDefault, Date createTime, String remark) {
		super();
		this.id = id;
		this.address = address;
		this.userId = userId;
		this.isDefault = isDefault;
		this.createTime = createTime;
		this.remark = remark;
	}

	public UserAddress() {
		super();
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", address=" + address + ", userId="
				+ userId + ", isDefault=" + isDefault + ", createTime="
				+ createTime + ", remark=" + remark + "]";
	}

}
