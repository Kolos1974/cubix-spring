package hu.cubix.hr.kolos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.hr.kolos.dto.HolidayRequestDto;
import hu.cubix.hr.kolos.model.HolidayRequest;

@Mapper(componentModel = "spring")
public interface HolidayRequestMapper {

	
	List<HolidayRequestDto> holidayRequestsToDtos(List<HolidayRequest> holidayRequests);	

	@Mapping(source = "employee.employeeId", target = "employeeId")
	@Mapping(source = "approver.employeeId", target = "approverId")	
	HolidayRequestDto holidayRequestToDto(HolidayRequest holidayRequest);

	@Mapping(target = "employee", ignore = true)
	@Mapping(target = "approver", ignore = true)
	HolidayRequest dtoToHolidayRequest(HolidayRequestDto holidayRequestDto);

	List<HolidayRequest> dtosToHolidayRequests(List<HolidayRequestDto> holidayRequestDtos);

}
