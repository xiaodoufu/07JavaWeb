package cn.bdqn.util;

/**
 *  所有方法的返回状态 工具类
 */
public class ReturnResult {
	private int status; // 状态 1 成功 -1 失败
	private Object data; // 返回的数据
	private String message = "操作成功"; // 返回的数据

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 有数据返回
	public ReturnResult ReturnSuccess(Object data) {
		this.data = data;
		this.status = 1;
		return this;
	}

	public ReturnResult ReturnSuccess() {
		this.status = 1;
		return this;
	}

	// 失败
	public ReturnResult ReturnFail(String message) {
		this.status = -1;
		this.message = message;
		return this;
	}

	public ReturnResult(int status, Object data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public ReturnResult() {
		super();
	}

}
