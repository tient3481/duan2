package com.fpt.hr_management.daoImpl.checkinout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.request.checkin.CheckInGetTimeRequest;
import com.fpt.hr_management.listener.response.checkinout.CheckOutGetTimeResponse;

public class CheckInGetTimeSize {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private List<CheckOutGetTimeResponse> listTotalTimeSize;

	public long getTimeSize(CheckInGetTimeRequest request) {
		StringBuilder sbTotalTime = null;
		CheckOutGetTimeResponse resTime = null;
		long totalTime = 0;
		String sql = "SELECT total_time FROM check_in_history WHERE user_id = ? and date between '"
				+ request.getCheck_in_time() + "' AND '" + request.getCheck_out_time() + "';";
		System.out.println(sql);
		try {
			con = DbConnection.getConnection();
			if (con != null) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, request.getId());
				ResultSet rs = pstm.executeQuery();
				listTotalTimeSize = new ArrayList<CheckOutGetTimeResponse>();
				while (rs.next()) {
					resTime = new CheckOutGetTimeResponse();
					resTime.setTotal_time(rs.getTime("total_time"));

					listTotalTimeSize.add(resTime);
				}

				long totalSeconds = 0;
				long totalMinutes = 0;
				long totalHours = 0;
				String arrTime[] = new String[listTotalTimeSize.size()];
				for (int i = 0; i < listTotalTimeSize.size(); i++) {
					arrTime[i] = String.valueOf(listTotalTimeSize.get(i).getTotal_time());
					resTime.setArrTime(arrTime);
					totalHours += Long.parseLong(arrTime[i].substring(0, 2));
					totalMinutes += Long.parseLong(arrTime[i].substring(3, 5));
					totalSeconds += Long.parseLong(arrTime[i].substring(6, 8));
				}

				sbTotalTime = new StringBuilder();
				sbTotalTime.append(totalHours == 0 ? "00"
						: totalHours < 10 ? String.valueOf("0" + totalHours) : String.valueOf(totalHours));
				sbTotalTime.append(":");
				sbTotalTime.append(totalMinutes == 0 ? "00"
						: totalMinutes < 10 ? String.valueOf("0" + totalMinutes) : String.valueOf(totalMinutes));
				sbTotalTime.append(":");
				sbTotalTime.append(totalSeconds == 0 ? "00"
						: totalSeconds < 10 ? String.valueOf("0" + totalSeconds) : String.valueOf(totalSeconds));

				CheckInService service = new CheckInService();
				totalTime = service.hourToMinute(totalHours, totalMinutes, totalSeconds);

				System.out.println(totalTime + "- " + sbTotalTime.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, pstm, null, rs);
		}

		return totalTime;
	}

	public static void main(String[] args) {
		CheckInGetTimeSize main = new CheckInGetTimeSize();
		CheckInGetTimeRequest request = new CheckInGetTimeRequest();
		request.setId(1);
		request.setCheck_in_time("2019-12-01");
		request.setCheck_out_time("2019-12-31");

		main.getTimeSize(request);
	}
}
