package com.fpt.hr_management.dao;

import java.util.List;

import com.fpt.hr_management.listener.request.position.PositionAddRequest;
import com.fpt.hr_management.listener.request.position.PositionUpdateRequest;
import com.fpt.hr_management.model.position.Position;

public interface DaoPosition {

	public List<Position> positionListGetAll();

	public void positionAdd(PositionAddRequest request);

	public void positionUpdate(PositionUpdateRequest request);

	public void positionDelete(int positionId);

	public void positionInfoGetOne(int positionId);
}
