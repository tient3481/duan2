package com.fpt.hr_management.daoImpl.employee_skill;

public class SkillEmployeeAdd {
//	private Connection con;
//	private PreparedStatement pstm;

//	public void add(SkillE request) {
//		String sql = "INSERT INTO employee_leave(INSERT INTO `hr_management`.`skill_employee`(`employee_id`, `skill_id`, `skill_main`, `skill_start`, `skill_end`, `level_id`, `created_by`, `last_modifier_by`) VALUES (?,?,?,?,?,?,?,?);";
//		try {
//			con = DbConnection.getConnection();
//			if (con != null) {
//				pstm = con.prepareStatement(sql);
//				pstm.setInt(1, request.getEmployee_id());
//				pstm.setInt(2, request.getReason_id());
//				pstm.setDate(3, request.getStart_date());
//				pstm.setDate(4, request.getEnd_date());
//				pstm.setTime(5, request.getStart_time());
//				pstm.setTime(6, request.getEnd_time());
//				pstm.setInt(7, 0);
//				pstm.setString(8, request.getNote());
//				pstm.setString(9, request.getCreated_by());
//				pstm.setString(10, request.getLast_modifier_by());
//
//				pstm.executeUpdate();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DbConnection.close(con, pstm, null, null);
//		}
//	}
}
