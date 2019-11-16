package com.fpt.hr_management.daoImpl.leave;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fpt.hr_management.connection.DbConnection;
import com.fpt.hr_management.listener.response.leave.LeaveListGetAllResponse;

public class LeaveListGetAll {
	private Connection con;
	private Statement stm;
	private ResultSet rs;

	public List<LeaveListGetAllResponse> get() {
		String sql = "select el.*, e.full_name as employeeName, r.name as reasonName from employee_leave el join leave_reason_type r on r.id = el.reason_id join employee e on e.id = el.employee_id;";
		List<LeaveListGetAllResponse> listLeave = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listLeave = new ArrayList<LeaveListGetAllResponse>();
				if (rs != null) {
					LeaveListGetAllResponse objLev = null;
					while (rs.next()) {
						objLev = new LeaveListGetAllResponse();
						objLev.setId(rs.getInt("id"));
						objLev.setEmployee_id(rs.getInt("employee_id"));
						objLev.setReason_id(rs.getInt("reason_id"));
						objLev.setStart_date(rs.getDate("start_date"));
						objLev.setEnd_date(rs.getDate("end_date"));
						objLev.setStart_time(rs.getTime("start_time"));
						objLev.setEnd_time(rs.getTime("end_time"));
						objLev.setCreated_time(rs.getTime("created_time"));
						objLev.setEmployee_accept(rs.getString("employee_accept"));
						objLev.setAccept_time(rs.getTimestamp("accept_time"));
						objLev.setAccept_status(rs.getInt("accept_status"));
						if (rs.getInt("accept_status") == 0) {
							objLev.setAcceptStatusName("Đang chờ");
						}

						if (rs.getInt("accept_status") == 1) {
							objLev.setAcceptStatusName("Đã duyệt");
						}

						objLev.setEmployeeName(rs.getString("employeeName"));
						objLev.setReasonName(rs.getString("reasonName"));

						listLeave.add(objLev);
					}

					System.out.println(listLeave.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listLeave;
	}

	public List<LeaveListGetAllResponse> getName() {
		String sql = "select * from leave_reason_type";
		List<LeaveListGetAllResponse> listLeave = null;
		try {
			con = DbConnection.getConnection();
			stm = con.createStatement();
			if (con != null && stm != null && sql != null) {
				rs = stm.executeQuery(sql);
				listLeave = new ArrayList<LeaveListGetAllResponse>();
				if (rs != null) {
					LeaveListGetAllResponse objLev = null;
					while (rs.next()) {
						objLev = new LeaveListGetAllResponse();
						objLev.setType_name(rs.getString("name"));
						objLev.setIdReason(rs.getInt("id"));
						listLeave.add(objLev);
					}

					System.out.println(listLeave.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(con, null, stm, rs);
		}
		return listLeave;
	}

	public static void main(String[] args) {
		LeaveListGetAll main = new LeaveListGetAll();
		main.get();
	}
}
