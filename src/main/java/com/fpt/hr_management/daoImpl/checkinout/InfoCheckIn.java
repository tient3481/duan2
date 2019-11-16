package com.fpt.hr_management.daoImpl.checkinout;

public class InfoCheckIn {

	private int keyGenerate;
	private int user_id;

	public InfoCheckIn() {
		super();
	}

	public InfoCheckIn(int keyGenerate, int user_id) {
		super();
		this.keyGenerate = keyGenerate;
		this.user_id = user_id;
	}

	public int getKeyGenerate() {
		return keyGenerate;
	}

	public void setKeyGenerate(int keyGenerate) {
		this.keyGenerate = keyGenerate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoCheckIn [keyGenerate=").append(keyGenerate).append(", user_id=").append(user_id)
				.append("]");
		return builder.toString();
	}

}
