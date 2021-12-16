package com.fabrisio.bluestore.datamining;

import com.fabrisio.bluestore.datamining.dto.DashboardApplicationDto;
import com.fabrisio.bluestore.datamining.dto.DashboardCompanyDto;
import com.fabrisio.bluestore.datamining.dto.DashboardEmployeeDto;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Override
    public DashboardCompanyDto estatisticasDaCompany() {
        DashboardCompanyDto dashboardCompanyDto = new DashboardCompanyDto();
        return dashboardCompanyDto;
    }

    @Override
    public DashboardEmployeeDto estatisticasDaEmployee() {
        DashboardEmployeeDto dashboardEmployeeDto = new DashboardEmployeeDto();
        return dashboardEmployeeDto;
    }

    @Override
    public DashboardApplicationDto estatisticasDaAplicacao() {
        DashboardApplicationDto dashboardApplicationDto = new DashboardApplicationDto();
        return dashboardApplicationDto;
    }
}
